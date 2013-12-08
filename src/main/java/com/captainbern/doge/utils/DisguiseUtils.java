package com.captainbern.doge.utils;

import com.captainbern.doge.Doge;
import com.captainbern.doge.EntityTable;
import com.captainbern.doge.netty.PacketFactory;
import com.captainbern.doge.reflection.ReflectionUtil;
import org.bukkit.entity.EntityType;

import java.util.Arrays;
import java.util.List;

public class DisguiseUtils {

    private static final List<EntityType> entities = Arrays.asList(EntityType.values());

    public static Object filterPacket(Object packet) throws Exception {

        if(packet.getClass().getSimpleName().equalsIgnoreCase("PacketPlayOutSpawnEntityLiving")) {

            EntityType mobType = EntityType.fromId((Integer) ReflectionUtil.getField(packet.getClass(), "b").get(packet));

            return disguiseMob(mobType, packet);

        } else {

            return packet;

        }
    }

    private static Object disguiseMob(EntityType mob, Object originalPacket) {
        if(Doge.DO_RANDOM) {

            EntityType disguise = entities.get(RandMan.nextInt(entities.size()));

            if(disguise.equals(EntityType.PLAYER)) {
                if(Doge.USE_NAMES) {
                    PacketFactory.generatePlayerPacket(originalPacket, Doge.NAMES.get(RandMan.nextInt(Doge.NAMES.size())));
                } else {
                    PacketFactory.generatePlayerPacket(originalPacket, disguise.getEntityClass().getSimpleName());
                }
            } else {

                return PacketFactory.generateMobPacket(originalPacket, disguise);
            }

        } else {

            EntityTable table = Doge.TABLE;

            EntityType type = EntityType.fromId(PacketUtils.getMobId(originalPacket));

            if(!table.contains(type)) {
                return originalPacket;
            }

            EntityType disguise = table.getDisguiseIdFor(type);

            if(disguise.equals(EntityType.PLAYER)) {
                if(Doge.USE_NAMES) {
                      PacketFactory.generatePlayerPacket(originalPacket, Doge.NAMES.get(RandMan.nextInt(Doge.NAMES.size())));
                } else {
                       PacketFactory.generatePlayerPacket(originalPacket, disguise.getEntityClass().getSimpleName());
                }
            } else {
                return PacketFactory.generateMobPacket(originalPacket, disguise);
            }
        }

        return originalPacket;

    }
}
