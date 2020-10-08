package com.kar;

import java.util.Arrays;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        int n = 23;
        //printPrimesTillNumber(n);
        usingEratosthenesAlgorithm(n);
    }

    // Naive solution - O(n*sqrt(n))
    private static void printPrimesTillNumber(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime(i))
                System.out.println(i);
        }
    }

    // O(n*log(log(n)))
    private static void usingEratosthenesAlgorithm(int n){
        boolean[] primeChecker = new boolean[n+1];
        Arrays.fill(primeChecker, true);

        for(int i=2; i*i<n; i++)
            // if the current index is true, mark all its multiples as false
            if(primeChecker[i])
                for(int j=2*i; j<=n; j=j+i)
                    primeChecker[j] = false;

        for(int i=2; i<=n; i++)
            if(primeChecker[i])
                System.out.println(i);
    }

    private static boolean isPrime(int n) {
        if (n == 1)
            return false;

        if (n == 2 || n == 3)
            return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 2; i * i <= n; i = i + 6)
            if (n % i == 0)
                return false;

        return true;
    }
}
