package com.captainbern.doge.wrappers.protocol;

import com.captainbern.doge.reflection.ReflectionUtil;
import com.captainbern.doge.wrappers.BasicWrapper;

public class Packet extends BasicWrapper {

    public Packet(String packetName) {
        super(packetName);
    }

    public void setField(String fieldName, Object value) {
        ReflectionUtil.setField(getHandle().getClass(), fieldName, getHandle(), value);
    }
}
