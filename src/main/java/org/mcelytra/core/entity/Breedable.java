/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.entity;

import org.mcelytra.core.inventory.ItemStack;
import org.mcelytra.core.item.Item;

/**
 * Represents a breedable entity.
 */
public interface Breedable
{
    /**
     * Returns whether the specified item is a breeding item.
     *
     * @param item The item to check.
     * @return True if the item can be used to breed, else false.
     */
    boolean is_breeding_item(Item item);

    /**
     * Returns whether the specified item is a breeding item.
     *
     * @param stack The item to check.
     * @return True if the item can be used to breed, else false.
     */
    default boolean is_breeding_item(ItemStack stack)
    {
        return is_breeding_item(stack.get_item());
    }

    /**
     * Returns whether this entity is in love.
     *
     * @return True if this entity is in love, else false.
     */
    boolean is_in_love();

    /**
     * Gets the love ticks of this entity.
     *
     * @return The love ticks of this entity.
     */
    int get_love_ticks();

    /**
     * Resets the love ticks.
     */
    void reset_love_ticks();

    /**
     * Returns whether this entity can breed with another entity.
     *
     * @param other The other entity.
     * @return True if this entity can breed with the other entity, else false.
     */
    default boolean can_breed_with(Breedable other)
    {
        if (other == this)
            return false;
        else if (other.getClass() != this.getClass())
            return false;
        else
            return this.is_in_love() && other.is_in_love();
    }
}
