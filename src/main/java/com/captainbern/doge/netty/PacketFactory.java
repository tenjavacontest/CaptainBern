package com.captainbern.doge.netty;

import com.captainbern.doge.reflection.ReflectionUtil;
import com.captainbern.doge.utils.PacketUtils;
import com.captainbern.doge.wrappers.DataWatcher;
import com.captainbern.doge.wrappers.protocol.PacketPlayOutNamedEntitySpawn;
import net.minecraft.util.com.mojang.authlib.GameProfile;
import org.bukkit.entity.EntityType;

public class PacketFactory {

    public static Object generateMobPacket(Object sourcePacket, EntityType newType) {
        ReflectionUtil.setField(sourcePacket.getClass(), "b", sourcePacket, newType.getTypeId());
        return sourcePacket;
    }

    public static Object generatePlayerPacket(Object sourePacket, String name) {

        PacketPlayOutNamedEntitySpawn packet = new PacketPlayOutNamedEntitySpawn();
        packet.setId((Integer) ReflectionUtil.getField(sourePacket.getClass(), "a", sourePacket));
        packet.setGameProfile(new GameProfile(String.valueOf(PacketUtils.getMobId(sourePacket)), name));
        packet.setLocation(PacketUtils.getLocation(sourePacket));

        DataWatcher dataWatcher = new DataWatcher();
        dataWatcher.write(0, (Object) (byte) 0);
        dataWatcher.write(1, (Object) (short) 0);
        dataWatcher.write(8, (Object) (byte) 0);

        packet.setDataWatcher(dataWatcher);

        return packet.getHandle();
    }
}
