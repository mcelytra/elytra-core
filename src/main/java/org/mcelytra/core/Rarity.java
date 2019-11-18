/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core;

import net.md_5.bungee.api.ChatColor;

/**
 * Represents different rarity states.
 */
public enum Rarity
{
    COMMON(ChatColor.WHITE),
    UNCOMMON(ChatColor.YELLOW),
    RARE(ChatColor.AQUA),
    EPIC(ChatColor.LIGHT_PURPLE);

    /**
     * The formatting for item's name.
     */
    public final ChatColor formatting;

    Rarity(ChatColor formatting)
    {
        this.formatting = formatting;
    }
}
