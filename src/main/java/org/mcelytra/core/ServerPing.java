/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core;

import com.google.gson.*;
import com.mojang.authlib.GameProfile;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.chat.*;
import org.aperlambda.lambdacommon.LambdaConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Represents a server ping result.
 *
 * @author lambdaurora
 * @version 1.0.0
 * @since 1.0.0
 */
public class ServerPing
{
    private int               max_players  = 0;
    private int               online       = 0;
    private String            favicon;
    private String            version_name = "";
    private int               protocol     = 0;
    private BaseComponent[]   motd         = new BaseComponent[0];
    private List<GameProfile> players      = new ArrayList<>();

    public ServerPing()
    {
    }

    /**
     * Gets the maximum players displayed in the ping result.
     *
     * @return The maximum players count.
     */
    public int get_max_players()
    {
        return this.max_players;
    }

    /**
     * Sets the maximum players displayed in the ping result.
     *
     * @param max_players The maximum players count.
     */
    public void set_max_players(int max_players)
    {
        this.max_players = max_players;
    }

    /**
     * Gets the number of players online in the ping result.
     *
     * @return The number of players online.
     */
    public int get_online_count()
    {
        return this.online;
    }

    /**
     * Sets the number of players online in the ping result.
     *
     * @param online The number of players online.
     */
    public void set_online_count(int online)
    {
        this.online = online;
    }

    /**
     * Gets the favicon of the ping result. It's an image encoded in Base64.
     *
     * @return The favicon.
     */
    public String get_favicon()
    {
        return this.favicon;
    }

    /**
     * Sets the favicon of the ping result. It's an image encoded in Base 64.
     *
     * @param favicon The favicon.
     */
    public void set_favicon(String favicon)
    {
        this.favicon = favicon;
    }

    /**
     * Loads the favicon from the default server file.
     *
     * @throws IOException Thrown when an IO exception happens while reading the file.
     */
    public void load_favicon() throws IOException
    {
        load_favicon(new File("server-icon.png"));
    }

    /**
     * Loads the favicon from the specified file.
     *
     * @param favicon_file The favicon file.
     * @throws IOException Thrown when an IO exception happens while reading the file.
     */
    public void load_favicon(@NotNull File favicon_file) throws IOException
    {
        if (!favicon_file.exists())
            return;
        BufferedImage image = ImageIO.read(favicon_file);
        if (image.getWidth() == 64 && image.getHeight() == 64) {
            ByteArrayOutputStream ouput = new ByteArrayOutputStream();
            ImageIO.write(image, "png", ouput);
            ouput.flush();
            this.favicon = "data:image/png;base64," + Base64.getEncoder().encodeToString(ouput.toByteArray());
        } else
            throw new RuntimeException("The favicon image needs to be 64px of width and height!");
    }

    /**
     * Gets the version name of the ping result.
     *
     * @return The version name.
     */
    public String get_version_name()
    {
        return this.version_name;
    }

    /**
     * Sets the version name of the ping result.
     *
     * @param version_name The version name.
     */
    public void set_version_name(String version_name)
    {
        this.version_name = version_name;
    }

    /**
     * Gets the used protocol of the ping result.
     * <p>For more information on protocols, please see <a href="http://wiki.vg/Protocol_History">wiki.vg Protocol History</a></p>
     *
     * @return The used protocol.
     */
    public int get_protocol()
    {
        return this.protocol;
    }

    /**
     * Sets the used protocol of the ping result.
     * <p>For more information on protocols, please see <a href="http://wiki.vg/Protocol_History">wiki.vg Protocol History</a></p>
     *
     * @param protocol The used protocol.
     */
    public void set_protocol(int protocol)
    {
        this.protocol = protocol;
    }

    /**
     * Gets the Message Of The Day of the ping result.
     *
     * @return The MOTD.
     */
    public BaseComponent[] get_motd()
    {
        return this.motd;
    }

    /**
     * Sets the Message Of The Day of the ping result.
     *
     * @param motd The MOTD.
     */
    public void set_motd(BaseComponent... motd)
    {
        this.motd = motd;
    }

    /**
     * Gets the player list of the ping result.
     *
     * @return A list of players.
     */
    public @NotNull List<GameProfile> get_players()
    {
        return this.players;
    }

