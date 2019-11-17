/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core;

import org.aperlambda.lambdacommon.utils.Nameable;
import org.jetbrains.annotations.NotNull;

/**
 * Represents the editions of Minecraft.
 */
public enum MinecraftEdition implements Nameable
{
    JAVA("Java Edition"),
    BEDROCK("Bedrock Edition");

    private final String name;

    MinecraftEdition(String name)
    {
        this.name = name;
    }

    @Override
    public @NotNull String get_name()
    {
        return this.name;
    }
}
