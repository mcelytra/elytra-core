/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.entity;

import org.aperlambda.lambdacommon.utils.Nameable;

import java.util.UUID;

/**
 * Represents an entity.
 */
public interface Entity extends Nameable
{
    /**
     * Gets the entity identifier.
     * @return The identifier.
     */
    int get_entity_id();

    /**
     * Gets the entity unique identifier.
     * @return The identifier.
     */
    UUID get_unique_id();


}
