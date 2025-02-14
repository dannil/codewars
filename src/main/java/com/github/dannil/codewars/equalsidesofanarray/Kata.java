package com.github.dannil.codewars.equalsidesofanarray;

import java.util.Arrays;

public class Kata {
    public static int findEvenIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int left = Arrays.stream(arr, 0, i).sum();
            int right = Arrays.stream(arr, i + 1, arr.length).sum();
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
}
