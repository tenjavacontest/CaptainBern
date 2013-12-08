package com.captainbern.doge.netty;

import com.captainbern.doge.reflection.ReflectionUtil;
import com.captainbern.doge.wrappers.DataWatcher;
import com.captainbern.doge.wrappers.protocol.PacketPlayOutNamedEntitySpawn;
import net.minecraft.util.com.mojang.authlib.GameProfile;
import org.bukkit.entity.EntityType;

public class PacketFactory {

    /**
     * Generates a packet object.
     * @param sourcePacket
     * @param newType
     * @return
     */
    public static Object generateMobPacket(Object sourcePacket, EntityType newType) {
        ReflectionUtil.setField(sourcePacket.getClass(), "b", sourcePacket, newType.getTypeId());
        return sourcePacket;
    }

    /**
     * Generated a packet object
     * @param sourePacket
     * @param name
     * @return
     */
    public static Object generatePlayerPacket(Object sourePacket, String name) {

        PacketPlayOutNamedEntitySpawn packet = new PacketPlayOutNamedEntitySpawn();
        packet.setOriginalMobPacket(sourePacket);
        packet.setId();
        packet.setGameProfile(new GameProfile("IMA FAKE ROFL TROLL", name));
        packet.setLocation();
        packet.setItemInHand(0);

        DataWatcher dataWatcher = new DataWatcher();
        dataWatcher.write(0, (byte) 0);
        dataWatcher.write(1, (short) 0);
        dataWatcher.write(8, (byte) 0);

        packet.setDataWatcher(dataWatcher);

        return packet.getHandle();
    }
}
