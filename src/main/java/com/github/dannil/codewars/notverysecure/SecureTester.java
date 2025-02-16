package com.github.dannil.codewars.notverysecure;

public class SecureTester {

    public static boolean alphanumeric(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        return s.chars().allMatch(c -> (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'));
    }

}
