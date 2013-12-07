package com.captainbern.inkhearth.wrappers;

import com.captainbern.inkhearth.InkHearth;

public class BasicWrapper {

    protected Object handle;

    /**
     * Creates a new wrapper for the given class.
     * @param clazz The class you want to create a wrapper of.
     */
    public BasicWrapper(Class clazz) {
        try {
            setHandle(clazz.newInstance());
        } catch (InstantiationException e) {
            InkHearth.LOGGER_REFLECTION.warning("Failed to instantiate Class!");
        } catch (IllegalAccessException e) {
            InkHearth.LOGGER_REFLECTION.warning("Failed to access Class!");
        }
    }

    /**
     * Sets the handle of the wrapper.
     * @param handle The instance of the handle class.
     */
    protected void setHandle(Object handle) {
        if(handle == null) {
            throw new UnsupportedOperationException("Cannot set handle to null!");
        }
        this.handle = handle;
    }

    /**
     * returns the handle.
     * @return The instance of the handle.
     */
    public Object getHandle() {
        return handle;
    }
}
