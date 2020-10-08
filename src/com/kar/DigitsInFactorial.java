package com.kar;

import static java.lang.Math.log10;

public class DigitsInFactorial {

    public static void main(String[] args) {
        int N = 42;
        System.out.println(digitsInFactorial(N));
    }

    public static int digitsInFactorial(int N) {
        double count = 1;

        for (int i = 1; i <= N; i++)
            count += log10(i);

        return (int) count;
    }
}
