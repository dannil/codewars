package com.github.dannil.codewars.addingbignumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kata {

    public static String add(String a, String b) {
        int aLength = a.length() - 1;
        int bLength = b.length() - 1;
        int overflow = 0;
        List<Integer> digits = new ArrayList<>();

        while (aLength >= 0 || bLength >= 0 || overflow > 0) {
            int aDigit = 0;
            if (aLength >= 0) {
                char aChar = a.charAt(aLength);
                aDigit = Character.getNumericValue(aChar);
                aLength--;
            }
            int bDigit = 0;
            if (bLength >= 0) {
                char bChar = b.charAt(bLength);
                bDigit = Character.getNumericValue(bChar);
                bLength--;
            }

            int sum = aDigit + bDigit + overflow;
            overflow = sum / 10;
            int digit = sum % 10;
            digits.add(0, digit);
        }

        String number = digits.stream().map(String::valueOf).collect(Collectors.joining());
        // Our output can have leading zeros if a or b's most significant digit is a
        // zero so let's remove them
        return number.replaceFirst("^0+", "");
    }

}
