package com.captainbern.doge.netty;

import com.captainbern.doge.utils.PlayerUtils;
import org.bukkit.entity.Player;

public class PlayerInjector {

    public static void injectPlayer(Player player) {
        PlayerUtils.getChannel(player).pipeline().addAfter("encoder", "disguise_handler", new DogeHandler());
    }
}
