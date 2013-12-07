package com.captainbern.inkhearth.listeners;

import com.captainbern.inkhearth.InkHearth;
import com.captainbern.inkhearth.utils.LocationUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if(player.getItemInHand().equals(InkHearth.BOOK)) {
            event.setCancelled(true);

            for(int i = 0; i < 15; i++) {
                LocationUtils.createRandomFireWorks(player.getWorld(), player.getEyeLocation());
            }
        }
    }
}
