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
import org.aperlambda.lambdacommon.Identifier;
import org.jetbrains.annotations.NotNull;
import org.mcelytra.core.entity.EntityPlayer;
import org.mcelytra.core.event.HandlerList;

/**
 * Thrown when a player joins a server.
 */
public class PlayerJoinEvent extends PlayerEvent
{
    private static final Identifier      EVENT_NAME = new Identifier("elytra", "player_join");
    private static final HandlerList     HANDLERS   = new HandlerList();
    private              BaseComponent[] join_message;
    private              boolean         renamed    = false;

    public PlayerJoinEvent(@NotNull EntityPlayer player, @NotNull BaseComponent[] join_message, boolean renamed)
    {
        super(EVENT_NAME, player);
        this.join_message = join_message;
        this.renamed = renamed;
    }

    /**
     * Gets the join message to send to all online players.
     *
     * @return The join message.
     */
    public BaseComponent[] get_join_message()
    {
        return this.join_message;
    }

    /**
     * Sets the join message to send to all online players.
     *
     * @param join_message The join message.
     */
    public void set_join_message(BaseComponent... join_message)
    {
        this.join_message = join_message;
    }

    /**
     * Returns whether the player renamed themself recently.
     *
     * @return True if the player renamed themself, else false.
     */
    public boolean is_renamed()
    {
        return this.renamed;
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