    /**
     * Sets the player list of the ping result.
     *
     * @param players The player list.
     */
    public void set_players(List<GameProfile> players)
    {
        if (players == null)
            this.players = new ArrayList<>();
        this.players = players;
    }

    /**
     * Adds a player from the player list.
     *
     * @param player The player profile to add.
     */
    public void add_player(@NotNull GameProfile player)
    {
        this.players.add(player);
    }

    /**
     * Removes a player from the player list.
     *
     * @param player The player profile to remove.
     */
    public void remove_player(@Nullable GameProfile player)
    {
        if (player == null)
            return;
        players.remove(player);
    }

    /**
     * Represents the JSON serializer of {@link ServerPing}.
     */
    public static class Serializer implements JsonSerializer<ServerPing>, JsonDeserializer<ServerPing>
    {
        private final static Gson gson = new GsonBuilder().
                registerTypeAdapter(ServerPing.class, new Serializer()).
                create();

        /**
         * Parses the given JSON string as a ServerPing.
         *
         * @param json The JSON string.
         * @return The parsed ServerPing.
         */
        public static ServerPing parse(String json)
        {
            return gson.fromJson(LambdaConstants.JSON_PARSER.parse(json), ServerPing.class);
        }

        /**
         * Gets the given ServerPing as a JSON string.
         *
         * @param serverPing The ServerPing to transform.
         * @return The JSON string.
         */
        public static String to_string(ServerPing serverPing)
        {
            return gson.toJson(serverPing);
        }

        @Override
        public ServerPing deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException
        {
            ServerPing obj = new ServerPing();
            if (jsonElement instanceof JsonObject) {
                JsonObject json = (JsonObject) jsonElement;
                if (json.get("version") instanceof JsonObject) {
                    JsonObject version = json.getAsJsonObject("version");
                    if (version.has("name"))
                        obj.set_version_name(version.get("name").getAsString());
                    if (version.has("protocol"))
                        obj.set_protocol(version.get("protocol").getAsInt());
                }
                obj.set_motd(ComponentSerializer.parse(json.get("description").toString()));
                if (json.has("players") && json.get("players") instanceof JsonObject) {
                    JsonObject player_data = json.getAsJsonObject("players");
                    if (player_data.has("online"))
                        obj.set_online_count(player_data.get("online").getAsInt());
                    if (player_data.has("max"))
                        obj.set_max_players(player_data.get("max").getAsInt());
                    if (json.has("sample") && json.get("sample") instanceof JsonArray) {
                        JsonArray sample = json.getAsJsonArray("sample");
                        List<GameProfile> players = new ArrayList<>();
                        sample.forEach(element -> {
                            if (element instanceof JsonObject) {
                                JsonObject json_obj = (JsonObject) element;
                                players.add(new GameProfile(UUID.fromString(json_obj.get("id").getAsString()), json_obj.get("name").getAsString()));
                            }
                        });
                        obj.set_players(players);
                    }
                }

                if (json.has("favicon"))
                    obj.set_favicon(json.get("favicon").getAsString());
            }
            return obj;
        }

        @Override
        public JsonElement serialize(ServerPing ping, Type type, JsonSerializationContext context)
        {
            JsonObject json = new JsonObject();

            // Version data
            JsonObject version = new JsonObject();
            version.addProperty("protocol", ping.get_protocol());
            version.addProperty("name", ping.get_version_name());
            json.add("version", version);

            // Motd
            json.add("description", LambdaConstants.JSON_PARSER.parse(ComponentSerializer.toString(ping.get_motd())));

            // Favicon
            if (!((ping.get_favicon() == null) || ping.get_favicon().isEmpty()))
                json.addProperty("favicon", ping.get_favicon());

            // Players data
            JsonObject players = new JsonObject();
            players.addProperty("online", ping.get_online_count());
            players.addProperty("max", ping.get_max_players());

            JsonArray sample = new JsonArray();
            ping.get_players().stream().map(player -> {
                JsonObject player_json = new JsonObject();
                player_json.addProperty("name", player.getName() + ChatColor.RESET);
                player_json.addProperty("id", player.getId().toString());
                return player_json;
            }).forEach(sample::add);

            players.add("sample", sample);

            json.add("players", players);
            return json;
        }
    }
}
