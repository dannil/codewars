package com.github.dannil.codewars.mumbling;

public class Accumul {

    public static String accum(String s) {
        String lowered = s.toLowerCase();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lowered.length(); i++) {
            char c = lowered.charAt(i);
            builder.append(Character.toUpperCase(c));
            for (int j = 0; j < i; j++) {
                builder.append(c);
            }
            if (i != lowered.length() - 1) {
                builder.append("-");
            }
        }
        return builder.toString();
    }

}
