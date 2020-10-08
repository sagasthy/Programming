package com.kar;

public class Exactly3Divisors {
    public static void main(String[] args) {
        int N = 67;
        System.out.println(exactly3Divisors(N));
    }

    public static int exactly3Divisors(int N){
        int count = 0;

        for(int i=2; i*i<=N; i++)
            if(isPrime(i))
                count += 1;

        return count;
    }

    private static boolean isPrime(int n) {
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
