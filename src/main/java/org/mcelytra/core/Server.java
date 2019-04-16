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
import org.aperlambda.lambdacommon.utils.Nameable;

/**
 * Represents a Minecraft server.
 */
public abstract class Server implements Nameable
{
    protected Logger     logger;
    protected int        tcp_port;
    protected int        bedrock_port;
    protected boolean    running;
    protected ServerPing server_ping;

    public Server(Logger logger)
    {
        this.logger = logger;
    }

    /**
     * Gets the server logger.
     *
     * @return The logger.
     */
    public Logger get_logger()
    {
        return this.logger;
    }

    /**
     * Gets the version of the server.
     *
     * @return The version of the server.
     */
    public abstract String get_version();

    /**
     * Gets the Java Edition server version.
     *
     * @return The server version.
     */
    public abstract String get_mc_version();

    /**
     * Gets the Bedrock Edition server version.
     *
     * @return The server version.
     */
    public abstract String get_mc_bedrock_version();

    /**
     * Gets the protocol version of the server.
     *
     * @return The protocol version.
     */
    public abstract int get_protocol_version();

    /**
     * Gets the protocol version of the server for Bedrock Edition.
     *
     * @return The Bedrock Edition protocol version.
     */
    public abstract int get_bedrock_protocol_version();

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
     * Checks whether the server is running or not.
     *
     * @return True if the server is running, else false.
     */
    public boolean is_running()
    {
        return this.running;
    }

    /**
     * Shutdowns the server.
     */
    public abstract void shutdown();

    public ServerPing get_server_ping()
    {
        return this.server_ping;
    }

    /**
     * Updates the server's ping information.
     */
    public abstract void update_server_ping();
}
