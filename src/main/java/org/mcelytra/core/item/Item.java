/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.item;

import org.jetbrains.annotations.NotNull;

/**
 * Represents an item.
 */
public class Item implements ItemConvertible
{
    @Override
    public @NotNull Item as_item()
    {
        return this;
    }
}
