package com.kar;

public class CountTrailingZerosInFactorial {

    public static void main(String[] args) {
        int n = 6;
        System.out.println(countTrailingZerosInFactorial(n));
    }

    private static int countTrailingZerosInFactorial(int n) {
        int result = 0;

        for(int i=5; i<=n; i=i*5)
            result = result + n/i;

        return result;
    }
}
