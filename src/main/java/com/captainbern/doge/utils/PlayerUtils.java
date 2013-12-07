package com.captainbern.doge.utils;

import com.captainbern.doge.Doge;
import com.captainbern.doge.reflection.ReflectionUtil;
import com.captainbern.doge.wrappers.protocol.Packet;
import org.bukkit.entity.Player;

import java.lang.reflect.Method;

public class PlayerUtils {

    public static void sendPacket(Player player, Packet packet){
        Method sendPacket = ReflectionUtil.getMethod(ReflectionUtil.getNMSClass("PlayerConnection"), "sendPacket", ReflectionUtil.getNMSClass("Packet"));
        Object playerConnection = getPlayerConnection(player);

        try {
            sendPacket.invoke(playerConnection, packet.getHandle());
        } catch (Exception e) {
            Doge.LOGGER_REFLECTION.warning("Failed to retrieve the PlayerConnection of: " + player.getName());
        }
    }

    public static Object playerToEntityPlayer(Player player){
        Method getHandle = ReflectionUtil.getMethod(player.getClass(), "getHandle");
        try {
            return getHandle.invoke(player);
        } catch (Exception e) {
            Doge.LOGGER_REFLECTION.warning("Failed retrieve the NMS Player-Object of:" + player.getName());
            return null;
        }
    }

    public static Object getPlayerConnection(Player player){
        Object connection = ReflectionUtil.getField(ReflectionUtil.getNMSClass("EntityPlayer"), "playerConnection", playerToEntityPlayer(player));
        return connection;
    }
}
