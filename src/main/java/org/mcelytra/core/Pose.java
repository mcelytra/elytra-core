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
 * Represents the poses of an entity.
 */
public enum Pose
{
    STANDING(0),
    FALL_FLYING(1),
    SLEEPING(2),
    SWIMMING(3),
    SPIN_ATTACK(4),
    SNEAKING(5),
    DYING(6);

    private final int value;

    Pose(int value)
    {
        this.value = value;
    }

    /**
     * Gets the value corresponding to the pose.
     *
     * @return The value of the pose.
     */
    int get_value()
    {
        return this.value;
    }

    /**
     * Gets the pose from its corresponding value.
     *
     * @param value The value of the pose.
     * @return The pose from its value, or null if invalid.
     */
    public static Pose from_value(int value)
    {
        if (value >= Pose.values().length || value < 0)
            return null;
        return Pose.values()[value];
    }
}
