package com.captainbern.doge;

import com.captainbern.doge.listener.PlayerListener;
import com.captainbern.doge.logger.ModuleLogger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Doge extends JavaPlugin {

    public static final ModuleLogger LOGGER = new ModuleLogger("DogeDisguise");
    public static final ModuleLogger LOGGER_REFLECTION = LOGGER.getModule("Reflection");

    public static boolean DO_RANDOM;
    public static EntityTable TABLE;

    @Override
    public void onDisable() {

    }

    @Override
    public void onEnable() {
        saveDefaultConfig();

        DO_RANDOM = getConfig().getBoolean("doRandom");

        if(!DO_RANDOM) {
            TABLE = new EntityTable(getConfig().getStringList("disguiseTable"));
        }

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PlayerListener(), this);
    }
}
