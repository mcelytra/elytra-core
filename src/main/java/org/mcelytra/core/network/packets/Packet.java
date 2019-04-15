/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.network.packets;

import org.mcelytra.core.network.PacketBuffer;

/**
 * Represents a packet.
 */
public interface Packet
{
    void decode(PacketBuffer buffer);

    void encode(PacketBuffer buffer);
}
