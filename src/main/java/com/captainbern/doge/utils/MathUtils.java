package com.captainbern.doge.utils;

public class MathUtils {

    public static int floor(double d) {
        return (int) (d * 32.0D);
    }

    public static byte asCompressedAngle(float f) {
        return (byte) (f * 256.0F / 360.0F);
    }
}
