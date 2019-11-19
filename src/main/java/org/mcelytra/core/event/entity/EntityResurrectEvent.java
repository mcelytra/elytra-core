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
import org.aperlambda.lambdacommon.utils.Cancellable;
import org.jetbrains.annotations.NotNull;
import org.mcelytra.core.Hand;
import org.mcelytra.core.entity.EntityLiving;
import org.mcelytra.core.event.HandlerList;
import org.mcelytra.core.inventory.ItemStack;

/**
 * Thrown when an entity resurrects.
 */
public class EntityResurrectEvent extends EntityEvent<EntityLiving> implements Cancellable
{
    private static final HandlerList HANDLERS     = new HandlerList();
    private              Hand        hand;
    private              ItemStack   item_stack;
    private              boolean     consume_item = true;
    private              boolean     cancelled    = false;

    public EntityResurrectEvent(@NotNull EntityLiving entity, @NotNull Hand hand, @NotNull ItemStack stack)
    {
        super(new Identifier("elytra", "entity_resurrect"), entity);
        this.hand = hand;
        this.item_stack = stack;
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
     * Gets the item stack which contains the totem of undying.
     *
     * @return The item stack which contains the totem.
     */
    public @NotNull ItemStack get_item_stack()
    {
        return this.item_stack;
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
