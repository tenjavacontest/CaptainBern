package com.captainbern.inkhearth.wrappers;

import com.captainbern.inkhearth.utils.RandMan;
import org.bukkit.Location;

public class Packet55BlockBreakAnimation extends Packet {

    /**
     * A wrapper class for the Packet55BlockBreakAnimation.
     */
    public Packet55BlockBreakAnimation() {
        super("Packet55BlockBreakAnimation");
        setField("a", RandMan.nextInt());
    }

    /**
     * Sets the X, Y and Z location of the animation.
     * @param loc The location.
     */
    public void setLocation(Location loc) {
        setField("b", loc.getBlockX());
        setField("c", loc.getBlockY());
        setField("d", loc.getBlockZ());
    }

    /**
     * Sets the damage value of the animation.
     * @param damage The damage value. Needs to be between 0 and 7.
     */
    public void setDamage(int damage) {
        if(damage > 7 || damage < 0) {
            throw new UnsupportedOperationException("Damage needs to be between 0 and 7 !");
        }
        setField("e", damage);
    }
}
