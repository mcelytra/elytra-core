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

    public static final Identifier AIR                    = Elytra.AIR_ID;
    public static final Identifier STONE                  = mc("stone");
    public static final Identifier GRANITE                = mc("granite");
    public static final Identifier POLISHED_GRANITE       = mc("polished_granite");
    public static final Identifier DIORITE                = mc("diorite");
    public static final Identifier POLISHED_DIORITE       = mc("polished_diorite");
    public static final Identifier ANDESITE               = mc("andesite");
    public static final Identifier POLISHED_ANDESITE      = mc("polished_andesite");
    public static final Identifier GRASS_BLOCK            = mc("grass_block");
    public static final Identifier DIRT                   = mc("dirt");
    public static final Identifier COARSE_DIRT            = mc("coarse_dirt");
    public static final Identifier PODZOL                 = mc("podzol");
    public static final Identifier COBBLESTONE            = mc("cobblestone");
    public static final Identifier OAK_PLANKS             = mc("oak_planks");
    public static final Identifier SPRUCE_PLANKS          = mc("spruce_planks");
    public static final Identifier BIRCH_PLANKS           = mc("birch_planks");
    public static final Identifier JUNGLE_PLANKS          = mc("jungle_planks");
    public static final Identifier ACACIA_PLANKS          = mc("acacia_planks");
    public static final Identifier DARK_OAK_PLANKS        = mc("dark_oak_planks");
    public static final Identifier OAK_SAPLING            = mc("oak_sapling");
    public static final Identifier SPRUCE_SAPLING         = mc("spruce_sapling");
    public static final Identifier BIRCH_SAPLING          = mc("birch_sapling");
    public static final Identifier JUNGLE_SAPLING         = mc("jungle_sapling");
    public static final Identifier ACACIA_SAPLING         = mc("acacia_sapling");
    public static final Identifier DARK_OAK_SAPLING       = mc("dark_oak_sapling");
    public static final Identifier BEDROCK                = mc("bedrock");
    public static final Identifier SAND                   = mc("sand");
    public static final Identifier RED_SAND               = mc("red_sand");
    public static final Identifier GRAVEL                 = mc("gravel");
    public static final Identifier GOLD_ORE               = mc("gold_ore");
    public static final Identifier IRON_ORE               = mc("iron_ore");
    public static final Identifier COAL_ORE               = mc("coal_ore");
    public static final Identifier OAK_LOG                = mc("oak_log");
    public static final Identifier SPRUCE_LOG             = mc("spruce_log");
    public static final Identifier BIRCH_LOG              = mc("birch_log");
    public static final Identifier JUNGLE_LOG             = mc("jungle_log");
    public static final Identifier ACACIA_LOG             = mc("acacia_log");
    public static final Identifier DARK_OAK_LOG           = mc("dark_oak_log");
    public static final Identifier OAK_WOOD               = mc("oak_wood");
    public static final Identifier SPRUCE_WOOD            = mc("spruce_wood");
    public static final Identifier BIRCH_WOOD             = mc("birch_wood");
    public static final Identifier JUNGLE_WOOD            = mc("jungle_wood");
    public static final Identifier ACACIA_WOOD            = mc("acacia_wood");
    public static final Identifier DARK_OAK_WOOD          = mc("dark_oak_wood");
    public static final Identifier STRIPPED_OAK_LOG       = mc("stripped_oak_log");
    public static final Identifier STRIPPED_SPRUCE_LOG    = mc("stripped_spruce_log");
    public static final Identifier STRIPPED_BIRCH_LOG     = mc("stripped_birch_log");
    public static final Identifier STRIPPED_JUNGLE_LOG    = mc("stripped_jungle_log");
    public static final Identifier STRIPPED_ACACIA_LOG    = mc("stripped_acacia_log");
    public static final Identifier STRIPPED_DARK_OAK_LOG  = mc("stripped_dark_oak_log");
    public static final Identifier STRIPPED_OAK_WOOD      = mc("stripped_oak_wood");
    public static final Identifier STRIPPED_SPRUCE_WOOD   = mc("stripped_spruce_wood");
    public static final Identifier STRIPPED_BIRCH_WOOD    = mc("stripped_birch_wood");
    public static final Identifier STRIPPED_JUNGLE_WOOD   = mc("stripped_jungle_wood");
    public static final Identifier STRIPPED_ACACIA_WOOD   = mc("stripped_acacia_wood");
    public static final Identifier STRIPPED_DARK_OAK_WOOD = mc("stripped_dark_oak_wood");
    public static final Identifier OAK_LEAVES             = mc("oak_leaves");
    public static final Identifier SPRUCE_LEAVES          = mc("spruce_leaves");
    public static final Identifier BIRCH_LEAVES           = mc("birch_leaves");
    public static final Identifier JUNGLE_LEAVES          = mc("jungle_leaves");
    public static final Identifier ACACIA_LEAVES          = mc("acacia_leaves");
    public static final Identifier DARK_OAK_LEAVES        = mc("dark_oak_leaves");
    public static final Identifier SPONGE                 = mc("sponge");
    public static final Identifier WET_SPONGE             = mc("wet_sponge");
    public static final Identifier GLASS                  = mc("glass");
    public static final Identifier LAPIS_ORE              = mc("lapis_ore");
    public static final Identifier LAPIS_BLOCK            = mc("lapis_block");
    public static final Identifier SANDSTONE              = mc("sandstone");
    public static final Identifier CHISELED_SANDSTONE     = mc("chiseled_sandstone");
    public static final Identifier CUT_SANDSTONE          = mc("cut_sandstone");
    public static final Identifier COBWEB                 = mc("cobweb");
    public static final Identifier GRASS                  = mc("grass");
    public static final Identifier FERN                   = mc("fern");
    public static final Identifier DEAD_BUSH              = mc("dead_bush");
    public static final Identifier SEAGRASS               = mc("seagrass");
    public static final Identifier SEA_PICKLE             = mc("sea_pickle");
    public static final Identifier WHITE_WOOL             = mc("white_wool");
    public static final Identifier ORANGE_WOOL            = mc("orange_wool");
    public static final Identifier MAGENTA_WOOL           = mc("magenta_wool");
    public static final Identifier LIGHT_BLUE_WOOL        = mc("light_blue_wool");
    public static final Identifier YELLOW_WOOL            = mc("yellow_wool");
    public static final Identifier LIME_WOOL              = mc("lime_wool");
    public static final Identifier PINK_WOOL              = mc("pink_wool");
    public static final Identifier GRAY_WOOL              = mc("gray_wool");
    public static final Identifier LIGHT_GRAY_WOOL        = mc("light_gray_wool");
    public static final Identifier CYAN_WOOL              = mc("cyan_wool");
    public static final Identifier PURPLE_WOOL            = mc("purple_wool");
    public static final Identifier BLUE_WOOL              = mc("blue_wool");
    public static final Identifier BROWN_WOOL             = mc("brown_wool");
    public static final Identifier GREEN_WOOL             = mc("green_wool");
    public static final Identifier RED_WOOL               = mc("red_wool");
    public static final Identifier BLACK_WOOL             = mc("black_wool");
    /* Rails */
    public static final Identifier RAIL                   = mc("rail");
    public static final Identifier POWERED_RAIL           = mc("powered_rail");
    public static final Identifier DETECTOR_RAIL          = mc("detector_rail");
    /* Redstone */
    public static final Identifier REDSTONE               = mc("redstone");
    public static final Identifier PISTON                 = mc("piston");
    public static final Identifier STICKY_PISTON          = mc("sticky_piston");
    public static final Identifier DISPENSER              = mc("dispenser");
    public static final Identifier DROPPER                = mc("dropper");
    public static final Identifier NOTE_BLOCK             = mc("note_block");
}
