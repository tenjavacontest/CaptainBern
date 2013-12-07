package com.captainbern.inkhearth.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class StringUtil {

    private final static String EMPTY = "";

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

    public static String join(Collection collection, String separator) {
        if (collection == null) {
            return null;
        }
        return join(collection.iterator(), separator);
    }

    public static String join(Object[] array, String seperator){
        if(array == null){
            return null;
        }
        return join(Arrays.asList(array), seperator);
    }
}
