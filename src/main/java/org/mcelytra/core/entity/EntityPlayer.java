/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.entity;

import com.mojang.authlib.GameProfile;
import net.md_5.bungee.api.chat.BaseComponent;
import org.jetbrains.annotations.NotNull;
import org.mcelytra.chat.ChatMessageType;
import org.mcelytra.chat.ChatVisibility;
import org.mcelytra.core.GameMode;
import org.mcelytra.core.MinecraftEdition;

import java.net.InetSocketAddress;

/**
 * Represents a player.
 */
public interface EntityPlayer extends EntityLiving
{
    /**
     * Gets the protocol version.
     *
     * @return The protocol version.
     */
    int get_protocol_version();

    /**
     * Gets the Minecraft Edition of the player.
     *
     * @return The Minecraft Edition is used by the player.
     */
    MinecraftEdition get_mc_edition();

    /**
     * Gets the brand of the Minecraft Client used by the player.
     *
     * @return The brand of the Minecraft Client.
     */
    @NotNull String get_brand();

    /**
     * Gets the address of the player.
     *
     * @return The address of the player.
     */
    InetSocketAddress get_address();

    /**
     * Gets the ping of the player in milliseconds.
     *
     * @return The ping in milliseconds.
     */
    int get_ping();

    /**
     * Gets the game profile of the player.
     *
     * @return The game profile.
     */
    default GameProfile get_profile()
    {
        return new GameProfile(this.get_unique_id(), this.get_name());
    }

    String get_locale();

    /**
     * Gets the chat visibility flag of the player.
     *
     * @return The chat visibility flag.
     * @see ChatVisibility
     */
    ChatVisibility get_chat_visibility();

    /**
     * Sends a message to the player.
     * The default {@code ChatMessageType} here is {@code SYSTEM}. Please respect the player and the use of the types.
     *
     * @param message The message to send.
     * @see ChatVisibility
     * @see EntityPlayer#send_message(ChatMessageType, BaseComponent...)
     */
    default void send_message(BaseComponent... message)
    {
        this.send_message(ChatMessageType.SYSTEM, message);
    }

    /**
     * Sends a message to the player.
     *
     * @param type    The type of the message.
     * @param message The message to send.
     * @see ChatVisibility
     */
    void send_message(ChatMessageType type, BaseComponent... message);

    /**
     * Disconnects the player with the given reason.
     *
     * @param reason The reason of the disconnection.
     */
    void disconnect(BaseComponent... reason);

    /**
     * Gets the current game mode of the player.
     *
     * @return The game mode of the player.
     */
    @NotNull GameMode get_game_mode();

    /**
     * Sets the game mode of the player.
     *
     * @param game_mode The new game mode of the player.
     */
    void set_game_mode(@NotNull GameMode game_mode);
}
