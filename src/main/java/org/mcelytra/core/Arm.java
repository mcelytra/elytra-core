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
 * Represents the arm of an entity.
 */
public enum Arm
{
    LEFT,
    RIGHT;

    /**
     * Gets the opposite arm.
     *
     * @return The opposite arm.
     */
    public Arm get_opposite()
    {
        return this == LEFT ? RIGHT : LEFT;
    }
}
