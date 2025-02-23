package com.github.dannil.codewars.isthisatriangle;

public class TriangleTester {

    public static boolean isTriangle(int a, int b, int c) {
        // Triangle inequality
        return a + b > c && a + c > b && b + c > a;
    }

}
