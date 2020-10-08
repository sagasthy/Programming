package com.kar;

public class CountDivisors {
    public static void main(String[] args) {
        int n = 25;
        printDivisorsv3(n);
    }

    // Naive solution - O(n)
    private static void printDivisors(int n) {
        for(int i=1; i<=n; i++)
            if(n%i==0)
                System.out.println(i);
    }

    // Efficient solution - O(sqrt(n))
    // Based on the principle - divisors always appear in pairs
    private static void printDivisorsv2(int n){
        for(int i=1; i*i<=n; i++) {
            if (n % i == 0) {
                System.out.println(i);
                int otherDivisor = n / i;
                if(otherDivisor != i)
                    System.out.println(otherDivisor);
            }
        }
    }

    // The above method doesn't print the divisors in sorted order. To achieve that, we'll
    // loop from 1 to sqrt(n) exclusive and from sqrt(n) to 1 inclusive in 2 for loops.
    private static void printDivisorsv3(int n){
        int i;
        for(i=1; i*i<n; i++)
            if(n%i==0)
                System.out.println(i);
        for(; i>=1; i--)
            if(n%i==0)
                System.out.println(n/i);
    }
}
