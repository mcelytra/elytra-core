/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.addon;

import org.aperlambda.lambdacommon.utils.Cancellable;
import org.jetbrains.annotations.NotNull;
import org.mcelytra.core.event.Event;
import org.mcelytra.core.event.EventPriority;
import org.mcelytra.core.event.Listener;

public class RegisteredListener
{
    private final Listener      listener;
    private final EventPriority priority;
    private final Addon         addon;
    private final EventExecutor executor;
    private final boolean       ignore_cancelled;

    public RegisteredListener(@NotNull Listener listener, @NotNull EventPriority priority, @NotNull Addon addon, @NotNull EventExecutor executor, boolean ignore_cancelled)
    {
        this.listener = listener;
        this.priority = priority;
        this.addon = addon;
        this.executor = executor;
        this.ignore_cancelled = ignore_cancelled;
    }

    public @NotNull Listener get_listener()
    {
        return this.listener;
    }

    /**
     * Gets the priority of the listener.
     *
     * @return The priority of the listener.
     */
    public @NotNull EventPriority get_priority()
    {
        return this.priority;
    }

    /**
     * Gets the addon which the listener is from.
     * @return The addon instance.
     */
    public @NotNull Addon get_addon() {
        return this.addon;
    }

    /**
     * Checks whether the registered listener ignores if the event is cancelled.
     *
     * @return True if the registered listener ignores cancelled, else false.
     */
    public boolean is_ignoring_cancelled()
    {
        return this.ignore_cancelled;
    }

    public void call(@NotNull Event event)
    {
        if (!(event instanceof Cancellable) || !((Cancellable) event).is_cancelled() || !this.is_ignoring_cancelled())
            this.executor.execute(this.listener, event);
    }
}
