package com.kar;

public class CheckPrime {

    public static void main(String[] args) {
        int n = 49;
        System.out.println(isPrimeOptimum(n));
    }

    // Naive solution - O(n)
    private static boolean isPrimeBasic(int n) {
        if (n == 1)
            return false;

        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    // Efficient solution - O(sqrt(n))
    // Based on the idea, divisors always appear in pairs
    // If x,y are divisors of n, then x*y = n
    // x <= y
    // => x*x <= n
    // => x <= sqrt(n)
    // Conclusion: If n is a composite number, it must have at least one divisor between 2 and sqrt(n)
    private static boolean isPrime(int n) {
        if (n == 1)
            return false;

        //for (int i = 2; i <= Math.sqrt(n); i++) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    // We can further optimize the above method by adding a few extra checks
    // If we add n%2 == 0 and n%3 == 0, it will save us a lot of iterations in the above implementation
    private static boolean isPrimeOptimum(int n) {
        if (n == 1)
            return false;

        if(n == 2 || n == 3)
            return true;

        if(n%2==0 || n%3==0)
            return false;

        for (int i = 5; i * i <= n; i=i+6) {
            if (n%i==0 || n%(i+2)==0)
                return false;
        }

        return true;
    }
}
