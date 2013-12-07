package com.captainbern.inkhearth.bookstuff;

import com.captainbern.inkhearth.utils.RandMan;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ocelot;

public class MbaxterStuff implements BookStuff {

    @Override
    public void strike(World world, Location location) {
        Ocelot ocelot = (Ocelot) world.spawnEntity(location, EntityType.OCELOT);
        ocelot.setCatType(Ocelot.Type.RED_CAT);
        ocelot.setSitting(RandMan.nextBoolean());
    }

    @Override
    public void strike(Entity entity) {
        strike(entity.getWorld(), entity.getLocation());
    }
}
