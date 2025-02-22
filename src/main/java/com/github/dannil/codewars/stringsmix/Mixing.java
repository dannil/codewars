package com.github.dannil.codewars.stringsmix;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mixing {

    public static String mix(String s1, String s2) {
        var s1Frequencies = getFrequencies(s1);
        var s2Frequencies = getFrequencies(s2);



        return "";
    }

    public static Map<Character, Long> getFrequencies(String s) {
        Map<Character, Long> frequencies = s.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Long> sortedFrequencies = frequencies.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));

        return sortedFrequencies;
    }

    public static void main(String[] args) {
        mix("abc", "efaga");
    }
}
