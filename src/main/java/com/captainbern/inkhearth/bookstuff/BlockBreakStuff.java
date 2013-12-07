package com.captainbern.inkhearth.bookstuff;

import com.captainbern.inkhearth.utils.BlockUtils;
import com.captainbern.inkhearth.utils.LocationUtils;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;

import java.util.List;

public class BlockBreakStuff implements BookStuff {
    @Override
    public void strike(World world, Location location) {
        for(Location loc : getBlockFloor(location, 10)) {
            //if(!RandMan.nextBoolean()) {
                BlockUtils.setCracking(world.getBlockAt(loc), 7);
            //}
        }
    }

    @Override
    public void strike(Entity entity) {
        strike(entity.getWorld(), entity.getLocation());
    }

    private List<Location> getBlockFloor(Location sourceBlock, int spread) {
        return LocationUtils.getCuboid(sourceBlock.add(spread, spread, spread), sourceBlock.subtract(spread, spread, spread), true);
    }
}
