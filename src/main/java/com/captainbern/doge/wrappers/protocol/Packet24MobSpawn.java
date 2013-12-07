package com.captainbern.doge.wrappers.protocol;

import com.captainbern.doge.utils.MathUtils;
import com.captainbern.doge.wrappers.DataWatcher;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.util.Vector;

public class Packet24MobSpawn extends Packet {

    public Packet24MobSpawn() {
        super("Packet24MobSpawn");
    }

    public void setId(int id) {
        setField("a", id);
    }

    public void setEntityType(EntityType type) {
        setField("b", (byte) type.getTypeId());
    }

    public void setLocation(Location location) {
        Vector velocity = new Vector(0, 0, 0);

        setField("c", MathUtils.floor(location.getBlockY()));
        setField("d", MathUtils.floor(location.getBlockX()));
        setField("e", MathUtils.floor(location.getBlockZ()));
        setField("i", MathUtils.asCompressedAngle(location.getYaw()));
        setField("j", (byte) 0);
        setField("k", MathUtils.asCompressedAngle(location.getYaw()));
        setField("f", (int) velocity.getX());
        setField("g", (int) velocity.getY());
        setField("h", (int) velocity.getZ());
    }

    public void setDataWatcher(DataWatcher watcher) {
        setField("t", watcher.getHandle());
    }
}
