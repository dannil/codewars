package com.github.dannil.codewars.countingduplicates;

import java.util.HashMap;
import java.util.Map;

public class CountingDuplicates {

    public static int duplicateCount(String text) {
        Map<Character, Integer> occurances = new HashMap<>();
        for (char c : text.toCharArray()) {
            char lowercased = Character.toLowerCase(c);
            occurances.compute(lowercased, (k, v) -> v == null ? 1 : v + 1);
        }
        return (int) occurances.values().stream().filter(v -> v >= 2).count();
    }

}
