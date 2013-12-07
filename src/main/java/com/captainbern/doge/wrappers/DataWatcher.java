package com.captainbern.doge.wrappers;

import com.captainbern.doge.reflection.ReflectionUtil;

public class DataWatcher extends BasicWrapper {

    public DataWatcher() {
        super("DataWatcher");
    }

    public void write(int i, Object object){
        ReflectionUtil.invokeMethod(ReflectionUtil.getMethod(getHandle().getClass(), "a", int.class, Object.class), getHandle(), i, object);
    }
}
