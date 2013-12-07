package com.captainbern.doge;

import com.captainbern.doge.logger.ModuleLogger;
import org.bukkit.plugin.java.JavaPlugin;

public class Doge extends JavaPlugin {

    public static final ModuleLogger LOGGER = new ModuleLogger("DogeDisguise");
    public static final ModuleLogger LOGGER_REFLECTION = LOGGER.getModule("Reflection");

    @Override
    public void onDisable() {

    }

    @Override
    public void onEnable() {

    }

}
