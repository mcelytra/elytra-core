/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.event;

import org.aperlambda.lambdacommon.resources.ResourceName;
import org.aperlambda.lambdacommon.utils.ResourceNameable;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an event.
 */
public abstract class Event implements ResourceNameable
{
    private ResourceName name;
    private boolean      async;

    public Event(ResourceName name)
    {
        this(name, false);
    }

    public Event(ResourceName name, boolean async)
    {
        this.name = name;
        this.async = async;
    }

    @Override
    public @NotNull ResourceName get_resource_name()
    {
        return this.name;
    }

    /**
     * Checks whether the event was called asynchronously.
     *
     * @return True if the event was called asynchronously, else false.
     */
    public boolean is_async()
    {
        return this.async;
    }

    /**
     * Gets the handler list.
     * @return The handler list.
     */
    public abstract @NotNull HandlerList get_handlers();
}
