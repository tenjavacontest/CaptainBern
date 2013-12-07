package com.captainbern.doge.wrappers.protocol;

import com.captainbern.doge.utils.MathUtils;
import com.captainbern.doge.wrappers.DataWatcher;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;

public class Packet24MobSpawn extends Packet {

    public Packet24MobSpawn() {
        super("Packet24MobSpawn");
        setField("f", 0);
        setField("g", 0);
        setField("h", 0);
    }

    public void setId(int id) {
        setField("a", id);
    }

    public void setEntityType(EntityType type) {
        setField("b", type.getTypeId());
    }

    public void setLocation(Location location) {
        setField("c", (int) location.getX());
        setField("d", MathUtils.floor(location.getY()));
        setField("e", (int) location.getZ());
        setField("i", MathUtils.asCompressedAngle(location.getYaw()));
        setField("j", MathUtils.asCompressedAngle(location.getPitch()));
    }

    public void setAP(byte ap) {
        setField("k", ap);
    }

    public void setDataWatcher(DataWatcher watcher) {
        setField("t", watcher.getHandle());
    }
}
