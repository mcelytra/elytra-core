/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core;

import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.mcelytra.core.addon.AddonManager;
import org.mcelytra.core.entity.EntityPlayer;

import java.io.File;
import java.util.Collection;

/**
 * Represents the Elytra API singleton with a lot of basic stuff.
 */
public class Elytra
{
    public static final File   CONFIGURATION_PATH = new File("config/");
    private static      Server handle;

    /**
     * Initializes Elytra API singleton.
     *
     * @param handle The Elytra implementation instance.
     */
    public static void init(@NotNull Server handle)
    {
        if (Elytra.handle != null)
            throw new UnsupportedOperationException("Cannot redefine singleton Elytra.");
        Elytra.handle = handle;
        handle.get_logger().info("Running " + get_brand() + " version " + get_version() + " (MC Version: Java(" + get_mc_version() + ";" + get_protocol_version() +
                "), Bedrock(" + get_mc_bedrock_version() + ";" + get_bedrock_protocol_version() + ")");
    }

    /**
     * Gets the Elytra implementation instance.
     *
     * @return The Elytra implementation instance.
     */
    public static Server get_handle()
    {
        return handle;
    }

    /**
     * Gets the Elytra logger.
     *
     * @return The logger.
     */
    public static Logger get_logger()
    {
        return handle.get_logger();
    }

    /**
     * Gets the name.
     *
     * @return The name.
     */
    public static String get_name()
    {
        return handle.get_name();
    }

    /**
     * Gets the Elytra version.
     *
     * @return The Elytra version.
     */
    public static String get_version()
    {
        return handle.get_version();
    }

    /**
     * Gets the Java Edition version.
     *
     * @return The version.
     */
    public static String get_mc_version()
    {
        return handle.get_mc_version();
    }

    /**
     * Gets the Bedrock Edition version.
     *
     * @return The version.
     */
    public static String get_mc_bedrock_version()
    {
        return handle.get_mc_bedrock_version();
    }

    /**
     * Gets the protocol version.
     *
     * @return The protocol version.
     */
    public static int get_protocol_version()
    {
        return handle.get_protocol_version();
    }

    /**
     * Gets the protocol version for Bedrock Edition.
     *
     * @return The Bedrock Edition protocol version.
     */
    public static int get_bedrock_protocol_version()
    {
        return handle.get_bedrock_protocol_version();
    }

    /**
     * Gets the Minecraft brand.
     *
     * @return The Minecraft brand.
     */
    public static String get_brand()
    {
        return handle.get_brand();
    }

    /**
     * Gets the TCP port used for the server.
     *
     * @return The TCP port used.
     */
    public static int get_port()
    {
        return handle.get_port();
    }

    /**
     * Gets the UDP port used for the server.
     *
     * @return The UDP port used.
     */
    public static int get_bedrock_port()
    {
        return handle.get_bedrock_port();
    }

    /**
     * Gets the maximum player count connected at once.
     *
     * @return The maximum player count.
     */
    public static int get_max_players()
    {
        return handle.get_max_players();
    }

    /**
     * Gets the online players.
     *
     * @return Online players.
     */
    public static Collection<EntityPlayer> get_online_players()
    {
        return handle.get_online_players();
    }

    public static ServerPing get_server_ping()
    {
        return handle.get_server_ping();
    }

    /**
     * Updates the server's ping information.
     */
    public static void update_server_ping()
    {
        handle.update_server_ping();
    }

    /**
     * Gets the network compression threshold.
     *
     * @return The compression threshold.
     */
    public static int get_compression_threshold()
    {
        return handle.get_compression_threshold();
    }

    /**
     * Gets the addon manager.
     *
     * @return The addon manager.
     */
    public static AddonManager get_addon_manager()
    {
        return handle.get_addon_manager();
    }
}
