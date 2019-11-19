/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.entity.passive;

import org.mcelytra.core.FoxType;

/**
 * Represents a fox.
 */
public interface EntityFox extends EntityAnimal
{
    /**
     * Gets the type of this fox.
     *
     * @return The type of this fox.
     */
    FoxType get_type();

    /**
     * Sets the type of this fox.
     *
     * @param type The type of this fox.
     */
    void set_type(FoxType type);

    /**
     * Returns whether this fox is sitting.
     *
     * @return True if this fox is sitting, else false.
     */
    boolean is_sitting();

    /**
     * Sets whether this fox is sitting.
     *
     * @param sitting True if this fox is sitting, else false.
     */
    void set_sitting(boolean sitting);

    /**
     * Returns whether this fox is aggressive.
     *
     * @return True if this fox is aggressive, else false.
     */
    boolean is_aggressive();

    /**
     * Sets whether this fox is aggressive.
     *
     * @param aggressive True if this fox is aggressive, else false.
     */
    void set_aggressive(boolean aggressive);

    /**
     * Sets whether this fox is sleeping.
     *
     * @param sleeping True if this fox is sleeping, else false.
     */
    void set_sleeping(boolean sleeping);
}
