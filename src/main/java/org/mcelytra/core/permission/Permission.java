/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.permission;

import org.aperlambda.lambdacommon.resources.ResourceName;
import org.aperlambda.lambdacommon.utils.ResourceNameable;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a permission.
 */
public class Permission implements ResourceNameable
{
    private final ResourceName id;
    private       String       description;

    public Permission(ResourceName id)
    {
        this.id = id;
    }

    @Override
    public @NotNull ResourceName get_resource_name()
    {
        return this.id;
    }

    public String get_description()
    {
        return this.description;
    }
}
