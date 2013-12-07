package com.captainbern.doge.utils;

import java.util.Random;

public class RandMan {

    private static Random random = new Random();

    public static int nextInt() {
        return random.nextInt();
    }

    public static int nextInt(int bounds) {
        return random.nextInt(bounds);
    }
}
