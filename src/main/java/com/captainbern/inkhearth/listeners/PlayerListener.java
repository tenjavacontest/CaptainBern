package com.captainbern.inkhearth.listeners;

import com.captainbern.inkhearth.InkHearth;
import com.captainbern.inkhearth.bookstuff.BookStuff;
import com.captainbern.inkhearth.bookstuff.MbaxterStuff;
import com.captainbern.inkhearth.utils.BlockUtils;
import com.captainbern.inkhearth.utils.LocationUtils;
import com.captainbern.inkhearth.utils.RandMan;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener {

    private BookStuff[] stuffs = new BookStuff[]{new MbaxterStuff()};

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if(player.getItemInHand().equals(InkHearth.BOOK)) {
            event.setCancelled(true);

            for(int i = 0; i < 15; i++) {
                LocationUtils.createRandomFireWorks(player.getWorld(), player.getEyeLocation());
            }

            BlockUtils.setCracking(player.getTargetBlock(null, 0), 7);

            stuffs[RandMan.nextInt(stuffs.length)].strike(player);

        }
    }
}
