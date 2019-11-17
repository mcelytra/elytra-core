/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.event.player;

import org.aperlambda.lambdacommon.resources.ResourceName;
import org.aperlambda.lambdacommon.utils.Cancellable;
import org.jetbrains.annotations.NotNull;
import org.mcelytra.core.entity.EntityPlayer;
import org.mcelytra.core.event.HandlerList;

public class PlayerBlockBreakEvent extends PlayerEvent implements Cancellable
{
    private static final HandlerList HANDLERS = new HandlerList();
    private              boolean     cancelled;

    public PlayerBlockBreakEvent(EntityPlayer player)
    {
        super(new ResourceName("elytra:player_block_break"), player);
        this.cancelled = false;
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
     * @return The handler list of the event.
     */
    public static @NotNull HandlerList get_handler_list()
    {
        return HANDLERS;
    }
}
