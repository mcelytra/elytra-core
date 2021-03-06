/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.event.entity;

import org.aperlambda.lambdacommon.Identifier;
import org.jetbrains.annotations.NotNull;
import org.mcelytra.core.entity.Entity;
import org.mcelytra.core.event.Event;

/**
 * Represents an Entity-related event.
 */
public abstract class EntityEvent<T extends Entity> extends Event
{
    protected T entity;

    public EntityEvent(@NotNull Identifier identifier, @NotNull T entity)
    {
        super(identifier);
        this.entity = entity;
    }

    public EntityEvent(@NotNull Identifier identifier, @NotNull T entity, boolean async)
    {
        super(identifier, async);
        this.entity = entity;
    }

    public @NotNull T get_entity() {
        return this.entity;
    }
}
