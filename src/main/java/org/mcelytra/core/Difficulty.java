/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core;

import java.util.Arrays;

/**
 * Represents a difficulty.
 */
public enum Difficulty
{
    /**
     * Players regain health over time, hostile mobs don't spawn and the hunger bar does not decrease.
     */
    PEACEFUL(0),
    /**
     * Hostile mobs spawn, enemies deal less damage than on normal difficulty, the hunger bar does decrease and starving deals up to 5 hearts of damage.
     */
    EASY(1),
    /**
     * Hostile mobs spawn, enemies deal normal amounts of damage, the hunger bar does decrease and starving deals up to 9.5 hearts of damage.
     */
    NORMAL(2),
    /**
     * Hostile mobs spawn, enemies deal greater damage than on normal difficulty, the hunger bar does decrease and starving can kill players.
     */
    HARD(3);

    private final int difficulty;

    Difficulty(int difficulty)
    {
        this.difficulty = difficulty;
    }

    /**
     * Gets the value corresponding to the difficulty.
     *
     * @return The value of the difficulty.
     */
    int get_value()
    {
        return this.difficulty;
    }

    /**
     * Gets the difficulty from its corresponding value.
     *
     * @param value The value of the difficulty.
     * @return The difficulty from its value, or null if invalid.
     */
    public static Difficulty from_value(int value)
    {
        if (value >= Difficulty.values().length || value < 0)
            return null;
        return Difficulty.values()[value];
    }
}
