package com.captainbern.inkhearth.wrappers;

import com.captainbern.inkhearth.InkHearth;

public class BasicWrapper {

    protected Object handle;

    public BasicWrapper(Class clazz) {
        try {
            setHandle(clazz.newInstance());
        } catch (InstantiationException e) {
            InkHearth.LOGGER_REFLECTION.warning("Failed to instantiate Class!");
        } catch (IllegalAccessException e) {
            InkHearth.LOGGER_REFLECTION.warning("Failed to access Class!");
        }
    }

    protected void setHandle(Object handle) {
        if(handle == null) {
            throw new UnsupportedOperationException("Cannot set handle to null!");
        }
        this.handle = handle;
    }

    public Object getHandle() {
        return handle;
    }
}
