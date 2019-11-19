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
        return null;
    }
}
