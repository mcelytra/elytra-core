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

/**
 * Represents a living entity.
 */
public interface EntityLiving extends Entity
{
    /**
     * Checks whether the entity is a baby or not.
     *
     * @return True if the entity is a baby, else false.
     */
    default boolean is_baby()
    {
        return false;
    }

    /**
     * Gets the health of the living entity.
     * <p>The health is between 0 and the maximum health</p>
     *
     * @return The health of the entity.
     * @see EntityLiving#get_maximum_health()
     */
    float get_health();

    /**
     * Sets the health of the living entity.
     * <p>The health is between 0 and the maximum health.</p>
     *
     * @param health The health of the entity.
     * @see EntityLiving#get_maximum_health()
     */
    void set_health(float health);

    /**
     * Gets the maximum health of the living entity.
     *
     * @return The maximum health of the entity.
     */
    float get_maximum_health();

    /**
     * Sets the maximum health of the living entity.
     *
     * @param maximum_health The maximum health of the entity.
     */
    void set_maximum_health(float maximum_health);

    /**
     * Gets the absorption amount of the entity.
     *
     * @return The absorption amount.
     */
    float get_absorption_amount();

    /**
     * Sets the absorption amount of the entity.
     *
     * @param absorption_amount The absorption amount.
     */
    void set_absorption_amount(float absorption_amount);

    /**
     * Gets stuck arrow count of the entity.
     *
     * @return The stuck arrow count.
     */
    int get_stuck_arrow_count();

    /**
     * Sets the count of stuck arrows the entity has.
     *
     * @param arrows The stuck arrow count.
     */
    void set_stuck_arrow_count(int arrows);

    /**
     * Gets the count of stinger the entity has.
     *
     * @return The stinger count.
     */
    int get_stinger_count();

    /**
     * Sets the count of stinger the entity has.
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
     * Sets the movement speed of the entity.
     *
     * @param movement_speed The movement speed.
     */
    void set_movement_speed(float movement_speed);

    /**
     * Gets the main arm of the entity.
     *
     * @return The main arm.
     */
    Arm get_main_arm();

    /**
     * Checks whether the entity is using an item or not.
     *
     * @return True if the entity is using an item, else false.
     */
    boolean is_using_item();

    /**
     * Gets the active hand of the entity.
     *
     * @return The active hand of the entity.
     */
    Hand get_active_hand();

    // @TODO get_active_item()

    /**
     * Checks whether the entity is sleeping or not.
     *
     * @return True if the entity is sleeping, else false.
     */
    boolean is_sleeping();
}
