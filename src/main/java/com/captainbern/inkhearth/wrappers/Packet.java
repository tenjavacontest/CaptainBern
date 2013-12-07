package com.captainbern.inkhearth.wrappers;

import com.captainbern.inkhearth.reflection.ReflectionUtil;

public class Packet extends BasicWrapper{

    /**
     * A basic Packet wrapper, makes it easier for me to create
     * other packet wrappers :)
     */

    public Packet(String packetName) {
       super(ReflectionUtil.getNMSClass(packetName));
    }

    public void setField(String field, Object value) {
        ReflectionUtil.setField(getHandle(), field, value);
    }
}
