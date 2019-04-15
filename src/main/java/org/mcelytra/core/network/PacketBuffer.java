/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.network;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufProcessor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.chat.ComponentSerializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;
import java.util.UUID;

public abstract class PacketBuffer extends ByteBuf
{
    protected ByteBuf byte_buf;

    public PacketBuffer(ByteBuf byte_buf)
    {
        this.byte_buf = byte_buf;
    }

    public UUID read_uuid()
    {
        return new UUID(this.read_long(), this.read_long());
    }

    public void write_uuid(UUID uuid)
    {
        this.write_long(uuid.getMostSignificantBits());
        this.write_long(uuid.getLeastSignificantBits());
    }

    public BaseComponent[] read_chat_component()
    {
        return ComponentSerializer.parse(this.read_string(32767));
    }

    public void write_chat_component(BaseComponent... components)
    {
        this.write_string(ComponentSerializer.toString(components));
    }

    public abstract int read_varint();

    public abstract void write_varint(int value);

    public abstract String read_string(int max_length);

    public abstract void write_string(String value);

    public int read_uint16_t()
    {
        return this.readUnsignedShort();
    }

    public void write_uint16_t(int value)
    {
        this.writeShort(value);
    }

    public long read_long()
    {
        return this.readLong();
    }

    public void write_long(long value)
    {
        this.writeLong(value);
    }

    @Override
    public int refCnt()
    {
        return this.byte_buf.refCnt();
    }

    @Override
    public boolean release()
    {
        return this.byte_buf.release();
    }

    @Override
    public boolean release(int decrement)
    {
        return this.byte_buf.release(decrement);
    }

    @Override
    public int capacity()
    {
        return this.byte_buf.capacity();
    }

    @Override
    public ByteBuf capacity(int newCapacity)
    {
        return this.byte_buf.capacity(newCapacity);
    }

    @Override
    public int maxCapacity()
    {
        return this.byte_buf.maxCapacity();
    }

    @Override
    public ByteBufAllocator alloc()
    {
        return this.byte_buf.alloc();
    }

    @Override
    public ByteOrder order()
    {
        return this.byte_buf.order();
    }

    @Override
    public ByteBuf order(ByteOrder endianness)
    {
        return this.byte_buf.order(endianness);
    }

    @Override
    public ByteBuf unwrap()
    {
        return this.byte_buf.unwrap();
    }

    @Override
    public boolean isDirect()
    {
        return this.byte_buf.isDirect();
    }

    @Override
    public int readerIndex()
    {
        return this.byte_buf.readerIndex();
    }

    @Override
    public ByteBuf readerIndex(int readerIndex)
    {
        return this.byte_buf.readerIndex(readerIndex);
    }

    @Override
    public int writerIndex()
    {
        return this.byte_buf.writerIndex();
    }

    @Override
    public ByteBuf writerIndex(int writerIndex)
    {
        return this.byte_buf.writerIndex(writerIndex);
    }

    @Override
    public ByteBuf setIndex(int readerIndex, int writerIndex)
    {
        return this.byte_buf.setIndex(readerIndex, writerIndex);
    }

    @Override
    public int readableBytes()
    {
        return this.byte_buf.readableBytes();
    }

    @Override
    public int writableBytes()
    {
        return this.byte_buf.writableBytes();
    }

    @Override
    public int maxWritableBytes()
    {
        return this.byte_buf.maxWritableBytes();
    }

    @Override
    public boolean isReadable()
    {
        return this.byte_buf.isReadable();
    }

    @Override
    public boolean isReadable(int size)
    {
        return this.byte_buf.isReadable(size);
    }

    @Override
    public boolean isWritable()
    {
        return this.byte_buf.isWritable();
    }

    @Override
    public boolean isWritable(int size)
    {
        return this.byte_buf.isWritable(size);
    }

    @Override
    public ByteBuf clear()
    {
        return this.byte_buf.clear();
    }

    @Override
    public ByteBuf markReaderIndex()
    {
        return this.byte_buf.markReaderIndex();
    }

    @Override
    public ByteBuf resetReaderIndex()
    {
        return this.byte_buf.resetReaderIndex();
    }

    @Override
    public ByteBuf markWriterIndex()
    {
        return this.byte_buf.markWriterIndex();
    }

    @Override
    public ByteBuf resetWriterIndex()
    {
        return this.byte_buf.resetWriterIndex();
    }

    @Override
    public ByteBuf discardReadBytes()
    {
        return this.byte_buf.discardReadBytes();
    }

    @Override
    public ByteBuf discardSomeReadBytes()
    {
        return this.byte_buf.discardSomeReadBytes();
    }

    @Override
    public ByteBuf ensureWritable(int minWritableBytes)
    {
        return this.byte_buf.ensureWritable(minWritableBytes);
    }

