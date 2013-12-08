package com.captainbern.doge.wrappers.protocol;

import com.captainbern.doge.reflection.ReflectionUtil;
import com.captainbern.doge.wrappers.DataWatcher;
import net.minecraft.util.com.mojang.authlib.GameProfile;

public class PacketPlayOutNamedEntitySpawn extends Packet {

    private Object originalPacket;

    public PacketPlayOutNamedEntitySpawn() {
        super("PacketPlayOutNamedEntitySpawn");
    }

    public void setOriginalMobPacket(Object packet) {
        this.originalPacket = packet;
    }

    public void setId() {
        setField("a", (Integer) ReflectionUtil.getField(originalPacket.getClass(), "a", originalPacket));
    }

    public void setGameProfile(GameProfile profile) {
        setField("b", profile);
    }

    public void setLocation() {
        setField("c", ReflectionUtil.getField(originalPacket.getClass(), "c", originalPacket));
        setField("d", ReflectionUtil.getField(originalPacket.getClass(), "d", originalPacket));
        setField("e", ReflectionUtil.getField(originalPacket.getClass(), "e", originalPacket));

        setField("i", ReflectionUtil.getField(originalPacket.getClass(), "i", originalPacket));
        setField("j", ReflectionUtil.getField(originalPacket.getClass(), "j", originalPacket));
    }

    public void setItemInHand(int id) {
        setField("h", id);
    }

    public void setDataWatcher(DataWatcher watcher) {
        setField("l", watcher.getHandle());
    }
}
