/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.addon;

import org.jetbrains.annotations.NotNull;
import org.mcelytra.core.Server;
import org.mcelytra.core.event.Event;
import org.mcelytra.core.event.HandlerList;
import org.mcelytra.core.event.Listener;

import java.util.ArrayList;
import java.util.List;

public class AddonManager
{
    protected final Server      mc;
    private final   List<Addon> addons = new ArrayList<>();

    public AddonManager(@NotNull Server mc)
    {
        this.mc = mc;
    }

    /**
     * Registers an addon.
     *
     * @param addon The addon to register.
     */
    public void register_addon(@NotNull Addon addon)
    {
        if (addons.contains(addon))
            return;
        this.mc.get_logger().info("Registered " + addon.get_name() + ".");
        addons.add(addon);
    }

    public void fire_event(@NotNull Event event)
    {
        if (event.is_async()) {
            mc.get_event_manager().fire_event(event);
        } else {
            synchronized (this) {
                mc.get_event_manager().fire_event(event);
            }
        }
    }

    public void register_listener(@NotNull Addon addon, @NotNull Listener listener)
    {
        if (!addon.is_enabled())
            throw new IllegalStateException("Addon attempted to register " + listener + " while not enabled.");
        mc.get_event_manager().register_events(addon, listener);
    }

    /**
     * Enables every registered addons.
     */
    public void enable_addons()
    {
        addons.forEach(this::enable_addon);
    }

    public void enable_addon(@NotNull final Addon addon)
    {
        // @TODO true enable addon
        addon.set_enabled(true);
        HandlerList.bake_all();
    }
}
