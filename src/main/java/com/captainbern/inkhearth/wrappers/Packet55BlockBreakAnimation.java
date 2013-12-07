package com.captainbern.inkhearth.wrappers;

import com.captainbern.inkhearth.utils.RandMan;
import org.bukkit.Location;

public class Packet55BlockBreakAnimation extends Packet {

    public Packet55BlockBreakAnimation() {
        super("Packet55BlockBreakAnimation");
        setField("a", RandMan.nextInt());
    }

    public void setLocation(Location loc) {
        setField("b", loc.getBlockX());
        setField("c", loc.getBlockY());
        setField("d", loc.getBlockZ());
    }

    public void setDamage(int damage) {
        if(damage > 7 || damage < 0) {
            throw new UnsupportedOperationException("Damage needs to be between 0 and 7 !");
        }
        setField("e", damage);
    }
}
