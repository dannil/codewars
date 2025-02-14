package com.github.dannil.codewars.doesmynumberlookbiginthis;

import java.util.stream.IntStream;

public class NumberUtils {

    public static boolean isNarcissistic(int number) {
        int[] digits = String.valueOf(number).chars().map(Character::getNumericValue).toArray();
        int sum = IntStream.range(0, digits.length).map(i -> (int) Math.pow(digits[i], digits.length)).sum();
        return sum == number;
    }

}
