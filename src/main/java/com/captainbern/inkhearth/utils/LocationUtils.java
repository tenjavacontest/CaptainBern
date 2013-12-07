package com.captainbern.inkhearth.utils;

import com.captainbern.inkhearth.InkHearth;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

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

    public static List<Location> getCuboid(Location position1, Location position2, boolean noAir){

        if(position1.getWorld().getName() != position2.getWorld().getName()){
            throw new UnsupportedOperationException("'Position1' and 'Position2' location need to be in the same world!");
        }

        List<Location> cube = new ArrayList<Location>();

        int minX = (int) Math.min(position1.getX(), position2.getX());
        int maxX = (int) Math.max(position1.getX(), position2.getX());

        int minY = (int) Math.min(position1.getY(), position2.getY());
        int maxY = (int) Math.max(position1.getY(), position2.getY());

        int minZ = (int) Math.min(position1.getZ(), position2.getZ());
        int maxZ = (int) Math.max(position1.getZ(), position2.getZ());

        for(int x = minX; x <= maxX; x++){
            for(int y = minY; y <= maxY; y++){
                for(int z = minZ; z <= maxZ; z++){
                    if(noAir) {
                        if(!position1.getWorld().getBlockAt(x, y, z).getType().equals(Material.AIR)) {
                            cube.add(new Location(position1.getWorld(), x, y, z));
                        }
                    }else{
                        cube.add(new Location(position1.getWorld(), x, y, z));
                    }
                }
            }
        }
        return cube;
    }

}
