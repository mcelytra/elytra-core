/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.config;

import com.electronwill.nightconfig.core.file.FileConfig;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.mcelytra.core.Server;
import org.mcelytra.core.util.VarStringUtils;

/**
 * Represents the configuration of Elytra server.
 */
public class ElytraServerConfig
{
    private FileConfig config = FileConfig.builder("server_config.toml").concurrent().defaultResource("/server_config.toml").build();
    private Server     server;

    public ElytraServerConfig(Server server)
    {
        this.server = server;
    }

    /**
     * Loads the configuration.
     */
    public void load()
    {
        config.load();
    }

    public void close()
    {
        config.close();
    }

    public boolean has_debug()
    {
        return config.getOrElse("debug", false);
    }

    /**
     * Gets the server's name.
     *
     * @return The server's name.
     */
    public String get_server_name()
    {
        return config.getOrElse("server_name", "ElytraServer");
    }

    /**
     * Gets the maximum player count connected at once.
     *
     * @return The maximum player count.
     */
    public int get_max_players()
    {
        return config.getOrElse("max_players", 20);
    }

    public int get_tcp_port()
    {
        return config.getOrElse("network.port", 25565);
    }

    public int get_udp_port()
    {
        return config.getOrElse("network.bedrock_port", 19132);
    }

    public BaseComponent[] get_motd()
    {
        String line1 = ChatColor.translateAlternateColorCodes('&', config.getOrElse("motd.line1", "&rWelcome to ${server_name}"));
        String line2 = ChatColor.translateAlternateColorCodes('&', config.getOrElse("motd.line2", "Hope you enjoy!"));
        return TextComponent.fromLegacyText(VarStringUtils.apply(line1 + "\n" + line2, this.server), ChatColor.GRAY);
    }

    public int get_compression_threshold()
    {
        return this.config.getOrElse("network.compression_threshold", 256);
    }
}
