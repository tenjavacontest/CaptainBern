package com.captainbern.inkhearth.reflection;

import com.captainbern.inkhearth.InkHearth;
import org.bukkit.Bukkit;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtil {

    public static final String NMS_PATH = getNMSPath();

    /**
     * @return The path where the nms classes are located at.
     */
    public static String getNMSPath() {
        return "net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
    }

    /**
     * @param name Name of the class.
     * @return If there's a class with {@param name} than return that.
     */
    public static Class getClass(String name) {
        try {
            return Class.forName(name);
        } catch (ClassNotFoundException e) {
            InkHearth.LOGGER_REFLECTION.warning("Could not find class: " + name);
            return null;
        }
    }

    /**
     * @param className The name of the NMS class.
     * @return If there's an NMS class with {@param name} than return that class.
     */
    public static Class getNMSClass(String className) {
        return getClass(NMS_PATH + "." + className);
    }

    /**
     * Returns a Method.
     * @param clazz The class the method is located at.
     * @param methodName The name of the method.
     * @param params The params the method takes.
     * @return The method.
     */
    public static Method getMethod(Class clazz, String methodName, Class... params) {
        try {
            return clazz.getDeclaredMethod(methodName, params);
        } catch (NoSuchMethodException e) {
            InkHearth.LOGGER_REFLECTION.warning("Failed to find method: " + methodName + " in class: " + clazz.getSimpleName());
            return null;
        }
    }

    /**
     * Returns a field value.
     * @param clazz Class the field is located at.
     * @param fieldName Name of the field.
     * @param instance The instance of the class you want the field of.
     * @param <T> Generics type. So I don't need to cast etc.
     * @return The value of the field.
     */
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

    /**
     * Sets a field.
     * @param instance The instance of the class you're working with.
     * @param fieldName Name of the field.
     * @param value value to be set.
     */
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
