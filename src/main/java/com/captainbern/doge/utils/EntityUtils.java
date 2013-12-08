package com.captainbern.doge.utils;

import com.captainbern.doge.reflection.ReflectionUtil;
import org.bukkit.entity.Entity;

public class EntityUtils {

    public static Object getHandle(Entity entity) {
        return ReflectionUtil.invokeMethod(ReflectionUtil.getMethod(entity.getClass(), "getHandle"), entity);
    }

}
