package com.github.dannil.codewars.stripcomments;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StripComments {

    public static String stripComments(String text, String[] commentSymbols) {
        String[] rows = text.split("\n");
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < commentSymbols.length; j++) {
                int index = rows[i].indexOf(commentSymbols[j]);
                if (index >= 0) {
                    rows[i] = rows[i].substring(0, index);
                }
            }
        }
        return Arrays.stream(rows).map(r -> r.stripTrailing()).collect(Collectors.joining("\n"));
    }

}
