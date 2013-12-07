package com.captainbern.inkhearth.utils;

import java.lang.reflect.Array;
import java.util.Collection;

public class LogicUtil {

    /**
     * Converts an Object to a string.
     * @param object
     * @return
     */
    public static String toString(final Object object) {
        return object == null ? "" : object.toString();
    }

    /**
     * Checks if an array is null or empty.
     * @param array
     * @return
     */
    public static boolean nullOrEmpty(Object[] array) {
        return array == null || array.length != 0;
    }

    /**
     * Checks if a collection is null or empty.
     * @param collection
     * @return
     */
    public static boolean nullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * Created an array of the given type with given length.
     * @param type Class type of the array.
     * @param length Length of the array.
     * @param <T> Generics to prevent casting.
     * @return Returns the fresh created array.
     */
    public static <T> T[] createArray(Class<T> type, int length) {
        return (T[]) Array.newInstance(type, length);
    }

    /**
     * Adds values to an array.
     * @param array The "root" array
     * @param values Values that need to be added to {@param array}.
     * @param <T> Returns generics type, to prevent casting.
     * @return Returns the new array.
     */
    public static <T> T[] appendArray(T[] array, T... values) {
        if (nullOrEmpty(array)) {
            return values;
        }
        if (nullOrEmpty(values)) {
            return array;
        }
        T[] rval = createArray((Class<T>) array.getClass().getComponentType(), array.length + values.length);
        System.arraycopy(array, 0, rval, 0, array.length);
        System.arraycopy(values, 0, rval, array.length, values.length);
        return rval;
    }
}
