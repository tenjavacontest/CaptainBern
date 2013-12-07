package com.captainbern.inkhearth.utils;

import com.captainbern.inkhearth.InkHearth;
import com.captainbern.inkhearth.reflection.ReflectionUtil;
import com.captainbern.inkhearth.wrappers.Packet;
import org.bukkit.entity.Player;

import java.lang.reflect.Method;

public class PlayerUtil {

    /**
     * Class used to send packets to players yippie kayee
     */

    public static void sendPacket(Player player, Packet packet) {
        Method sendPacket = ReflectionUtil.getMethod(ReflectionUtil.getNMSClass("playerConnection"), "sebdPacket", ReflectionUtil.getNMSClass("Packet"));
        Object playerConnection = getPlayerConnection(player);

        try {
            sendPacket.invoke(playerConnection, packet.getHandle());
        } catch (Exception e) {
            InkHearth.LOGGER_REFLECTION.warning("Failed to send packet!");
        }
    }

    public static Object playerToEntityPlayer(Player player) {
        Method getHandle = ReflectionUtil.getMethod(player.getClass(), "getHandle");
        try {
            return getHandle.invoke(player);
        } catch (Exception e) {
            InkHearth.LOGGER_REFLECTION.warning("Failed to convert bukkit player to nms player!");
            return null;
        }
    }

    public static Object getPlayerConnection(Player player) {
        Object playerConnection = ReflectionUtil.getField(ReflectionUtil.getNMSClass("EntityPlayer"), "playerConnection", player);
        return playerConnection;
    }
}
