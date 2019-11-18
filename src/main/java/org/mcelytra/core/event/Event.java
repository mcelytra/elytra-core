/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.event;

import org.aperlambda.lambdacommon.Identifier;
import org.aperlambda.lambdacommon.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an event.
 */
public abstract class Event implements Identifiable
{
    private Identifier identifier;
    private boolean    async;

    public Event(Identifier identifier)
    {
        this(identifier, false);
    }

    public Event(Identifier identifier, boolean async)
    {
        this.identifier = identifier;
        this.async = async;
    }

    @Override
    public @NotNull Identifier get_identifier()
    {
        return this.identifier;
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