    @Override
    public int ensureWritable(int minWritableBytes, boolean force)
    {
        return this.byte_buf.ensureWritable(minWritableBytes, force);
    }

    @Override
    public boolean getBoolean(int index)
    {
        return this.byte_buf.getBoolean(index);
    }

    @Override
    public byte getByte(int index)
    {
        return this.byte_buf.getByte(index);
    }

    @Override
    public short getUnsignedByte(int index)
    {
        return this.byte_buf.getUnsignedByte(index);
    }

    @Override
    public short getShort(int index)
    {
        return this.byte_buf.getShort(index);
    }

    @Override
    public int getUnsignedShort(int index)
    {
        return this.byte_buf.getUnsignedShort(index);
    }

    @Override
    public int getMedium(int index)
    {
        return this.byte_buf.getMedium(index);
    }

    @Override
    public int getUnsignedMedium(int index)
    {
        return this.byte_buf.getUnsignedMedium(index);
    }

    @Override
    public int getInt(int index)
    {
        return this.byte_buf.getInt(index);
    }

    @Override
    public long getUnsignedInt(int index)
    {
        return this.byte_buf.getUnsignedInt(index);
    }

    @Override
    public long getLong(int index)
    {
        return this.byte_buf.getLong(index);
    }

    @Override
    public char getChar(int index)
    {
        return this.byte_buf.getChar(index);
    }

    @Override
    public float getFloat(int index)
    {
        return this.byte_buf.getFloat(index);
    }

    @Override
    public double getDouble(int index)
    {
        return this.byte_buf.getDouble(index);
    }

    @Override
    public ByteBuf getBytes(int index, ByteBuf dst)
    {
        return this.byte_buf.getBytes(index, dst);
    }

    @Override
    public ByteBuf getBytes(int index, ByteBuf dst, int length)
    {
        return this.byte_buf.getBytes(index, dst, length);
    }

    @Override
    public ByteBuf getBytes(int index, ByteBuf dst, int dstIndex, int length)
    {
        return this.byte_buf.getBytes(index, dst, dstIndex, length);
    }

    @Override
    public ByteBuf getBytes(int index, byte[] dst)
    {
        return this.byte_buf.getBytes(index, dst);
    }

    @Override
    public ByteBuf getBytes(int index, byte[] dst, int dstIndex, int length)
    {
        return this.byte_buf.getBytes(index, dst, dstIndex, length);
    }

    @Override
    public ByteBuf getBytes(int index, ByteBuffer dst)
    {
        return this.byte_buf.getBytes(index, dst);
    }

    @Override
    public ByteBuf getBytes(int index, OutputStream out, int length) throws IOException
    {
        return this.byte_buf.getBytes(index, out, length);
    }

    @Override
    public int getBytes(int index, GatheringByteChannel out, int length) throws IOException
    {
        return this.byte_buf.getBytes(index, out, length);
    }

    @Override
    public ByteBuf setBoolean(int index, boolean value)
    {
        return this.byte_buf.setBoolean(index, value);
    }

    @Override
    public ByteBuf setByte(int index, int value)
    {
        return this.byte_buf.setByte(index, value);
    }

    @Override
    public ByteBuf setShort(int index, int value)
    {
        return this.byte_buf.setShort(index, value);
    }

    @Override
    public ByteBuf setMedium(int index, int value)
    {
        return this.byte_buf.setMedium(index, value);
    }

    @Override
    public ByteBuf setInt(int index, int value)
    {
        return this.byte_buf.setInt(index, value);
    }

    @Override
    public ByteBuf setLong(int index, long value)
    {
        return this.byte_buf.setLong(index, value);
    }

    @Override
    public ByteBuf setChar(int index, int value)
    {
        return this.byte_buf.setChar(index, value);
    }

    @Override
    public ByteBuf setFloat(int index, float value)
    {
        return this.byte_buf.setFloat(index, value);
    }

    @Override
    public ByteBuf setDouble(int index, double value)
    {
        return this.byte_buf.setDouble(index, value);
    }

    @Override
    public ByteBuf setBytes(int index, ByteBuf src)
    {
        return this.byte_buf.setBytes(index, src);
    }

    @Override
    public ByteBuf setBytes(int index, ByteBuf src, int length)
    {
        return this.byte_buf.setBytes(index, src, length);
    }

    @Override
    public ByteBuf setBytes(int index, ByteBuf src, int srcIndex, int length)
    {
        return this.byte_buf.setBytes(index, src, srcIndex, length);
    }

    @Override
    public ByteBuf setBytes(int index, byte[] src)
    {
        return this.byte_buf.setBytes(index, src);
    }

    @Override
    public ByteBuf setBytes(int index, byte[] src, int srcIndex, int length)
    {
        return this.byte_buf.setBytes(index, src, srcIndex, length);
    }

