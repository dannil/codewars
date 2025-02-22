package com.github.dannil.codewars.tribonaccisequence;

import java.util.ArrayList;
import java.util.List;

public class Xbonacci {

    public double[] tribonacci(double[] s, int n) {
        if (n == 0) {
            return new double[0];
        }
        List<Double> elements = new ArrayList<>(List.of(s[0], s[1], s[2]));
        for (int i = 0; i < n; i++) {
            double sum = elements.get(i) + elements.get(i + 1) + elements.get(i + 2);
            elements.add(sum);
        }
        return elements.stream().limit(n).mapToDouble(Double::doubleValue).toArray();
    }

}
