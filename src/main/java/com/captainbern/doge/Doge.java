package com.captainbern.doge;

import com.captainbern.doge.listener.PlayerListener;
import com.captainbern.doge.logger.ModuleLogger;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class Doge extends JavaPlugin {

    public static final ModuleLogger LOGGER = new ModuleLogger("DogeDisguise");
    public static final ModuleLogger LOGGER_REFLECTION = LOGGER.getModule("Reflection");

    private static Doge INSTANCE;

    public static boolean DO_RANDOM;
    public static boolean USE_NAMES;
    public static EntityTable TABLE;
    public static List<String> NAMES;

    @Override
    public void onDisable() {

    }

    @Override
    public void onEnable() {
        saveDefaultConfig();

        DO_RANDOM = getConfig().getBoolean("doRandom");
        USE_NAMES = getConfig().getBoolean("useNames");

        if(!DO_RANDOM) {
            TABLE = new EntityTable(getConfig().getStringList("disguiseTable"));
        }

        if(USE_NAMES) {
            NAMES = getConfig().getStringList("names");
        }

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PlayerListener(), this);

        INSTANCE = this;

        checkEntities();
    }

    public static Doge getInstance() {
        if(INSTANCE == null) {
            LOGGER.warning("Plugin not enabled!");
        }
        return INSTANCE;
    }

    private void checkEntities() {
        for(World world : Bukkit.getWorlds()) {
            for(Entity entity : world.getEntities()) {
                PlayerListener.disguiseMob(entity);
            }
        }
    }
}
