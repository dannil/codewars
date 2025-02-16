package com.github.dannil.codewars.josephuspermutation;

import java.util.ArrayList;
import java.util.List;

public class Josephus {

    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        List<T> linked = new ArrayList<>(items);
        List<T> circle = new ArrayList<>();

        int currentPosition = 0;
        while (!linked.isEmpty()) {
            currentPosition = (currentPosition + k - 1) % linked.size();
            T popped = linked.remove(currentPosition);
            circle.add(popped);
        }

        return circle;
    }

}
