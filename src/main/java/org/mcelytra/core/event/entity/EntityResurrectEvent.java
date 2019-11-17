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
import org.aperlambda.lambdacommon.utils.Cancellable;
import org.jetbrains.annotations.NotNull;
import org.mcelytra.core.Hand;
import org.mcelytra.core.entity.EntityLiving;
import org.mcelytra.core.event.HandlerList;

/**
 * Thrown when an entity resurrects.
 */
public class EntityResurrectEvent extends EntityEvent<EntityLiving> implements Cancellable
{
    private static final HandlerList HANDLERS     = new HandlerList();
    private              Hand        hand;
    private              boolean     consume_item = true;
    private              boolean     cancelled    = false;

    public EntityResurrectEvent(@NotNull EntityLiving entity, @NotNull Hand hand)
    {
        super(new ResourceName("elytra:entity_resurrect"), entity);
        this.hand = hand;
    }

    /**
     * Gets the hand where the totem of undying is.
     *
     * @return The hand which holds the totem of undying.
     */
    public @NotNull Hand get_hand()
    {
        return this.hand;
    }

    /**
     * Returns whether the totem of undying is consumed or not.
     *
     * @return True if the item is consumed, else false.
     */
    public boolean does_consume_item()
    {
        return this.consume_item;
    }

    /**
     * Sets whether the totem of undying is consumed or not.
     *
     * @param consume_item True if the item is consumed, else false.
     */
    public void set_consume_item(boolean consume_item)
    {
        this.consume_item = consume_item;
    }

    @Override
    public boolean is_cancelled()
    {
        return this.cancelled;
    }

    @Override
    public void set_cancelled(boolean cancelled)
    {
        this.cancelled = cancelled;
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
