package com.captainbern.doge.wrappers.protocol;

import com.captainbern.doge.utils.MathUtils;
import com.captainbern.doge.wrappers.DataWatcher;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;

public class Packet24MobSpawn extends Packet {

    public Packet24MobSpawn() {
        super("Packet24MobSpawn");
        setField("f", 3.9D * 8000.0D);
        setField("g", 3.9D * 8000.0D);
        setField("h", 3.9D * 8000.0D);
    }

    public void setId(int id) {
        setField("a", id);
    }

    public void setEntityType(EntityType type) {
        setField("b", type.getTypeId());
    }

    public void setLocation(Location location) {
        setField("c", location.getX());
        setField("d", MathUtils.floor(location.getY()));
        setField("e", location.getZ());
        setField("i", MathUtils.asCompressedAngle(location.getYaw()));
        setField("j", MathUtils.asCompressedAngle(location.getPitch()));
    }

    public void setAP(float ap) {
        setField("k", ap);
    }

    public void setDataWatcher(DataWatcher watcher) {
        setField("t", watcher.getHandle());
    }
}
