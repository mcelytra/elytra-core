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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a registry with default values.
 *
 * @param <T> The value type.
 */
public class DefaultedRegistry<T> extends SimpleRegistry<T>
{
    private final Identifier default_id;
    private       T          default_value;

    public DefaultedRegistry(Identifier default_id)
    {
        this.default_id = default_id;
    }

    @Override
    public <V extends T> T set(@NotNull Identifier id, @NotNull V entry)
    {
        if (id.equals(this.default_id))
            this.default_value = entry;
        return super.set(id, entry);
    }

    @Override
    public @Nullable Identifier get_id(@NotNull T entry)
    {
        Identifier res = super.get_id(entry);
        return res == null ? this.default_id : res;
    }

    @Override
    public @Nullable T get(@NotNull Identifier identifier)
    {
        T res = super.get(identifier);
        return res == null ? this.default_value : res;
    }

    /**
     * Gets the default identifier.
     *
     * @return The default identifier.
     */
    public @NotNull Identifier get_default_id()
    {
        return this.default_id;
    }
}
