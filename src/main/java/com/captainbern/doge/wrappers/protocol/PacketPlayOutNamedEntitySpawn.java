package com.captainbern.doge.wrappers.protocol;

import com.captainbern.doge.utils.MathUtils;
import com.captainbern.doge.wrappers.DataWatcher;
import net.minecraft.util.com.mojang.authlib.GameProfile;
import org.bukkit.Location;

public class PacketPlayOutNamedEntitySpawn extends Packet {

    public PacketPlayOutNamedEntitySpawn() {
        super("PacketPlayOutNamedEntitySpawn");
    }

    public void setId(int id) {
        setField("a", id);
    }

    public void setGameProfile(GameProfile profile) {
        setField("b", profile);
    }

    public void setLocation(Location location) {
        setField("c", MathUtils.floor(location.getX()));
        setField("d", MathUtils.floor(location.getY()));
        setField("e", MathUtils.floor(location.getZ()));
        setField("f", MathUtils.asCompressedAngle(location.getYaw()));
        setField("g", MathUtils.asCompressedAngle(location.getPitch()));
    }

    public void setItemInHand(int id) {
        setField("h", id);
    }

    public void setDataWatcher(DataWatcher watcher) {
        setField("i", watcher.getHandle());
    }
}
