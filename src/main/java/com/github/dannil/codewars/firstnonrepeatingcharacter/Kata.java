package com.github.dannil.codewars.firstnonrepeatingcharacter;

import java.util.HashSet;
import java.util.Set;

public class Kata {
    public static String firstNonRepeatingLetter(String s) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            String toCheck = String.valueOf(s.charAt(i));
            String toCheckLowered = toCheck.toLowerCase();
            String remaining = s.substring(i + 1, s.length()).toLowerCase();
            if (!seen.contains(toCheckLowered) && !remaining.contains(toCheckLowered)) {
                return toCheck;
            }
            seen.add(toCheckLowered);
        }
        return "";
    }
}
