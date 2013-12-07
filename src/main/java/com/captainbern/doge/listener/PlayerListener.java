package com.captainbern.doge.listener;

import com.captainbern.doge.Doge;
import com.captainbern.doge.EntityTable;
import com.captainbern.doge.utils.PacketCrafter;
import com.captainbern.doge.utils.PlayerUtils;
import com.captainbern.doge.utils.RandMan;
import com.captainbern.doge.wrappers.protocol.Packet;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.Arrays;
import java.util.List;

public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

    }

    @EventHandler
    public void onSpawn(PlayerRespawnEvent event) {

    }

    @EventHandler
    public void onTeleport(PlayerTeleportEvent event) {

    }

    @EventHandler
    public void onSpawn(final CreatureSpawnEvent event) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Doge.getInstance(), new Runnable() {
            @Override
            public void run() {
                disguiseMob(event.getEntity());
            }
        }, 20L);
    }

    /**
     * Method used to disguise a specific mob
     * @param mob The mob that needs to be disguised.
     */
    public void disguiseMob(Entity mob) {
        if(Doge.DO_RANDOM) {

            List<EntityType> entities = Arrays.asList(EntityType.values());
            EntityType disguise = entities.get(RandMan.nextInt(entities.size()));

            if(disguise.equals(EntityType.PLAYER)) {
                if(Doge.USE_NAMES) {
                    sendPacket(PacketCrafter.craftHumanPacket(mob, Doge.NAMES.get(RandMan.nextInt(Doge.NAMES.size())), 0), mob.getWorld());
                }else{
                    sendPacket(PacketCrafter.craftHumanPacket(mob, mob.getClass().getSimpleName(), 0), mob.getWorld());
                }
            }

        }else{
            EntityTable table = Doge.TABLE;

            if(table.getDisguiseIdFor(mob.getType()) != null) {

                EntityType disguise = table.getDisguiseIdFor(mob.getType());

                if(disguise.equals(EntityType.PLAYER)) {
                    if(Doge.USE_NAMES) {
                        sendPacket(PacketCrafter.craftHumanPacket(mob, Doge.NAMES.get(RandMan.nextInt(Doge.NAMES.size())), 0), mob.getWorld());
                    }else{
                        sendPacket(PacketCrafter.craftHumanPacket(mob, mob.getClass().getSimpleName(), 0), mob.getWorld());
                    }
                }else{
                    sendPacket(PacketCrafter.craftMobPacket(mob, table.getDisguiseIdFor(mob.getType())), mob.getWorld());
                }
            }
        }
    }

    private void sendPacket(Packet packet, World world) {
        for(Player player : Bukkit.getOnlinePlayers()) {
            if(!player.getWorld().equals(world))
                continue;

            PlayerUtils.sendPacket(player, packet);
        }
    }
}
