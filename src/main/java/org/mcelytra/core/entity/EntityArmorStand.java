/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.entity;

/**
 * Represents an armor stand.
 */
public interface EntityArmorStand extends EntityLiving
{
    /**
     * Returns whether this armor stand is small.
     *
     * @return True if the armor stand is small, else false.
     */
    boolean is_small();

    /**
     * Sets whether this armor stand is small.
     *
     * @param small True if this armor stand is small, else false.
     */
    void set_small(boolean small);

    /**
     * Returns whether this armor stand has arms.
     *
     * @return True if this armor stand has arms, else false.
     */
    boolean has_arms();

    /**
     * Sets whether this armor stand has arms.
     *
     * @param arms True if this armor stand has arms, else false.
     */
    void set_arms(boolean arms);

    /**
     * Returns whether this armor stand has a base plate or not.
     *
     * @return True if this armor stand has a base plate, else false.
     * @see EntityArmorStand#should_hide_base_plate()
     */
    default boolean has_base_plate()
    {
        return !this.should_hide_base_plate();
    }

    /**
     * Returns whether this armor stand should hide the base plate.
     *
     * @return True if this armor stand does not display its base plate, else false.
     */
    boolean should_hide_base_plate();

    /**
     * Sets whether this armor stand should hide the base plate.
     *
     * @param hide_base_plate True if this armor stand does not display its base plate, else false.
     */
    void set_hide_base_plate(boolean hide_base_plate);

    /**
     * Returns whether this armor stand is a marker. If true, the armor stand's size is set to 0, has a tiny hitbox and disables interactions with it.
     *
     * @return True if this is a marker, else false.
     */
    boolean is_marker();

    /**
     * Sets whether this armor stand is a marker.
     *
     * @param marker True if this is a marker, else false.
     * @see EntityArmorStand#is_marker()
     */
    void set_marker(boolean marker);
}
