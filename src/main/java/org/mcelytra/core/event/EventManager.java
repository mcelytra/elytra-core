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
import org.mcelytra.core.Elytra;
import org.mcelytra.core.addon.Addon;
import org.mcelytra.core.addon.EventExecutor;
import org.mcelytra.core.addon.RegisteredListener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class EventManager
{
    /**
     * Fires the event.
     * <p>This is an internal method, please use {@link org.mcelytra.core.addon.AddonManager#fire_event(Event)} to fire the event safely.</p>
     *
     * @param event The event to fire.
     */
    public void fire_event(@NotNull Event event)
    {
        Arrays.stream(event.get_handlers().get_registered_listeners())
                .forEachOrdered(listener -> {
                    if (listener.get_addon().is_enabled()) {
                        try {
                            listener.call(event);
                        } catch (Throwable e) {
                            Elytra.get_logger().error("Could not pass event " + event.get_resource_name().toString() + " to " + listener.get_addon().get_name());
                        }
                    }
                });
    }

    /**
     * Registers all the events in the given listener class.
     * @param addon Addon to register.
     * @param listener Listener to register.
     */
    public void register_events(@NotNull Addon addon, @NotNull Listener listener)
    {
        if (!addon.is_enabled())
            throw new IllegalStateException("Addon attempted to register " + listener + " while not enabled.");

        addon.get_loader().create_registered_listeners(addon, listener).forEach((event, l) -> this.get_event_handlers(event).register_all(l));
    }

    public void register_event(@NotNull Class<? extends Event> event, @NotNull Listener listener, @NotNull EventPriority priority, @NotNull EventExecutor executor, @NotNull Addon addon)
    {
        this.register_event(event, listener, priority, executor, addon, false);
    }

    public void register_event(@NotNull Class<? extends Event> event, @NotNull Listener listener, @NotNull EventPriority priority, @NotNull EventExecutor executor, @NotNull Addon addon, boolean ignore_cancelled)
    {
        if (!addon.is_enabled())
            throw new IllegalStateException("Addon attempted to register " + listener + " while not enabled.");
        this.get_event_handlers(event).register(new RegisteredListener(listener, priority, addon, executor, ignore_cancelled));
    }

    private HandlerList get_event_handlers(Class<? extends Event> event)
    {
        try {
            Method method = event.getDeclaredMethod("get_handler_list");
            method.setAccessible(true);
            return (HandlerList) method.invoke(null);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