    @Override
    public ByteBuf setBytes(int index, ByteBuffer src)
    {
        return this.byte_buf.setBytes(index, src);
    }

    @Override
    public int setBytes(int index, InputStream in, int length) throws IOException
    {
        return this.byte_buf.setBytes(index, in, length);
    }

    @Override
    public int setBytes(int index, ScatteringByteChannel in, int length) throws IOException
    {
        return this.byte_buf.setBytes(index, in, length);
    }

    @Override
    public ByteBuf setZero(int index, int length)
    {
        return this.byte_buf.setZero(index, length);
    }

    @Override
    public boolean readBoolean()
    {
        return this.byte_buf.readBoolean();
    }

    @Override
    public byte readByte()
    {
        return this.byte_buf.readByte();
    }

    @Override
    public short readUnsignedByte()
    {
        return this.byte_buf.readUnsignedByte();
    }

    @Override
    public short readShort()
    {
        return this.byte_buf.readShort();
    }

    @Override
    public int readUnsignedShort()
    {
        return this.byte_buf.readUnsignedShort();
    }

    @Override
    public int readMedium()
    {
        return this.byte_buf.readMedium();
    }

    @Override
    public int readUnsignedMedium()
    {
        return this.byte_buf.readUnsignedMedium();
    }

    @Override
    public int readInt()
    {
        return this.byte_buf.readInt();
    }

    @Override
    public long readUnsignedInt()
    {
        return this.byte_buf.readUnsignedInt();
    }

    @Override
    public long readLong()
    {
        return this.byte_buf.readLong();
    }

    @Override
    public char readChar()
    {
        return this.byte_buf.readChar();
    }

    @Override
    public float readFloat()
    {
        return this.byte_buf.readFloat();
    }

    @Override
    public double readDouble()
    {
        return this.byte_buf.readDouble();
    }

    @Override
    public ByteBuf readBytes(int length)
    {
        return this.byte_buf.readBytes(length);
    }

    @Override
    public ByteBuf readSlice(int length)
    {
        return this.byte_buf.readSlice(length);
    }

    @Override
    public ByteBuf readBytes(ByteBuf dst)
    {
        return this.byte_buf.readBytes(dst);
    }

    @Override
    public ByteBuf readBytes(ByteBuf dst, int length)
    {
        return this.byte_buf.readBytes(dst, length);
    }

    @Override
    public ByteBuf readBytes(ByteBuf dst, int dstIndex, int length)
    {
        return this.byte_buf.readBytes(dst, dstIndex, length);
    }

    @Override
    public ByteBuf readBytes(byte[] dst)
    {
        return this.byte_buf.readBytes(dst);
    }

    @Override
    public ByteBuf readBytes(byte[] dst, int dstIndex, int length)
    {
        return this.byte_buf.readBytes(dst, dstIndex, length);
    }

    @Override
    public ByteBuf readBytes(ByteBuffer dst)
    {
        return this.byte_buf.readBytes(dst);
    }

    @Override
    public ByteBuf readBytes(OutputStream out, int length) throws IOException
    {
        return this.byte_buf.readBytes(out, length);
    }

    @Override
    public int readBytes(GatheringByteChannel out, int length) throws IOException
    {
        return this.byte_buf.readBytes(out, length);
    }

    @Override
    public ByteBuf skipBytes(int length)
    {
        return this.byte_buf.skipBytes(length);
    }

    @Override
    public ByteBuf writeBoolean(boolean value)
    {
        return this.byte_buf.writeBoolean(value);
    }

    @Override
    public ByteBuf writeByte(int value)
    {
        return this.byte_buf.writeByte(value);
    }

    @Override
    public ByteBuf writeShort(int value)
    {
        return this.byte_buf.writeShort(value);
    }

    @Override
    public ByteBuf writeMedium(int value)
    {
        return this.byte_buf.writeMedium(value);
    }

    @Override
    public ByteBuf writeInt(int value)
    {
        return this.byte_buf.writeInt(value);
    }

    @Override
    public ByteBuf writeLong(long value)
    {
        return this.byte_buf.writeLong(value);
    }

    @Override
    public ByteBuf writeChar(int value)
    {
        return this.byte_buf.writeChar(value);
    }

    @Override
    public ByteBuf writeFloat(float value)
    {
        return this.byte_buf.writeFloat(value);
    }

    @Override
    public ByteBuf writeDouble(double value)
    {
        return this.byte_buf.writeDouble(value);
    }

    @Override
    public ByteBuf writeBytes(ByteBuf src)
    {
        return this.byte_buf.writeBytes(src);
    }

    @Override
    public ByteBuf writeBytes(ByteBuf src, int length)
    {
        return this.byte_buf.writeBytes(src, length);
    }

