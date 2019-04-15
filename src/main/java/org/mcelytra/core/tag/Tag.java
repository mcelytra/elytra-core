/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.tag;

import org.aperlambda.lambdacommon.resources.ResourceName;

/**
 * Represents a tag
 */
public class Tag<T>
{
    private final ResourceName id;

    public Tag(ResourceName resource_name)
    {
        this.id = resource_name;
    }

    public ResourceName get_id()
    {
        return this.id;
    }
}
