package com.captainbern.doge.wrappers.protocol;

import com.captainbern.doge.utils.MathUtils;
import com.captainbern.doge.wrappers.DataWatcher;
import org.bukkit.Location;

public class Packet20NamedEntitySpawn extends Packet {

    public Packet20NamedEntitySpawn() {
          super("Packet20NamedEntitySpawn");
    }

    public void setId(int id) {
        setField("a", id);
    }

    public void setName(String name) {
        setField("b", name);
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
