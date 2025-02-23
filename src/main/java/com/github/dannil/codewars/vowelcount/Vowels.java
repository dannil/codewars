package com.github.dannil.codewars.vowelcount;

import java.util.List;

public class Vowels {

    public static int getCount(String str) {
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        return (int) str.chars().mapToObj(c -> (char) c).filter(c -> vowels.contains(c)).count();
    }

}
