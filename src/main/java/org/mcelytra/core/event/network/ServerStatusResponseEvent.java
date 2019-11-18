/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.event.network;

import org.aperlambda.lambdacommon.Identifier;
import org.aperlambda.lambdacommon.utils.Cancellable;
import org.jetbrains.annotations.NotNull;
import org.mcelytra.core.ServerPing;
import org.mcelytra.core.event.Event;
import org.mcelytra.core.event.HandlerList;

import java.net.InetSocketAddress;

/**
 * Represents the event fired when a player ping the server in the player list.
 */
public class ServerStatusResponseEvent extends Event implements Cancellable
{
    private static final HandlerList       HANDLERS = new HandlerList();
    private              InetSocketAddress player_address;
    private              ServerPing        server_ping;
    private              boolean           cancelled;

    public ServerStatusResponseEvent(InetSocketAddress player_address, @NotNull ServerPing server_ping)
    {
        super(new Identifier("elytra", "server_ping"), true);
        this.player_address = player_address;
        this.server_ping = server_ping;
        this.cancelled = false;
    }

    /**
     * Gets the player address.
     *
     * @return The player address.
     */
    public InetSocketAddress get_player_address()
    {
        return this.player_address;
    }

    /**
     * Gets the server ping information.
     *
     * @return The server ping information.
     */
    public @NotNull ServerPing get_server_ping()
    {
        return this.server_ping;
    }

    /**
     * Sets the server ping information.
     *
     * @param server_ping The server ping information.
     */
    public void set_server_ping(@NotNull ServerPing server_ping)
    {
        this.server_ping = server_ping;
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
