package com.company;

import java.security.SecureRandom;

public class Randoms {
    protected static final SecureRandom RANDOM = new SecureRandom();

    public static final char[] ALPHA = {'2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    protected static final int numMaxIndex = 8;
    protected static final int charMinIndex = numMaxIndex;
    protected static final int charMaxIndex = ALPHA.length;
    protected static final int upperMinIndex = charMinIndex;
    protected static final int upperMaxIndex = upperMinIndex + 23;
    protected static final int lowerMinIndex = upperMaxIndex;
    protected static final int lowerMaxIndex = charMaxIndex;

    public static int num(int min, int max) {
        return min + RANDOM.nextInt(max - min);
    }


    public static int num(int num) {
        return RANDOM.nextInt(num);
    }


    public static char alpha() {
        return ALPHA[num(ALPHA.length)];
    }


    public static char alpha(int num) {
        return ALPHA[num(num)];
    }


    public static char alpha(int min, int max) {
        return ALPHA[num(min, max)];
    }
}
