/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.network.packets;

import org.aperlambda.lambdacommon.utils.Nameable;
import org.jetbrains.annotations.NotNull;
import org.mcelytra.core.network.PacketBuffer;

/**
 * Represents a packet.
 */
public abstract class Packet implements Nameable
{
    @Override
    public @NotNull String get_name()
    {
        return this.getClass().getSimpleName();
    }

    /**
     * Decodes the packet from the given buffer.
     *
     * @param buffer The buffer.
     */
    public abstract void decode(PacketBuffer buffer);

    /**
     * Encodes the packet to the given buffer.
     *
     * @param buffer The buffer.
     */
    public abstract void encode(PacketBuffer buffer);
}
