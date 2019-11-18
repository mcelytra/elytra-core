/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.event.player;

import org.aperlambda.lambdacommon.Identifier;
import org.jetbrains.annotations.NotNull;
import org.mcelytra.core.entity.EntityPlayer;
import org.mcelytra.core.event.Event;

public abstract class PlayerEvent extends Event
{
    private final EntityPlayer player;

    public PlayerEvent(@NotNull Identifier identifier, @NotNull EntityPlayer player)
    {
        super(identifier);
        this.player = player;
    }

    public PlayerEvent(@NotNull Identifier identifier, @NotNull EntityPlayer player, boolean async)
    {
        super(identifier, async);
        this.player = player;
    }

    public @NotNull EntityPlayer get_player()
    {
        return this.player;
    }
}
