/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.inventory;

import org.mcelytra.core.item.Item;
import org.mcelytra.core.item.ItemConvertible;

public class ItemStack
{
    private final Item item;

    public ItemStack(ItemConvertible item)
    {
        this.item = item == null ? null : item.as_item();
    }
}
