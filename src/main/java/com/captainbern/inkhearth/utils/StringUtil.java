package com.captainbern.inkhearth.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class StringUtil {

    private final static String EMPTY = "";

    /**
     * Appends all contents of the iterator to each other with given separator.
     * @param iterator The iterator.
     * @param separator The separator
     * @return A string which contains all the contents of the iterator separated by the {@param separator}
     */
    public static String join(Iterator iterator, String separator) {
        if (iterator == null) {
            return null;
        }
        if (!iterator.hasNext()) {
            return EMPTY;
        }
        Object first = iterator.next();
        if (!iterator.hasNext()) {
            return LogicUtil.toString(first);
        }

        StringBuilder buf = new StringBuilder(256);
        if (first != null) {
            buf.append(first);
        }

        while (iterator.hasNext()) {
            if (separator != null) {
                buf.append(separator);
            }
            Object obj = iterator.next();
            if (obj != null) {
                buf.append(obj);
            }
        }
        return buf.toString();
    }

    /**
     * "Converts" Collection to iterator.
     * @param collection The collection you want to join.
     * @param separator The separator you want to use.
     * @return A string which contains all contents of the collection separated by the {@param separator}
     */
    public static String join(Collection collection, String separator) {
        if (collection == null) {
            return null;
        }
        return join(collection.iterator(), separator);
    }

    /**
     * Joins the contents of the array with given separator
     */
    public static String join(Object[] array, String separator){
        if(array == null){
            return null;
        }
        return join(Arrays.asList(array), separator);
    }
}
