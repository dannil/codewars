package com.github.dannil.codewars.consecutivestrings;

class LongestConsec {

    public static String longestConsec(String[] strarr, int k) {
        String longest = "";
        if (k > strarr.length) {
            return longest;
        }
        for (int i = 0; i < strarr.length; i++) {
            String concat = "";
            for (int j = i; j < Math.min(k + i, strarr.length); j++) {
                concat += strarr[j];
            }
            if (concat.length() > longest.length()) {
                longest = concat;
            }
        }
        return longest;
    }

}
