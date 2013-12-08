package com.captainbern.doge.wrappers;

import com.captainbern.doge.Doge;
import com.captainbern.doge.reflection.ReflectionUtil;

public class BasicWrapper {

    protected Object handle;

    public BasicWrapper() {}

    public BasicWrapper(String className) {
        try {
            setHandle(ReflectionUtil.getNMSClass(className).newInstance());
        } catch (Exception e) {
            Doge.LOGGER_REFLECTION.warning("Could not set handle!");
            e.printStackTrace();
        }
    }

    protected void setHandle(Object handle) {
        if(handle == null) {
            throw new UnsupportedOperationException("Cannot set handle to null!");
        }
        this.handle = handle;
    }

    public Object getHandle() {
        return this.handle;
    }
}
