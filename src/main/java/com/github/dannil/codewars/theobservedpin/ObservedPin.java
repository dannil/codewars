package com.github.dannil.codewars.theobservedpin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ObservedPin {

    private static int[][] keypad = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
    };

    public static List<String> getPINs(String observed) {
        int[] digits = observed.chars().map(Character::getNumericValue).toArray();
        Map<Integer, Set<Integer>> positions = new HashMap<>();
        for (int i = 0; i < digits.length; i++) {
            int current = digits[i];
            Set<Integer> adjacent = getAdjacentDigits(current);
            positions.put(i, adjacent);
        }

        List<List<Integer>> combinations = new ArrayList<>();
        combinations.add(new ArrayList<>());

        List<Map.Entry<Integer, Set<Integer>>> entries = new ArrayList<>(positions.entrySet());
        entries.sort(Map.Entry.comparingByKey());

        for (Map.Entry<Integer, Set<Integer>> entry : entries) {
            Set<Integer> value = entry.getValue();
            List<List<Integer>> newCombinations = new ArrayList<>();

            for (List<Integer> combination : combinations) {
                for (Integer digit : value) {
                    List<Integer> newCombination = new ArrayList<>(combination);
                    newCombination.add(digit);
                    newCombinations.add(newCombination);
                }
            }

            combinations = newCombinations;
        }

        // Must be a mutable list as it's sorted in place before the tests are run
        return combinations.stream().map(c -> c.stream().map(d -> d.toString()).collect(Collectors.joining()))
                .collect(Collectors.toList());
    }

    public static Set<Integer> getAdjacentDigits(int digit) {
        Set<Integer> possibilities = new HashSet<>();
        possibilities.add(digit);

        // Special cases: handle missing 0 in keypad, as it makes
        // the solution much simpler having the same dimensions on
        // the X and Y axis
        if (digit == 0) {
            possibilities.add(8);
            return possibilities;
        } else if (digit == 8) {
            possibilities.add(0);
        }

        int row = (digit - 1) / 3;
        int col = (digit - 1) % 3;

        // Up
        if (row > 0)
            possibilities.add(keypad[row - 1][col]);
        // Right
        if (col < keypad.length - 1)
            possibilities.add(keypad[row][col + 1]);
        // Down
        if (row < keypad.length - 1)
            possibilities.add(keypad[row + 1][col]);
        // Left
        if (col > 0)
            possibilities.add(keypad[row][col - 1]);

        return possibilities;
    }

}
