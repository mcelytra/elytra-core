/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core;

/**
 * Represents the fox types.
 */
public enum FoxType
{
    RED(0),
    SNOW(1);

    private final int value;

    FoxType(int value)
    {
        this.value = value;
    }

    /**
     * Gets the value corresponding to the fox type.
     *
     * @return The value of the fox type.
     */
    public int get_value()
    {
        return this.value;
    }

    /**
     * Gets the fox type from its corresponding value.
     *
     * @param value The value of the fox type.
     * @return The fox type from its value, or null if invalid.
     */
    public static FoxType from_value(int value)
    {
        if (value >= FoxType.values().length || value < 0)
            return null;
        return FoxType.values()[value];
    }
}
