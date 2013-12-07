package com.captainbern.inkhearth.utils;

import com.captainbern.inkhearth.InkHearth;
import org.bukkit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocationUtils {

    private static List<Color> colors = Arrays.asList(new Color[]{Color.AQUA, Color.BLACK, Color.BLUE, Color.FUCHSIA, Color.GRAY, Color.GREEN, Color.LIME, Color.MAROON, Color.NAVY, Color.OLIVE, Color.ORANGE, Color.PURPLE, Color.RED, Color.SILVER, Color.TEAL, Color.WHITE, Color.YELLOW});
    public static final FireworkEffectPlayer FIREWORK_EFFECT_PLAYER = new FireworkEffectPlayer();

    public static void createRandomFireWorks(World world, Location loc) {
        FireworkEffect effect = FireworkEffect.builder().with(FireworkEffect.Type.BALL_LARGE).withColor(colors.get(RandMan.nextInt(17))).build();
        try {
            FIREWORK_EFFECT_PLAYER.playFirework(world, loc, effect);
        } catch (Exception e) {
            InkHearth.LOGGER.warning("Failed to play firework effect!");
        }
    }

    /**
     * @param centerLoc - Central Location
     * @param radius - Distance in blocks from the "centerLoc"
     * @return Circle
     * @note - it will return only the blocks that are in the "radius" position.
     */
    public static List<Location> getCircle(Location centerLoc, int radius){
        List<Location> circle = new ArrayList<Location>();
        World world = centerLoc.getWorld();
        int x = 0;
        int z = radius;
        int error = 0;
        int d = 2 - 2 * radius;
        while (z >= 0) {
            circle.add(new Location(world, centerLoc.getBlockX() + x, centerLoc.getY(), centerLoc.getBlockZ() + z));
            circle.add(new Location(world, centerLoc.getBlockX() - x, centerLoc.getY(), centerLoc.getBlockZ() + z));
            circle.add(new Location(world, centerLoc.getBlockX() - x, centerLoc.getY(), centerLoc.getBlockZ() - z));
            circle.add(new Location(world, centerLoc.getBlockX() + x, centerLoc.getY(), centerLoc.getBlockZ() - z));
            error = 2 * (d + z) - 1;
            if ((d < 0) && (error <= 0)) {
                x++;
                d += 2 * x + 1;
            }
            else {
                error = 2 * (d - x) - 1;
                if ((d > 0) && (error > 0)) {
                    z--;
                    d += 1 - 2 * z;
                }
                else {
                    x++;
                    d += 2 * (x - z);
                    z--;
                }
            }
        }
        return circle;
    }

}
