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

/**
 * Represents the Elytra API singleton with a lot of basic stuff.
 */
public class Elytra
{
    private static Server server;

    /**
     * Initializes Elytra API singleton.
     *
     * @param server The server implementation instance.
     */
    public static void init(@NotNull Server server)
    {
        if (Elytra.server != null)
            throw new UnsupportedOperationException("Cannot redefine singleton Server.");
        Elytra.server = server;
        server.get_logger().info("This server is running " + get_brand() + " version " + get_version() + " (MC Version: Java(" + get_mc_version() + "), Bedrock(" + get_mc_bedrock_version() + "))");
    }

    /**
     * Gets the server implementation instance.
     *
     * @return The server implementation instance.
     */
    public static Server get_server()
    {
        return server;
    }

    /**
     * Gets the server logger.
     *
     * @return The logger.
     */
    public static Logger get_logger()
    {
        return server.get_logger();
    }

    /**
     * Gets the server name.
     *
     * @return The server name.
     */
    public static String get_name()
    {
        return server.get_name();
    }

    /**
     * Gets the server version.
     *
     * @return The server version.
     */
    public static String get_version()
    {
        return server.get_version();
    }

    /**
     * Gets the Java Edition server version.
     *
     * @return The server version.
     */
    public static String get_mc_version()
    {
        return server.get_mc_version();
    }

    /**
     * Gets the Bedrock Edition server version.
     *
     * @return The server version.
     */
    public static String get_mc_bedrock_version()
    {
        return server.get_mc_bedrock_version();
    }

    /**
     * Gets the server protocol version.
     *
     * @return The protocol version of the server.
     */
    public static int get_protocol_version()
    {
        return server.get_protocol_version();
    }

    /**
     * Gets the protocol version of the server for Bedrock Edition.
     *
     * @return The Bedrock Edition protocol version.
     */
    public static int get_bedrock_protocol_version()
    {
        return server.get_bedrock_protocol_version();
    }

    /**
     * Gets the server brand.
     *
     * @return The server brand.
     */
    public static String get_brand()
    {
        return server.get_brand();
    }

    /**
     * Gets the TCP port used for the server.
     *
     * @return The TCP port used.
     */
    public static int get_port()
    {
        return server.get_port();
    }

    /**
     * Gets the UDP port used for the server.
     *
     * @return The UDP port used.
     */
    public static int get_bedrock_port()
    {
        return server.get_bedrock_port();
    }

    public static ServerPing get_server_ping()
    {
        return server.get_server_ping();
    }

    /**
     * Updates the server's ping information.
     */
    public static void update_server_ping()
    {
        server.update_server_ping();
    }
}
