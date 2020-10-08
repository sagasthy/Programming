package com.kar;

public class CountPrimeFactors {
    public static void main(String[] args) {
        //int n = 12;
        int n = 13;
        //printPrimeFactors(n);
        printPrimeFactorsv2(n);
    }

    // Naive Solution - O(n^2 log n)
    private static void printPrimeFactors(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                int x = i;
                while (n % x == 0) {
                    System.out.println(i);
                    x = x * i;
                }
            }
        }
    }

    // Based on the same principle as prime number, keep dividing the given number until divisible
    // and keep increasing the divisor after division is not possible. Perform this for numbers
    // until the square root of the given number.
    // O(sqrt(n))
    private static void printPrimeFactorsv2(int n) {
        if(n<=1)
            return;

        for (int i = 2; i*i <= n; i++) {
            while (n % i == 0) {
                System.out.println(i);
                n /= i;
            }
        }

        if(n>1)
            System.out.println(n);
    }

    private static boolean isPrime(int n) {
        if (n == 1)
            return false;

        for (int i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;

        return true;
    }
}
