/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.registry;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.apache.commons.lang3.Validate;
import org.aperlambda.lambdacommon.Identifier;
import org.aperlambda.lambdacommon.utils.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Represents a simple implementation of a registry.
 *
 * @param <T> The value type.
 */
public class SimpleRegistry<T> extends Registry<T>
{
    protected final BiMap<Identifier, T> entries = HashBiMap.create();

    public @Nullable Identifier get_id(@NotNull T entry)
    {
        return this.entries.inverse().get(entry);
    }

    public @Nullable T get(@NotNull Identifier identifier)
    {
        return this.entries.get(identifier);
    }

    public boolean has(@NotNull Identifier identifier)
    {
        return this.entries.containsKey(identifier);
    }

    public boolean has(@NotNull T entry)
    {
        return this.entries.containsValue(entry);
    }

    @Override
    protected <V extends T> T set(@NotNull Identifier id, @NotNull V entry)
    {
        Validate.notNull(id);
        Validate.notNull(entry);

        if (this.has(id))
            throw new IllegalStateException("Cannot registers element '" + id.toString() + "' has it is already registered.");

        this.entries.put(id, entry);

        return entry;
    }

    public boolean is_empty()
    {
        return this.entries.isEmpty();
    }

    @Override
    public int get_size()
    {
        return this.entries.size();
    }

    @Override
    public Set<Identifier> get_ids()
    {
        return Collections.unmodifiableSet(this.entries.keySet());
    }

    @Override
    public List<Pair<Identifier, T>> get_entries()
    {
        return Pair.new_list_from_map(this.entries);
    }

    @NotNull
    @Override
    public Iterator<T> iterator()
    {
        return this.entries.values().iterator();
    }
}
