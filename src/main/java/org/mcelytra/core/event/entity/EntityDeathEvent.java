/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.event.entity;

import org.aperlambda.lambdacommon.resources.ResourceName;
import org.jetbrains.annotations.NotNull;
import org.mcelytra.core.entity.EntityLiving;
import org.mcelytra.core.event.HandlerList;

/**
 * Thrown when an entity dies.
 */
public class EntityDeathEvent extends EntityEvent<EntityLiving>
{
    private static final HandlerList HANDLERS = new HandlerList();

    public EntityDeathEvent(@NotNull EntityLiving entity)
    {
        super(new ResourceName("elytra:entity_death"), entity);
    }

    @Override
    public @NotNull HandlerList get_handlers()
    {
        return HANDLERS;
    }

    /**
     * Gets the handler list of the event.
     *
     * @return The handler list of the event.
     */
    public static @NotNull HandlerList get_handler_list()
    {
        return HANDLERS;
    }
}
