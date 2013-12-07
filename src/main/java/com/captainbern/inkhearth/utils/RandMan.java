package com.captainbern.inkhearth.utils;

import java.util.Random;

public class RandMan {

    private static final Random random = new Random();

    public static int nextInt() {
        return random.nextInt();
    }
}
