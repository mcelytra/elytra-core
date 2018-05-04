package org.mcelytra.core;

import com.mojang.authlib.GameProfile;
import net.md_5.bungee.api.chat.BaseComponent;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

/**
 * Represents a server ping result.
 *
 * @author lambdaurora
 * @version 1.0.0-SNAPSHOT
 * @since 1.0.0-SNAPSHOT
 */
public class ServerPing
{
	private int               maxPlayers;
	private int               online;
	private String            favicon;
	private String            versionName;
	private int               protocol;
	private BaseComponent[]   motd;
	private List<GameProfile> players;

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
	public List<GameProfile> getPlayers()
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
		this.players = players;
	}
}