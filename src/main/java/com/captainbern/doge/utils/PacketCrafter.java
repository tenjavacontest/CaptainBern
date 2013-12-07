package com.captainbern.doge.utils;

import com.captainbern.doge.wrappers.DataWatcher;
import com.captainbern.doge.wrappers.protocol.Packet20NamedEntitySpawn;
import com.captainbern.doge.wrappers.protocol.Packet24MobSpawn;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class PacketCrafter {

    public static Packet24MobSpawn craftMobPacket(Entity originalEntity, EntityType newType) {
        Packet24MobSpawn packet = new Packet24MobSpawn();
        packet.setEntityType(newType);
        packet.setLocation(originalEntity.getLocation());
        packet.setId(originalEntity.getEntityId());
        packet.setAP((byte) 0);

        DataWatcher dataWatcher = new DataWatcher();
        dataWatcher.write(0, (Object) (byte) 0);
        dataWatcher.write(1, (Object) (short) 0);
        dataWatcher.write(8, (Object) (byte) 0);

        packet.setDataWatcher(dataWatcher);

        return packet;
    }

    public static Packet20NamedEntitySpawn craftHumanPacket(Entity orignalEntity, String name, int itemInHand) {
        Packet20NamedEntitySpawn packet = new Packet20NamedEntitySpawn();
        packet.setLocation(orignalEntity.getLocation());
        packet.setId(orignalEntity.getEntityId());
        packet.setItemInHand(itemInHand);
        packet.setName(name);

        DataWatcher dataWatcher = new DataWatcher();
        dataWatcher.write(0, (Object) (byte) 0);
        dataWatcher.write(1, (Object) (short) 0);
        dataWatcher.write(8, (Object) (byte) 0);

        packet.setDataWatcher(dataWatcher);

        return packet;
    }
}
