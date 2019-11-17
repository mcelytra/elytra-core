/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.entity;

import net.md_5.bungee.api.chat.BaseComponent;
import org.aperlambda.lambdacommon.utils.Nameable;
import org.jetbrains.annotations.NotNull;
import org.mcelytra.core.Server;

import java.util.Optional;
import java.util.UUID;

/**
 * Represents an entity.
 */
public interface Entity extends Nameable
{
    /**
     * Gets the entity identifier.
     *
     * @return The identifier.
     */
    int get_entity_id();

    /**
     * Gets the amount of ticks this entity has lived for.
     * <p>This is the equivalent to "age" in entities.</p>
     *
     * @return Age of entity.
     */
    int get_ticks_lived();

    /**
     * Sets the amount of ticks this entity has lived for.
     * <p>This is the equivalent to "age" in entities. May not be less than one tick.</p>
     *
     * @param age Age of entity.
     */
    void set_ticks_lived(int age);

    /**
     * Marks the entity's removal.
     */
    void remove();

    /**
     * Kills this entity.
     */
    void kill();

    /**
     * Checks whether this entity has been marked for removal or not.
     *
     * @return True if the entity has been marked for removal, else false.
     */
    default boolean is_dead()
    {
        return !is_alive();
    }

    /**
     * Checks whether the entity is alive or not.
     *
     * @return True if the entity is alive, else false.
     */
    boolean is_alive();

    /**
     * Gets the entity unique identifier.
     *
     * @return The identifier.
     */
    @NotNull UUID get_unique_id();

    @NotNull BaseComponent[] get_display_name();

    /**
     * Checks whether the entity has a custom name.
     *
     * @return True if the entity has a custom name, else false.
     */
    boolean has_custom_name();

    /**
     * Gets the entity's custom name.
     *
     * @return The optional custom name of the entity.
     */
    @NotNull Optional<BaseComponent[]> get_custom_name();

    /**
     * Sets a custom name to the entity.
     *
     * @param custom_name The entity's custom name.
     */
    void set_custom_name(BaseComponent... custom_name);

    /**
     * Gets whether the custom name of the entity is visible or not.
     *
     * @return True if the custom name is visible, else false.
     */
    boolean is_custom_name_visible();

    /**
     * Sets whether the custom name of the entity is visible or not.
     *
     * @param custom_name_visible True if the custom name is visible, else false.
     */
    void set_custom_name_visible(boolean custom_name_visible);

    /**
     * Returns the entity's maximum fire ticks.
     *
     * @return Maximum fire ticks.
     */
    int get_max_fire_ticks();

    /**
     * Returns the entity's current fire ticks (ticks before the entity stops being on fire).
     *
     * @return The entity's current fire ticks.
     */
    int get_fire_ticks();

    /**
     * Sets the entity's current fire ticks (ticks before the entity stops being on fire).
     *
     * @param ticks The entity's current fire ticks.
     */
    void set_fire_ticks(int ticks);

    /**
     * Returns whether this entity is on fire or not.
     *
     * @return True if this entity is on fire, else false.
     */
    boolean is_on_fire();

    /**
     * Extinguishes this entity (sets the fire ticks to 0).
     *
     * @see Entity#set_fire_ticks(int)
     */
    default void extinguish()
    {
        set_fire_ticks(0);
    }

    /**
     * Returns whether this entity is fire immune or not.
     *
     * @return True if the entity is fire immune, else false.
     */
    boolean is_fire_immune();

    /**
     * Returns true if the entity is supported by a block.
     *
     * @return True if the entity is supported by a block, else false.
     */
    boolean is_on_ground();

    /**
     * Returns true if the entity is touching water.
     *
     * @return True if the entity is touching water, else false.
     */
    boolean is_touching_water();

    /**
     * Returns true if the entity is submerged in water.
     *
     * @return True if the entity is submerged in water, else false.
     */
    boolean is_submerged_in_water();

    /**
     * Returns true if the entity is being rained on.
     *
     * @return True if the entity is being rained on, else false.
     */
    boolean is_being_rain_on();

    /**
     * Returns true if the entity is inside a bubble column.
     *
     * @return True if the entity is inside a bubble column, else false.
     */
    boolean is_inside_water_bubble_column();

    /**
     * Returns true if the entity is inside water or is being rained on.
     *
     * @return True if the entity is inside water or is being rained on, else false.
     * @see Entity#is_touching_water()
     * @see Entity#is_being_rain_on()
     */
    default boolean is_touching_water_or_rain()
    {
        return this.is_touching_water() || this.is_being_rain_on();
    }

    /**
     * Returns true if the entity is touching water or a bubble column.
     *
     * @return True if the entity is touching water or a bubble column, else false.
     * @see Entity#is_touching_water()
     * @see Entity#is_inside_water_bubble_column()
     */
    default boolean is_touching_water_or_bubble_column()
    {
        return this.is_touching_water() || this.is_inside_water_bubble_column();
    }

    /**
     * Returns true if the entity is making contact with water.
     * It means whether the entity is touching water or is being rained on or is inside a bubble column.
     *
     * @return True if the entity is making contact with water, else false.
     * @see Entity#is_touching_water_or_rain()
     * @see Entity#is_inside_water_bubble_column()
     */
    default boolean is_making_contact_with_water()
    {
        return this.is_touching_water_or_rain() || this.is_inside_water_bubble_column();
    }

    /**
     * Gets whether the entity can emit sound or not.
     *
     * @return True if the entity is silent, else false.
     */
    boolean is_silent();

    /**
     * Sets whether the entity can emit sound or not.
     *
     * @param silent True if the entity is silent, else false.
     */
    void set_silent(boolean silent);

    /**
     * Returns whether gravity applies to this entity.
     *
     * @return True if gravity applies, else false.
     */
    boolean has_gravity();

    /**
     * Sets whether gravity applies to this entity.
     *
     * @param gravity True if gravity applies, else false.
     */
    void set_gravity(boolean gravity);

    /**
     * Gets whether the entity is glowing or not.
     *
     * @return True if the entity is glowing, else false.
     */
    boolean is_glowing();

    /**
     * Sets whether the entity is glowing or not.
     *
     * @param glowing True if the entity is glowing, else false.
     */
    void set_glowing(boolean glowing);

    /**
     * Gets whether the entity is invisible or not.
     *
     * @return True if the entity is invisible, else false.
     */
    boolean is_invisible();

    /**
     * Sets whether the entity is invisible or not.
     *
     * @param invisible True if the entity is invisible, else false.
     */
    void set_invisible(boolean invisible);

    /**
     * Gets whether this entity is invulnerable or not.
     *
     * @return True if the entity is invulnerable, else false.
     */
    boolean is_invulnerable();

    /**
     * Sets whether this entity is invulnerable or not.
     *
     * @param invulnerable True if the entity is invulnerable, else false.
     */
    void set_invulnerable(boolean invulnerable);

    /**
     * Gets the server instance.
     *
     * @return The server instance.
     */
    @NotNull Server get_server();
}
