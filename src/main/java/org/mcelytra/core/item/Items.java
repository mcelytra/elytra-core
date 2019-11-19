/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.item;

import org.aperlambda.lambdacommon.Identifier;
import org.mcelytra.core.Elytra;

/**
 * Represents a static list of item identifiers.
 */
public final class Items
{
    private Items()
    {
    }

    private static Identifier mc(String id)
    {
        return new Identifier("minecraft", id);
    }

    public static final Identifier AIR               = Elytra.AIR_ID;
    public static final Identifier STONE             = mc("stone");
    public static final Identifier GRANITE           = mc("granite");
    public static final Identifier POLISHED_GRANITE  = mc("polished_granite");
    public static final Identifier DIORITE           = mc("diorite");
    public static final Identifier POLISHED_DIORITE  = mc("polished_diorite");
    public static final Identifier ANDESITE          = mc("andesite");
    public static final Identifier POLISHED_ANDESITE = mc("polished_andesite");
    public static final Identifier GRASS_BLOCK       = mc("grass_block");
    public static final Identifier DIRT              = mc("dirt");
    public static final Identifier COARSE_DIRT       = mc("coarse_dirt");
    public static final Identifier PODZOL            = mc("podzol");
    public static final Identifier COBBLESTONE       = mc("cobblestone");
}
