/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.Logger;
import org.aperlambda.lambdacommon.utils.Nameable;
import org.jetbrains.annotations.NotNull;
import org.mcelytra.core.addon.AddonManager;
import org.mcelytra.core.config.ElytraServerConfig;
import org.mcelytra.core.entity.EntityPlayer;
import org.mcelytra.core.event.EventManager;
import org.mcelytra.core.event.HandlerList;
import org.mcelytra.core.util.ElytraPreLoader;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Represents a Minecraft server.
 */
public abstract class Server implements Nameable
{
    protected final List<EntityPlayer> players = Lists.newArrayList();
    protected       Logger             logger;
    protected       AddonManager       addon_manager;
    protected       EventManager       event_manager;
    protected       boolean            running;
    protected       ElytraServerConfig config;
    protected       int                tcp_port;
    protected       int                bedrock_port;
    protected       ServerPing         server_ping;

    public Server(Logger logger)
    {
        this.logger = logger;
        this.addon_manager = new AddonManager(this);
        this.event_manager = new EventManager();
        this.config = new ElytraServerConfig(this);
    }

    /**
     * Gets the Elytra logger.
     *
     * @return The logger.
     */
    public Logger get_logger()
    {
        return this.logger;
    }

    /**
     * Checks whether Elytra is in debug mode.
     *
     * @return True if Elytra is in debug mode, else false.
     */
    public boolean has_debug()
    {
        return this.config.has_debug();
    }

    /**
     * Gets the version of Elytra.
     *
     * @return The version of Elytra.
     */
    public abstract String get_version();

    /**
     * Gets the Java Edition version.
     *
     * @return The version.
     */
    public abstract String get_mc_version();

    /**
     * Gets the Bedrock Edition version.
     *
     * @return The server version.
     */
    public abstract String get_mc_bedrock_version();

    /**
     * Gets the protocol version.
     *
     * @return The protocol version.
     */
    public abstract int get_protocol_version();

    /**
     * Gets the protocol version for Bedrock Edition.
     *
     * @return The Bedrock Edition protocol version.
     */
    public abstract int get_bedrock_protocol_version();

    /**
     * Gets the addon manager.
     *
     * @return The addon manager.
     */
    public AddonManager get_addon_manager()
    {
        return this.addon_manager;
    }

    /**
     * Gets the event manager of Elytra.
     *
     * @return The event manager.
     */
    public EventManager get_event_manager()
    {
        return this.event_manager;
    }

    /**
     * Checks whether the server is running or not.
     *
     * @return True if the server is running, else false.
     */
    public boolean is_running()
    {
        return this.running;
    }

    /**
     * Starts the server.
     */
    protected void start()
    {
        this.running = true;
        // Loads the configuration.
        logger.info("Loading configuration...");
        this.config.load();
        logger.info("Starting server '" + this.get_name() + "'...");
        this.tcp_port = this.config.get_tcp_port();
        this.bedrock_port = this.config.get_udp_port();
        // Apply the preloader.
        ElytraPreLoader.INSTANCE.apply(this);
    }

    /**
     * Shutdowns the server.
     */
    public void shutdown()
    {
        logger.info("Shutting down the server...");
        this.running = false;
        HandlerList.unregister_all();
        this.config.close();
    }

    @Override
    public @NotNull String get_name()
    {
        return this.config.get_server_name();
    }

    /**
     * Gets the server brand.
     *
     * @return The server brand.
     */
    public String get_brand()
    {
        return "ElytraServer";
    }

    /**
     * Gets the TCP port used for the server.
     *
     * @return The TCP port used.
     */
    public int get_port()
    {
        return this.tcp_port;
    }

    /**
     * Gets the UDP port used for the server.
     *
     * @return The UDP port used.
     */
    public int get_bedrock_port()
    {
        return this.bedrock_port;
    }

    /**
     * Gets the maximum player count connected at once.
     *
     * @return The maximum player count.
     */
    public int get_max_players()
    {
        return this.config.get_max_players();
    }

    /**
     * Gets the online players.
     *
     * @return Online players.
     */
    public Collection<EntityPlayer> get_online_players()
    {
        return Collections.unmodifiableCollection(this.players);
    }

    public ServerPing get_server_ping()
    {
        return this.server_ping;
    }

    /**
     * Updates the server's ping information.
     */
    public abstract void update_server_ping();

    /**
     * Gets the network compression threshold.
     *
     * @return The compression threshold.
     */
    public int get_compression_threshold()
    {
        return this.config.get_compression_threshold();
    }
}
