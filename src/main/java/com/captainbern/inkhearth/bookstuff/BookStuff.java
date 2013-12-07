package com.captainbern.inkhearth.bookstuff;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;

public interface BookStuff {

    public void strike(World world, Location location);

    public void strike(Entity entity);

}
