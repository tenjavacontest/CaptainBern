package com.captainbern.inkhearth.utils;

import com.captainbern.inkhearth.wrappers.Packet55BlockBreakAnimation;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class BlockUtils {

    /**
     * Makes a block appear cracked.
     * @param block The block, this can be an air block, water block or a normal block.
     * @param cracks The level of brokenness this needs to be an int between 0 and 7.
     */
    public static void setCracking(Block block, int cracks) {
        Packet55BlockBreakAnimation packet = new Packet55BlockBreakAnimation();
        packet.setDamage(cracks);
        packet.setLocation(block.getLocation());

        for(Player player : Bukkit.getOnlinePlayers()) {
            if(!player.getWorld().getName().equals(block.getWorld().getName())) {
                continue;
            }
            PlayerUtil.sendPacket(player, packet);
        }
    }
}
