/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.entity;

import org.mcelytra.core.Arm;
import org.mcelytra.core.Hand;
import org.mcelytra.core.inventory.ItemStack;

/**
 * Represents a living entity.
 */
public interface EntityLiving extends Entity
{
    /**
     * Checks whether this entity is a baby or not.
     *
     * @return True if this entity is a baby, else false.
     */
    default boolean is_baby()
    {
        return false;
    }

    /**
     * Gets the health of this living entity.
     * <p>The health is between 0 and the maximum health</p>
     *
     * @return The health of this entity.
     * @see EntityLiving#get_maximum_health()
     */
    float get_health();

    /**
     * Sets the health of this living entity.
     * <p>The health is between 0 and the maximum health.</p>
     *
     * @param health The health of this entity.
     * @see EntityLiving#get_maximum_health()
     */
    void set_health(float health);

    /**
     * Gets the maximum health of this living entity.
     *
     * @return The maximum health of this entity.
     */
    float get_maximum_health();

    /**
     * Sets the maximum health of this living entity.
     *
     * @param maximum_health The maximum health of this entity.
     */
    void set_maximum_health(float maximum_health);

    /**
     * Gets the absorption amount of this entity.
     *
     * @return The absorption amount.
     */
    float get_absorption_amount();

    /**
     * Sets the absorption amount of this entity.
     *
     * @param absorption_amount The absorption amount.
     */
    void set_absorption_amount(float absorption_amount);

    /**
     * Gets stuck arrow count of this entity.
     *
     * @return The stuck arrow count.
     */
    int get_stuck_arrow_count();

    /**
     * Sets the count of stuck arrows this entity has.
     *
     * @param arrows The stuck arrow count.
     */
    void set_stuck_arrow_count(int arrows);

    /**
     * Gets the count of stinger this entity has.
     *
     * @return The stinger count.
     */
    int get_stinger_count();

    /**
     * Sets the count of stinger this entity has.
     *
     * @param stingers The stinger count.
     */
    void set_stinger_count(int stingers);

    /**
     * Gets the movement speed.
     *
     * @return The movement speed.
     */
    float get_movement_speed();

    /**
     * Sets the movement speed of this entity.
     *
     * @param movement_speed The movement speed.
     */
    void set_movement_speed(float movement_speed);

    /**
     * Gets the main arm of this entity.
     *
     * @return The main arm.
     */
    Arm get_main_arm();

    /**
     * Checks whether this entity is using an item or not.
     *
     * @return True if this entity is using an item, else false.
     */
    boolean is_using_item();

    /**
     * Gets the active hand of this entity.
     *
     * @return The active hand of this entity.
     */
    Hand get_active_hand();

    /**
     * Gets the item stack in the active hand of this entity.
     *
     * @return The active item stack of this entity.
     */
    ItemStack get_active_item();

    /**
     * Checks whether this entity is sleeping or not.
     *
     * @return True if this entity is sleeping, else false.
     */
    boolean is_sleeping();
}
