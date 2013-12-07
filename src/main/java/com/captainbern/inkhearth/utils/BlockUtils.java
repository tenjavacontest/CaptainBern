package com.captainbern.inkhearth.utils;

import com.captainbern.inkhearth.wrappers.Packet55BlockBreakAnimation;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class BlockUtils {

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
