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

import java.util.regex.Pattern;

public class DummyAddonLoader extends AddonLoader
{
    private final Pattern[] file_filters = new Pattern[]{Pattern.compile("\\.invalid$")};

    @Override
    public @NotNull Addon load_addon(@NotNull Addon addon_file)
    {
        throw new RuntimeException(new IllegalStateException("This loader should never be triggered for addon files."));
    }
}
