package com.github.dannil.codewars.findtheuniquenumber;

import java.util.HashMap;
import java.util.Map;

// Make sure your class is public
public class Kata {
    public static double findUniq(double arr[]) {
        Map<Double, Integer> occurrences = new HashMap<>();
        for (double e : arr) {
            occurrences.put(e, occurrences.getOrDefault(e, 0) + 1);
        }
        return occurrences.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                .get()
                .getKey();
    }
}
