/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.block;

import org.aperlambda.lambdacommon.Identifier;
import org.mcelytra.core.Elytra;

/**
 * Represents a static list of block identifiers.
 */
public final class Blocks
{
    private Blocks()
    {
    }

    private static Identifier mc(String id)
    {
        return new Identifier("minecraft", id);
    }

    public static final Identifier AIR_ID = Elytra.AIR_ID;
}
