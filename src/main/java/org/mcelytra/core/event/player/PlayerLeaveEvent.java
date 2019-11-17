/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.event.player;

import net.md_5.bungee.api.chat.BaseComponent;
import org.aperlambda.lambdacommon.resources.ResourceName;
import org.jetbrains.annotations.NotNull;
import org.mcelytra.core.entity.EntityPlayer;
import org.mcelytra.core.event.HandlerList;

/**
 * Thrown when a player leaves a server.
 */
public class PlayerLeaveEvent extends PlayerEvent
{
    private static final HandlerList     HANDLERS = new HandlerList();
    private              BaseComponent[] leave_message;

    public PlayerLeaveEvent(@NotNull EntityPlayer player, @NotNull BaseComponent[] leave_message)
    {
        super(new ResourceName("elytra:player_leave"), player);
        this.leave_message = leave_message;
    }

    /**
     * Gets the leave message to send to all online players.
     *
     * @return The leave message.
     */
    public BaseComponent[] get_leave_message()
    {
        return this.leave_message;
    }

    /**
     * Sets the leave message to send to all online players.
     *
     * @param leave_message The leave message.
     */
    public void set_leave_message(BaseComponent... leave_message)
    {
        this.leave_message = leave_message;
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
