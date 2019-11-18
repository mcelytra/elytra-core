/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.tag;

import org.aperlambda.lambdacommon.Identifier;

/**
 * Represents a tag
 */
public class Tag<T>
{
    private final Identifier id;

    public Tag(Identifier identifier)
    {
        this.id = identifier;
    }

    public Identifier get_id()
    {
        return this.id;
    }
}
