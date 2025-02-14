package com.github.dannil.codewars.detectpangram;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PangramChecker {
    public static boolean check(String sentence) {
        String lowercased = sentence.toLowerCase();
        String alpha = IntStream.range(0, lowercased.length())
                .filter(i -> Character.isLetter(lowercased.charAt(i)))
                .mapToObj(i -> String.valueOf(lowercased.charAt(i)))
                .collect(Collectors.joining());
        return alpha.chars().distinct().count() >= 26;
    }
}
