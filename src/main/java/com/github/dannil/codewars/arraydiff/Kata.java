package com.github.dannil.codewars.arraydiff;

import java.util.Arrays;
import java.util.List;

public class Kata {

    public static int[] arrayDiff(int[] a, int[] b) {
        List<Integer> al = Arrays.stream(a).boxed().toList();
        List<Integer> bl = Arrays.stream(b).boxed().toList();
        List<Integer> difference = al.stream().filter(e -> !bl.contains(e)).toList();
        return difference.stream().mapToInt(Integer::intValue).toArray();
    }

}
