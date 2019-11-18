/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.permission;

import org.aperlambda.lambdacommon.Identifier;
import org.aperlambda.lambdacommon.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a permission.
 */
public class Permission implements Identifiable
{
    private final Identifier identifier;
    private       String     description;

    public Permission(Identifier identifier)
    {
        this.identifier = identifier;
    }

    @Override
    public @NotNull Identifier get_identifier()
    {
        return this.identifier;
    }

    public String get_description()
    {
        return this.description;
    }
}
