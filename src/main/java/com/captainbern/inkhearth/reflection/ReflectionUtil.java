package com.captainbern.inkhearth.reflection;

import com.captainbern.inkhearth.InkHearth;
import org.bukkit.Bukkit;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtil {

    public static final String NMS_PATH = getNMSPath();

    public static String getNMSPath() {
        return "net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
    }

    public static Class getClass(String name) {
        try {
            return Class.forName(name);
        } catch (ClassNotFoundException e) {
            InkHearth.LOGGER_REFLECTION.warning("Could not find class: " + name);
            return null;
        }
    }

    public static Class getNMSClass(String className) {
        return getClass(NMS_PATH + "." + className);
    }

    public static Method getMethod(Class clazz, String methodName, Class... params) {
        try {
            return clazz.getDeclaredMethod(methodName, params);
        } catch (NoSuchMethodException e) {
            InkHearth.LOGGER_REFLECTION.warning("Failed to find method: " + methodName + " in class: " + clazz.getSimpleName());
            return null;
        }
    }

    public static <T> T getField(Class<?> clazz, String fieldName, Object instance) {
        try {
            Field field = clazz.getDeclaredField(fieldName);

            if(!field.isAccessible()) {
                field.setAccessible(true);
            }

            return (T) clazz.getDeclaredField(fieldName).get(instance);
        } catch (IllegalAccessException e) {
            InkHearth.LOGGER_REFLECTION.warning("Failed to access field: " + fieldName);
            return null;
        } catch (NoSuchFieldException e) {
            InkHearth.LOGGER_REFLECTION.warning("Field: " + fieldName + " could not be found!");
            return null;
        }
    }

    public static void setField(Object instance, String fieldName, Object value) {
        try {
            Field field = instance.getClass().getDeclaredField(fieldName);

            if(!field.isAccessible()) {
                field.setAccessible(true);
            }

            field.set(instance, value);
        } catch (Exception e) {
            InkHearth.LOGGER_REFLECTION.warning("Could not set field!");
        }
    }
}
