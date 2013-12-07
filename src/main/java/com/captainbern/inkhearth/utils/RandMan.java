package com.captainbern.inkhearth.utils;

import java.util.Random;

public class RandMan {

    private static final Random random = new Random();

    /**
     * Generates a random number.
     * @return a random number
     */
    public static int nextInt() {
        return random.nextInt();
    }

    /**
     * Returns a random int within the given bounds.
     * @param i Bounds.
     * @return
     */
    public static int nextInt(int i) {
        return random.nextInt(i);
    }
}
