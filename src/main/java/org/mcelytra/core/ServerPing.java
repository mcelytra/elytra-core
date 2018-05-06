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
 * @version 1.0.0-SNAPSHOT
 * @since 1.0.0-SNAPSHOT
 */
public class ServerPing
{
	private int               maxPlayers  = 0;
	private int               online      = 0;
	private String            favicon;
	private String            versionName = "";
	private int               protocol    = 0;
	private BaseComponent[]   motd        = new BaseComponent[0];
	private List<GameProfile> players     = Collections.emptyList();

	public ServerPing()
	{
	}

	/**
	 * Gets the maximum players displayed in the ping result.
	 *
	 * @return The maximum players count.
	 */
	public int getMaxPlayers()
	{
		return maxPlayers;
	}

	/**
	 * Sets the maximum players displayed in the ping result.
	 *
	 * @param maxPlayers The maximum players count.
	 */
	public void setMaxPlayers(int maxPlayers)
	{
		this.maxPlayers = maxPlayers;
	}

	/**
	 * Gets the number of players online in the ping result.
	 *
	 * @return The number of players online.
	 */
	public int getOnlineCount()
	{
		return online;
	}

	/**
	 * Sets the number of players online in the ping result.
	 *
	 * @param online The number of players online.
	 */
	public void setOnlineCount(int online)
	{
		this.online = online;
	}

	/**
	 * Gets the favicon of the ping result. It's an image encoded in Base64.
	 *
	 * @return The favicon.
	 */
	public String getFavicon()
	{
		return favicon;
	}

	/**
	 * Sets the favicon of the ping result. It's an image encoded in Base 64.
	 *
	 * @param favicon The favicon.
	 */
	public void setFavicon(String favicon)
	{
		this.favicon = favicon;
	}

	/**
	 * Loads the favicon from the default server file.
	 *
	 * @throws IOException Thrown when an IO exception happens while reading the file.
	 */
	public void loadFavicon() throws IOException
	{
		loadFavicon(new File("server-icon.png"));
	}

	/**
	 * Loads the favicon from the specified file.
	 *
	 * @param faviconFile The favicon file.
	 * @throws IOException Thrown when an IO exception happens while reading the file.
	 */
	public void loadFavicon(@NotNull File faviconFile) throws IOException
	{
		if (!faviconFile.exists())
			return;
		BufferedImage image = ImageIO.read(faviconFile);
		if (image.getWidth() == 64 && image.getHeight() == 64)
		{
			ByteArrayOutputStream ouput = new ByteArrayOutputStream();
			ImageIO.write(image, "png", ouput);
			ouput.flush();
			this.favicon = "data:image/png;base64," + Base64.getEncoder().encodeToString(ouput.toByteArray());
		}
		else
			throw new RuntimeException("The favicon image needs to be 64px of width and height!");
	}

	/**
	 * Gets the version name of the ping result.
	 *
	 * @return The version name.
	 */
	public String getVersionName()
	{
		return versionName;
	}

	/**
	 * Sets the version name of the ping result.
	 *
	 * @param versionName The version name.
	 */
	public void setVersionName(String versionName)
	{
		this.versionName = versionName;
	}

	/**
	 * Gets the used protocol of the ping result.
	 * <p>For more information on protocols, please see <a href="http://wiki.vg/Protocol_History">wiki.vg Protocol History</a></p>
	 *
	 * @return The used protocol.
	 */
	public int getProtocol()
	{
		return protocol;
	}

	/**
	 * Sets the used protocol of the ping result.
	 * <p>For more information on protocols, please see <a href="http://wiki.vg/Protocol_History">wiki.vg Protocol History</a></p>
	 *
	 * @param protocol The used protocol.
	 */
	public void setProtocol(int protocol)
	{
		this.protocol = protocol;
	}

	/**
	 * Gets the Message Of The Day of the ping result.
	 *
	 * @return The MOTD.
	 */
	public BaseComponent[] getMotd()
	{
		return motd;
	}

