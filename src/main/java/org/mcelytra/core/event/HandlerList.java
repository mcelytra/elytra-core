/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.event;

import org.jetbrains.annotations.NotNull;
import org.mcelytra.core.addon.Addon;
import org.mcelytra.core.addon.RegisteredListener;

import java.util.*;

public class HandlerList
{
    private static final List<HandlerList>                                HANDLER_LISTS = new ArrayList<>();
    private final        EnumMap<EventPriority, List<RegisteredListener>> handlers      = new EnumMap<>(EventPriority.class);
    private volatile     RegisteredListener[]                             baked_handlers;

    /**
     * Bakes every handler lists.
     */
    public static void bake_all()
    {
        synchronized (HANDLER_LISTS) {
            HANDLER_LISTS.forEach(HandlerList::bake);
        }
    }

    /**
     * Unregisters every handlers.
     */
    public static void unregister_all()
    {
        synchronized (HANDLER_LISTS) {
            HANDLER_LISTS.forEach(handlers -> {
                handlers.handlers.values().forEach(List::clear);
                handlers.baked_handlers = null;
            });
        }
    }

    /**
     * Unregisters every listeners from the specified addon.
     *
     * @param addon The addon.
     */
    public static void unregister_all(@NotNull Addon addon)
    {
        synchronized (HANDLER_LISTS) {
            HANDLER_LISTS.forEach(handlers -> handlers.unregister(addon));
        }
    }

    /**
     * Gets every handler lists.
     *
     * @return A list of handler lists.
     */
    @SuppressWarnings("unchecked")
    public static List<HandlerList> get_handler_lists()
    {
        synchronized (HANDLER_LISTS) {
            return (List<HandlerList>) ((ArrayList) HANDLER_LISTS).clone();
        }
    }

    /**
     * Gets the registered listeners of an addon.
     *
     * @param addon The specified addon.
     * @return A list of the registered listeners owned by the addon.
     */
    public static List<RegisteredListener> get_registered_listeners(@NotNull Addon addon)
    {
        List<RegisteredListener> listeners = new ArrayList<>();
        synchronized (HANDLER_LISTS) {
            for (HandlerList handlers : HANDLER_LISTS) {
                handlers.handlers.values().forEach(reg_listeners -> {
                    reg_listeners.stream().filter(listener -> listener.get_addon().equals(addon)).forEach(listeners::add);
                });
            }
        }
        return listeners;
    }

    public HandlerList()
    {
        Arrays.stream(EventPriority.values()).forEach(priority -> handlers.put(priority, new ArrayList<>()));

        synchronized (HANDLER_LISTS) {
            HANDLER_LISTS.add(this);
        }
    }

    /**
     * Adds a registered listener to the handler list.
     *
     * @param listener The registered listener.
     */
    public synchronized void register(@NotNull RegisteredListener listener)
    {
        if (this.handlers.get(listener.get_priority()).contains(listener))
            throw new IllegalStateException("This listener is already registered to priority " + listener.get_priority().toString());
        // Need to re-bake the handler.
        this.baked_handlers = null;
        this.handlers.get(listener.get_priority()).add(listener);
    }

    /**
     * Adds all of the registered listeners to the handler list.
     *
     * @param listeners The registered listeners to add.
     */
    public void register_all(@NotNull Collection<RegisteredListener> listeners)
    {
        listeners.stream().filter(Objects::nonNull).forEach(this::register);
    }

    public synchronized boolean unregister(@NotNull RegisteredListener listener)
    {
        boolean result = this.handlers.get(listener.get_priority()).remove(listener);
        if (result)
            this.baked_handlers = null;
        return result;
    }

    /**
     * Unregisters every listeners from an addon.
     *
     * @param addon The targeted addon.
     */
    public synchronized void unregister(@NotNull Addon addon)
    {
        boolean changed = false;
        for (List<RegisteredListener> listeners : this.handlers.values()) {
            Iterator<RegisteredListener> it = listeners.iterator();
            while (it.hasNext()) {
                if (it.next().get_addon().equals(addon)) {
                    it.remove();
                    changed = true;
                }
            }
        }
        if (changed)
            this.baked_handlers = null;
    }

    /**
     * Unregisters a listener.
     *
     * @param listener The listener to unregister.
     */
    public synchronized void unregister(@NotNull Listener listener)
    {
        boolean changed = false;
        for (List<RegisteredListener> listeners : this.handlers.values()) {
            Iterator<RegisteredListener> it = listeners.iterator();
            while (it.hasNext()) {
                if (it.next().get_listener().equals(listener)) {
                    it.remove();
                    changed = true;
                }
            }
        }
        if (changed)
            this.baked_handlers = null;
    }

    /**
     * Bakes the handlers.
     */
    public synchronized void bake()
    {
        if (this.baked_handlers != null) return;
        List<RegisteredListener> entries = new ArrayList<>();
        this.handlers.forEach((priority, listeners) -> entries.addAll(listeners));
        this.baked_handlers = entries.toArray(new RegisteredListener[0]);
    }

    /**
     * Gets the registered listeners.
     *
     * @return The registered listeners.
     */
    public @NotNull RegisteredListener[] get_registered_listeners()
    {
        RegisteredListener[] handlers;
        while ((handlers = this.baked_handlers) == null) this.bake();
        return handlers;
    }
}
