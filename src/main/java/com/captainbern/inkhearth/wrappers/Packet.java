package com.captainbern.inkhearth.wrappers;

import com.captainbern.inkhearth.reflection.ReflectionUtil;

public class Packet extends BasicWrapper{

    /**
     * A basic Packet wrapper, makes it easier for me to create
     * other packet wrappers :)
     */

    /**
     * Constructs a new packet wrapper.
     * @param packetName
     */
    public Packet(String packetName) {
       super(ReflectionUtil.getNMSClass(packetName));
    }

    /**
     * Sets a field value in the given packet class.
     * @param field The field name.
     * @param value The value to be set.
     */
    public void setField(String field, Object value) {
        ReflectionUtil.setField(getHandle(), field, value);
    }
}
