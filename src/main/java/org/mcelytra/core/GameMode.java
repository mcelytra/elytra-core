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
 * Represents a game mode.
 */
public enum GameMode
{
    /**
     * Survival mode is the "normal" gameplay type, with no special features.
     */
    SURVIVAL(0),
    /**
     * Creative mode may fly, become invulnerable and has access to the creative inventory which give any items.
     */
    CREATIVE(1),
    /**
     * Adventure mode cannot break blocks without the correct tools.
     */
    ADVENTURE(2),
    /**
     * Spectator mode cannot interact with the world in anyways and is invisible to normal players, can spectate any entity.
     */
    SPECTATOR(3);

    private final int value;

    GameMode(int value)
    {
        this.value = value;
    }

    /**
     * Gets the value corresponding to the game mode.
     *
     * @return The value of the game mode.
     */
    public int get_value()
    {
        return this.value;
    }

    /**
     * Gets the game mode from its corresponding value.
     *
     * @param value The value of the game mode.
     * @return The game mode from its value, or null if invalid.
     */
    public static GameMode from_value(int value)
    {
        if (value >= GameMode.values().length || value < 0)
            return null;
        return GameMode.values()[value];
    }
}
