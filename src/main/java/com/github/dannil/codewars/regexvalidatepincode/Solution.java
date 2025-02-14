package com.github.dannil.codewars.regexvalidatepincode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static boolean validatePin(String pin) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(pin);
        if (!matcher.find()) {
            return false;
        }
        String group = matcher.group();
        if (group.length() != pin.length()) {
            return false;
        }
        return group.length() == 4 || group.length() == 6;
    }

}