    @Override
    public ByteBuf writeBytes(ByteBuf src, int srcIndex, int length)
    {
        return this.byte_buf.writeBytes(src, srcIndex, length);
    }

    @Override
    public ByteBuf writeBytes(byte[] src)
    {
        return this.byte_buf.writeBytes(src);
    }

    @Override
    public ByteBuf writeBytes(byte[] src, int srcIndex, int length)
    {
        return this.byte_buf.writeBytes(src, srcIndex, length);
    }

    @Override
    public ByteBuf writeBytes(ByteBuffer src)
    {
        return this.byte_buf.writeBytes(src);
    }

    @Override
    public int writeBytes(InputStream in, int length) throws IOException
    {
        return this.byte_buf.writeBytes(in, length);
    }

    @Override
    public int writeBytes(ScatteringByteChannel in, int length) throws IOException
    {
        return this.byte_buf.writeBytes(in, length);
    }

    @Override
    public ByteBuf writeZero(int length)
    {
        return this.byte_buf.writeZero(length);
    }

    @Override
    public int indexOf(int fromIndex, int toIndex, byte value)
    {
        return this.byte_buf.indexOf(fromIndex, toIndex, value);
    }

    @Override
    public int bytesBefore(byte value)
    {
        return this.byte_buf.bytesBefore(value);
    }

    @Override
    public int bytesBefore(int length, byte value)
    {
        return this.byte_buf.bytesBefore(length, value);
    }

    @Override
    public int bytesBefore(int index, int length, byte value)
    {
        return this.byte_buf.bytesBefore(index, length, value);
    }

    @Override
    public int forEachByte(ByteBufProcessor processor)
    {
        return this.byte_buf.forEachByte(processor);
    }

    @Override
    public int forEachByte(int index, int length, ByteBufProcessor processor)
    {
        return this.byte_buf.forEachByte(index, length, processor);
    }

    @Override
    public int forEachByteDesc(ByteBufProcessor processor)
    {
        return this.byte_buf.forEachByteDesc(processor);
    }

    @Override
    public int forEachByteDesc(int index, int length, ByteBufProcessor processor)
    {
        return this.byte_buf.forEachByteDesc(index, length, processor);
    }

    @Override
    public ByteBuf copy()
    {
        return this.byte_buf.copy();
    }

    @Override
    public ByteBuf copy(int index, int length)
    {
        return this.byte_buf.copy(index, length);
    }

    @Override
    public ByteBuf slice()
    {
        return this.byte_buf.slice();
    }

    @Override
    public ByteBuf slice(int index, int length)
    {
        return this.byte_buf.slice(index, length);
    }

    @Override
    public ByteBuf duplicate()
    {
        return this.byte_buf.duplicate();
    }

    @Override
    public int nioBufferCount()
    {
        return this.byte_buf.nioBufferCount();
    }

    @Override
    public ByteBuffer nioBuffer()
    {
        return this.byte_buf.nioBuffer();
    }

    @Override
    public ByteBuffer nioBuffer(int index, int length)
    {
        return this.byte_buf.nioBuffer(index, length);
    }

    @Override
    public ByteBuffer internalNioBuffer(int index, int length)
    {
        return this.byte_buf.internalNioBuffer(index, length);
    }

    @Override
    public ByteBuffer[] nioBuffers()
    {
        return this.byte_buf.nioBuffers();
    }

    @Override
    public ByteBuffer[] nioBuffers(int index, int length)
    {
        return this.byte_buf.nioBuffers(index, length);
    }

    @Override
    public boolean hasArray()
    {
        return this.byte_buf.hasArray();
    }

    @Override
    public byte[] array()
    {
        return this.byte_buf.array();
    }

    @Override
    public int arrayOffset()
    {
        return this.byte_buf.arrayOffset();
    }

    @Override
    public boolean hasMemoryAddress()
    {
        return this.byte_buf.hasMemoryAddress();
    }

    @Override
    public long memoryAddress()
    {
        return this.byte_buf.memoryAddress();
    }

    @Override
    public String toString(Charset charset)
    {
        return this.byte_buf.toString(charset);
    }

    @Override
    public String toString(int index, int length, Charset charset)
    {
        return this.byte_buf.toString(index, length, charset);
    }

    @Override
    public int hashCode()
    {
        return this.byte_buf.hashCode();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        PacketBuffer buffer = (PacketBuffer) o;

        return byte_buf.equals(buffer.byte_buf);
    }

    @Override
    public int compareTo(ByteBuf buffer)
    {
        return this.byte_buf.compareTo(buffer);
    }

    @Override
    public String toString()
    {
        return this.byte_buf.toString();
    }

    @Override
    public ByteBuf retain(int increment)
    {
        return this.byte_buf.retain(increment);
    }

    @Override
    public ByteBuf retain()
    {
        return this.byte_buf.retain();
    }
}
