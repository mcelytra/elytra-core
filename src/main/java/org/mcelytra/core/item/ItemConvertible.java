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
 * Represents an object which can be converted into an item.
 */
public interface ItemConvertible
{
    @NotNull Item as_item();
}
