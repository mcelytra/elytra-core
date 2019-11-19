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

/**
 * Represents a stack of items.
 */
public class ItemStack
{
    public static final ItemStack EMPTY = new ItemStack(null, 0);

    private final Item    item;
    private       int     count;
    private       boolean empty;

    public ItemStack(ItemConvertible item)
    {
        this(item, 1);
    }

    public ItemStack(ItemConvertible item, int count)
    {
        this.item = item == null ? null : item.as_item();
        this.count = count;
        this.update_empty_state();
    }

    /**
     * Gets the item in this stack.
     *
     * @return The item in this stack.
     */
    public Item get_item()
    {
        return this.item;
    }

    /**
     * Gets the items count in this stack.
     *
     * @return The items count in this stack.
     */
    public int get_count()
    {
        return this.count;
    }

    /**
     * Sets the items count in this stack.
     *
     * @param count The items count in this stack.
     */
    public void set_count(int count)
    {
        this.count = count;
        this.update_empty_state();
    }

    /**
     * Returns whether this stack is empty.
     *
     * @return True if the stack is empty, else false.
     */
    public boolean is_empty()
    {
        if (this == EMPTY)
            return true;
        else if (this.get_item() != null /* @TODO AIR */) {
            return this.count <= 0;
        } else
            return true;
    }

    /**
     * Copies this stack of items.
     *
     * @return A new stack of items equivalent to the original stack.
     */
    public ItemStack copy()
    {
        if (this.is_empty())
            return EMPTY;

        ItemStack stack = new ItemStack(this.get_item(), this.count);
        return stack;
    }

    /**
     * Increments the items count in this stack.
     *
     * @param amount The amount to increment.
     */
    public void increment(int amount)
    {
        this.set_count(this.count + amount);
    }

    /**
     * Decrements the items count in this stack.
     *
     * @param amount The amount to decrement.
     */
    public void decrement(int amount)
    {
        this.increment(-amount);
    }

    /**
     * Updates the cached empty state.
     */
    private void update_empty_state()
    {
        this.empty = false;
        this.empty = this.is_empty();
    }
}
