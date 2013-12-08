package com.captainbern.doge.listener;

import com.captainbern.doge.Doge;
import com.captainbern.doge.netty.PlayerInjector;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Arrays;
import java.util.List;

public class PlayerListener implements Listener {

    private static final List<EntityType> entities = Arrays.asList(EntityType.values());

    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Doge.getInstance(), new Runnable() {
            @Override
            public void run() {
                PlayerInjector.injectPlayer(event.getPlayer());
            }
        }, 5L);
    }
}
