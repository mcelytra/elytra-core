/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.registry;

import org.aperlambda.lambdacommon.Identifier;
import org.aperlambda.lambdacommon.utils.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Represents a registry.
 *
 * @param <T> The value type.
 */
public abstract class Registry<T> implements Iterable<T>
{
    /**
     * Gets the identifier of the value.
     *
     * @param entry The value to get its id.
     * @return The value's identifier.
     */
    public abstract @Nullable Identifier get_id(@NotNull T entry);

    /**
     * Gets the value from its identifier.
     *
     * @param identifier The identifier of the value.
     * @return The value assigned to the identifier.
     */
    public abstract @Nullable T get(@NotNull Identifier identifier);

    /**
     * Gets the value from its identifier.
     *
     * @param identifier The identifier of the value.
     * @return The optional value assigned to the identifier.
     * @see Registry#get(Identifier)
     */
    public @NotNull Optional<T> get_or_empty(@NotNull Identifier identifier)
    {
        return Optional.ofNullable(this.get(identifier));
    }

    /**
     * Returns whether this registry contains the specified identifier.
     *
     * @param identifier The identifier to check.
     * @return True if the registry contains the identifier, else false.
     */
    public abstract boolean has(@NotNull Identifier identifier);

    /**
     * Returns whether this registry contains the specified value.
     *
     * @param entry The value to check.
     * @return True if the registry contains the value, else false.
     */
    public abstract boolean has(@NotNull T entry);

    protected abstract <V extends T> T set(@NotNull Identifier id, @NotNull V entry);

    public <V extends T> T add(@NotNull Identifier id, @NotNull V entry)
    {
        return this.set(id, entry);
    }

    /**
     * Returns whether this registry is empty.
     *
     * @return True if this registry is empty, else false.
     */
    public abstract boolean is_empty();

    /**
     * Returns the size of this registry.
     *
     * @return The size of this registry.
     */
    public abstract int get_size();

    /**
     * Returns the identifiers present in this registry.
     *
     * @return The identifiers present in this registry.
     */
    public abstract Set<Identifier> get_ids();

    /**
     * Returns the entries present in this registry.
     *
     * @return The entries as a list.
     */
    public abstract List<Pair<Identifier, T>> get_entries();

    public Stream<T> stream()
    {
        return StreamSupport.stream(this.spliterator(), false);
    }

    public Stream<T> parallel_stream()
    {
        return StreamSupport.stream(this.spliterator(), true);
    }

    public static <T> T register(Registry<? super T> registry, @NotNull String id, @NotNull T entry)
    {
        return register(registry, new Identifier(id), entry);
    }

    @SuppressWarnings("unchecked")
    public static <T> T register(Registry<? super T> registry, @NotNull Identifier id, @NotNull T entry)
    {
        return (T) registry.add(id, entry);
    }
}
