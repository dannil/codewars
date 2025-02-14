package com.github.dannil.codewars.listfiltering;

import java.util.List;

public class Kata {

    public static List<Object> filterList(final List<Object> list) {
        return list.stream().filter(e -> e instanceof Integer).toList();
    }
}
