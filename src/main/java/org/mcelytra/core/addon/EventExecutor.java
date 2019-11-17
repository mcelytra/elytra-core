/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.addon;

import org.jetbrains.annotations.NotNull;
import org.mcelytra.core.event.Event;
import org.mcelytra.core.event.Listener;

public interface EventExecutor
{
    void execute(@NotNull Listener listener, @NotNull Event event);
}
