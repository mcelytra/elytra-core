/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.inventory;

/**
 * Represent an equipment slot.
 */
public enum EquipmentSlot
{
    MAIN_HAND(0),
    OFF_HAND(1),
    FEET(2),
    LEGS(3),
    CHEST(4),
    HEAD(5);

    private final int value;

    EquipmentSlot(int value)
    {
        this.value = value;
    }

    /**
     * Gets the value corresponding to the equipment slot.
     *
     * @return The value of the equipment slot.
     */
    int get_value()
    {
        return this.value;
    }

    /**
     * Gets the equipment slot from its corresponding value.
     *
     * @param value The value of the equipment slot.
     * @return The equipment slot from its value, or null if invalid.
     */
    public static EquipmentSlot from_value(int value)
    {
        if (value >= EquipmentSlot.values().length || value < 0)
            return null;
        return EquipmentSlot.values()[value];
    }
}
