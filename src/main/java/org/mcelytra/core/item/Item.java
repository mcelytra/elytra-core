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
import org.aperlambda.lambdacommon.utils.Identifiable;
import org.jetbrains.annotations.NotNull;
import org.mcelytra.core.Elytra;

import java.util.Objects;

/**
 * Represents an item.
 */
public interface Item extends ItemConvertible, Identifiable
{
    @Override
    default @NotNull Item as_item()
    {
        return this;
    }

    @Override
    default @NotNull Identifier get_identifier()
    {
        return Elytra.ITEM_REGISTRY.get_id(this);
    }

    static @NotNull Item from_id(Identifier id)
    {
        return Objects.requireNonNull(Elytra.ITEM_REGISTRY.get(id));
    }
}
