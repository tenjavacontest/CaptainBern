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

    /**
     * Sends a packet to a player.
     * @param player The player the packet needs to be send to.
     * @param packet The packet object.
     */
    public static void sendPacket(Player player, Packet packet) {
        Method sendPacket = ReflectionUtil.getMethod(ReflectionUtil.getNMSClass("PlayerConnection"), "sendPacket", ReflectionUtil.getNMSClass("Packet"));
        Object playerConnection = getPlayerConnection(player);

        try {
            sendPacket.invoke(playerConnection, packet.getHandle());
        } catch (Exception e) {
            InkHearth.LOGGER_REFLECTION.warning("Failed to send packet!");
        }
    }

    /**
     * Converts a Bukkit player to an NMS player.
     * @param player The player that needs to be converted.
     * @return The NMS player object.
     */
    public static Object playerToEntityPlayer(Player player) {
        Method getHandle = ReflectionUtil.getMethod(player.getClass(), "getHandle");
        try {
            return getHandle.invoke(player);
        } catch (Exception e) {
            InkHearth.LOGGER_REFLECTION.warning("Failed to convert bukkit player to nms player!");
            return null;
        }
    }

    /**
     * Used to obtain the PlayerConnection of a player.
     * @param player The player we need to get the connection of.
     * @return The PlayerConnection object.
     */
    public static Object getPlayerConnection(Player player) {
        Object playerConnection = ReflectionUtil.getField(ReflectionUtil.getNMSClass("EntityPlayer"), "playerConnection", playerToEntityPlayer(player));
        return playerConnection;
    }
}
