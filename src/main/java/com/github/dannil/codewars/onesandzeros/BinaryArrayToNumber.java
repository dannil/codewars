package com.github.dannil.codewars.onesandzeros;

import java.util.List;
import java.util.stream.Collectors;

public class BinaryArrayToNumber {

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        String compounded = binary.stream().map(b -> b.toString()).collect(Collectors.joining());
        return Integer.parseInt(compounded, 2);
    }
}
