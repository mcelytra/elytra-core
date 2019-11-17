/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.event;

/**
 * Represents the priority to handle event.
 */
public enum EventPriority
{
    LOWER(0),
    LOW(1),
    NORMAL(2),
    HIGH(3),
    HIGHEST(4),
    /**
     * Not recommended.
     */
    MONITOR(5);

    private int index;

    EventPriority(int index)
    {
        this.index = index;
    }

    /**
     * Gets the index of the priority.
     * @return The priority's index.
     */
    public int get_index()
    {
        return this.index;
    }
}
