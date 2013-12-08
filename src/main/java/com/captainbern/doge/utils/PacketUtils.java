package com.captainbern.doge.utils;

import com.captainbern.doge.reflection.ReflectionUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class PacketUtils {

    public static int getMobId(Object mobPacket) {
        return ReflectionUtil.getField(mobPacket.getClass(), "b", mobPacket);
    }

    public static Location getLocation(Object sourcePacket) {
        int x = ReflectionUtil.getField(sourcePacket.getClass(), "c", sourcePacket);
        int y = ReflectionUtil.getField(sourcePacket.getClass(), "d", sourcePacket);
        int z = ReflectionUtil.getField(sourcePacket.getClass(), "e", sourcePacket);
        byte yaw = ReflectionUtil.getField(sourcePacket.getClass(), "i", sourcePacket);
        byte pitch = ReflectionUtil.getField(sourcePacket.getClass( ), "j", sourcePacket);

        Location location = new Location(Bukkit.getServer().getWorlds().get(0), x  / 32.0D, y / 32.0D, z / 32.0D);
        location.setY(yaw / 265.0F * 360.0F);
        location.setPitch(pitch / 265.0F * 360.0F);

        return location;
    }
}