	/**
	 * Sets the Message Of The Day of the ping result.
	 *
	 * @param motd The MOTD.
	 */
	public void setMotd(BaseComponent... motd)
	{
		this.motd = motd;
	}

	/**
	 * Gets the player list of the ping result.
	 *
	 * @return A list of players.
	 */
	public @NotNull List<GameProfile> getPlayers()
	{
		return players;
	}

	/**
	 * Sets the player list of the ping result.
	 *
	 * @param players The player list.
	 */
	public void setPlayers(List<GameProfile> players)
	{
		if (players == null)
			this.players = Collections.emptyList();
		this.players = players;
	}

	/**
	 * Adds a player from the player list.
	 *
	 * @param player The player profile to add.
	 */
	public void addPlayer(@NotNull GameProfile player)
	{
		players.add(player);
	}

	/**
	 * Removes a player from the player list.
	 *
	 * @param player The player profile to remove.
	 */
	public void removePlayer(@Nullable GameProfile player)
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
		public static String toString(ServerPing serverPing)
		{
			return gson.toJson(serverPing);
		}

		@Override
		public ServerPing deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException
		{
			ServerPing obj = new ServerPing();
			if (jsonElement instanceof JsonObject)
			{
				JsonObject json = (JsonObject) jsonElement;
				if (json.get("version") instanceof JsonObject)
				{
					JsonObject version = json.getAsJsonObject("version");
					if (version.has("name"))
						obj.setVersionName(version.get("name").getAsString());
					if (version.has("protocol"))
						obj.setProtocol(version.get("protocol").getAsInt());
				}
				obj.setMotd(ComponentSerializer.parse(json.get("description").toString()));
				if (json.has("players") && json.get("players") instanceof JsonObject)
				{
					JsonObject playerData = json.getAsJsonObject("players");
					if (playerData.has("online"))
						obj.setOnlineCount(playerData.get("online").getAsInt());
					if (playerData.has("max"))
						obj.setMaxPlayers(playerData.get("max").getAsInt());
					if (json.has("sample") && json.get("sample") instanceof JsonArray)
					{
						JsonArray sample = json.getAsJsonArray("sample");
						List<GameProfile> players = new ArrayList<>();
						sample.forEach(element -> {
							if (element instanceof JsonObject)
							{
								JsonObject json_obj = (JsonObject) element;
								players.add(new GameProfile(UUID.fromString(json_obj.get("id").getAsString()), json_obj.get("name").getAsString()));
							}
						});
						obj.setPlayers(players);
					}
				}

				if (json.has("favicon"))
					obj.setFavicon(json.get("favicon").getAsString());
			}
			return obj;
		}

		@Override
		public JsonElement serialize(ServerPing ping, Type type, JsonSerializationContext context)
		{
			JsonObject json = new JsonObject();

			// Version data
			JsonObject version = new JsonObject();
			version.addProperty("protocol", ping.getProtocol());
			version.addProperty("name", ping.getVersionName());
			json.add("version", version);

			// Motd
			json.add("description", LambdaConstants.JSON_PARSER.parse(ComponentSerializer.toString(ping.getMotd())));

			// Favicon
			if (!((ping.getFavicon() == null) || ping.getFavicon().isEmpty()))
				json.addProperty("favicon", ping.getFavicon());

			// Players data
			JsonObject players = new JsonObject();
			players.addProperty("online", ping.getOnlineCount());
			players.addProperty("max", ping.getMaxPlayers());

			JsonArray sample = new JsonArray();
			ping.getPlayers().stream().map(player -> {
				JsonObject playerJson = new JsonObject();
				playerJson.addProperty("name", player.getName() + ChatColor.RESET);
				playerJson.addProperty("id", player.getId().toString());
				return playerJson;
			}).forEach(sample::add);

			players.add("sample", sample);

			json.add("players", players);
			return json;
		}
	}
}