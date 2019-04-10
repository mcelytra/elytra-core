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
 * Represents the cat types.
 */
public enum CatType
{
    TABBY(0),
    BLACK(1),
    RED(2),
    SIAMESE(3),
    BRITISH_SHORTHAIR(4),
    CALICO(5),
    PERSIAN(6),
    RAGDOLL(7),
    WHITE(8),
    ALL_BLACK(9);

    private final int value;

    CatType(int value)
    {
        this.value = value;
    }

    /**
     * Gets the value corresponding to the cat type.
     *
     * @return The value of the cat type.
     */
    public int get_value()
    {
        return this.value;
    }

    /**
     * Gets the cat type from its corresponding value.
     *
     * @param value The value of the cat type.
     * @return The cat type from its value, or null if invalid.
     */
    public static CatType from_value(int value)
    {
        if (value >= CatType.values().length || value < 0)
            return null;
        return CatType.values()[value];
    }
}
