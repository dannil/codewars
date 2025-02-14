package com.github.dannil.codewars.createphonenumber;

import java.util.Arrays;

public class Kata {
    public static String createPhoneNumber(int[] numbers) {
        int[] begin = Arrays.stream(numbers, 0, 3).toArray();
        int[] middle = Arrays.stream(numbers, 3, 6).toArray();
        int[] end = Arrays.stream(numbers, 6, 10).toArray();

        StringBuilder builder = new StringBuilder();
        builder.append("(");
        for (int i = 0; i < begin.length; i++) {
            builder.append(String.valueOf(begin[i]));
        }
        builder.append(")");
        builder.append(" ");
        for (int i = 0; i < middle.length; i++) {
            builder.append(String.valueOf(middle[i]));
        }
        builder.append("-");
        for (int i = 0; i < end.length; i++) {
            builder.append(String.valueOf(end[i]));
        }
        return builder.toString();
    }
}
