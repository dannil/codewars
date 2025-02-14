package com.github.dannil.codewars.playingwithdigits;

import java.util.stream.IntStream;

public class DigPow {

    public static long digPow(int n, int p) {
        int[] digits = String.valueOf(n).chars().map(Character::getNumericValue).toArray();
        int powed = IntStream.range(0, digits.length)
            .map(i -> (int) Math.pow(digits[i], i + p))
            .sum();
        double div = (double) Math.max(powed, n) / Math.min(powed, n);
        return div == Math.rint(div) ? (long) div : -1;
    }

}
