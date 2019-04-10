/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core;

public enum Hand
{
    MAIN_HAND(0),
    OFF_HAND(1);

    private final int value;

    Hand(int value)
    {
        this.value = value;
    }

    /**
     * Gets the value corresponding to the hand.
     *
     * @return The value of the hand.
     */
    int get_value()
    {
        return this.value;
    }

    /**
     * Gets the hand from its corresponding value.
     *
     * @param value The value of the hand.
     * @return The hand from its value, or null if invalid.
     */
    public static Hand from_value(int value)
    {
        if (value >= Hand.values().length || value < 0)
            return null;
        return Hand.values()[value];
    }
}
