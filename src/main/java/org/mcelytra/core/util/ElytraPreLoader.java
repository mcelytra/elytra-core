/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.util;

import com.google.common.collect.Lists;
import org.jetbrains.annotations.NotNull;
import org.mcelytra.core.Server;
import org.mcelytra.core.addon.Addon;

import java.util.List;

/**
 * Represents the Elytra preloader.
 *
 * <p>It allows to preload things in Elytra, it can be useful in some cases like Fabric.</p>
 */
public class ElytraPreLoader
{
    public static final ElytraPreLoader INSTANCE = new ElytraPreLoader();

    private List<Addon> preloaded_addons = Lists.newArrayList();

    public void add_addon(@NotNull Addon addon)
    {
        System.out.println("Pre load addon \"" + addon.get_name() + "\"...");
        preloaded_addons.add(addon);
    }

    public void apply(@NotNull Server server)
    {
        if (!server.is_running())
            throw new IllegalStateException("Cannot apply the Elytra PreLoader to a non-running server.");
        preloaded_addons.forEach(server.get_addon_manager()::register_addon);
    }
}
