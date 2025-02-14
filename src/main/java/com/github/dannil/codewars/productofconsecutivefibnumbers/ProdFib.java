package com.github.dannil.codewars.productofconsecutivefibnumbers;

public class ProdFib { // must be public for codewars

    public static long[] productFib(long prod) {
        long fib1 = 1;
        long fib2 = 1;
        while (fib1 * fib2 < prod) {
            long fibSum = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibSum;
        }
        return new long[] { fib1, fib2, (fib1 * fib2 == prod) ? 1 : 0 };
    }
}
