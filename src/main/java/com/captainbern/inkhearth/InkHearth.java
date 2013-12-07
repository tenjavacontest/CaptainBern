package com.captainbern.inkhearth;

import com.captainbern.inkhearth.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class InkHearth extends JavaPlugin {

    public static final ModuleLogger LOGGER = new ModuleLogger("InkHearth");
    public static ModuleLogger LOGGER_REFLECTION = LOGGER.getModule("Reflection");

    private static InkHearth INSTANCE;

    public static ItemStack BOOK;

    /**
     * Like horses, but better.
     *
     * This a plugin for the ten.java plugin contest
     * All hail CaptainBern
     */

    @Override
    public void onDisable() {

    }

    @Override
    public void onEnable() {
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new PlayerListener(), this);

        registerRecipes();
        INSTANCE = this;
    }

    private void registerRecipes() {
        ItemStack inkbook = new ItemStack(Material.WRITTEN_BOOK);

        ItemMeta meta = inkbook.getItemMeta();
        meta.setDisplayName(ChatColor.ITALIC + "" + ChatColor.AQUA + "Book of Ink");
        meta.setLore(Arrays.asList(new String[]{ChatColor.GRAY + "A master piece"}));
        inkbook.setItemMeta(meta);

        ShapedRecipe bookOfInk = new ShapedRecipe(inkbook);

        bookOfInk.shape("DAD", "ABA", "DAD");

        bookOfInk.setIngredient('A', Material.IRON_BLOCK);
        bookOfInk.setIngredient('D', Material.DIAMOND_BLOCK);
        bookOfInk.setIngredient('B', Material.BOOK_AND_QUILL);

        Bukkit.getServer().addRecipe(bookOfInk);
        BOOK = inkbook;
    }

    public static InkHearth getInstance() {
        if(INSTANCE == null) {
            LOGGER.warning("Plugin is disabled!");
            return null;
        }
        return INSTANCE;
    }
}
