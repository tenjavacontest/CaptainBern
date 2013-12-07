package com.captainbern.doge.utils;

import com.captainbern.doge.reflection.ReflectionUtil;
import org.bukkit.entity.Entity;

public class EntityUtil {

    public static Object getHandle(Entity entity) {
        return ReflectionUtil.invokeMethod(ReflectionUtil.getMethod(entity.getClass(), "getHandle"), entity);
    }

    public static float getAp(Entity entity) {
        return ReflectionUtil.getField(ReflectionUtil.getNMSClass("LivingEntity"), "aP", getHandle(entity));
    }
}
