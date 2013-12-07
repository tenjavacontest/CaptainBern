package com.captainbern.inkhearth;

import com.captainbern.inkhearth.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.BookMeta;
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

        BookMeta meta = (BookMeta) inkbook.getItemMeta();
        meta.setDisplayName(ChatColor.ITALIC + "" + ChatColor.AQUA + "Book of Ink");
        meta.setLore(Arrays.asList(new String[]{ChatColor.GRAY + "InkHearth"}));

        meta.setAuthor("Cornelia Funke");
        meta.setTitle("InkHearth");
        meta.addPage(new String[]{ChatColor.BOLD + "Chapter 1", ChatColor.BOLD + "A Stranger in the night", "The moon shone in the rocking horse's eye, and in the mouse's eye, too, when Tolly fetched it out from under his pillow to see. The clock went tick-tock, and in the stillness he thought he heard little bare feet running across the floor,"});
        meta.addPage(new String[]{"then laughter and whispering, and a sound like the pages of a big book being turned over."});

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
