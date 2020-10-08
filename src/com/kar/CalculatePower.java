package com.kar;

public class CalculatePower {

    public static void main(String[] args) {
        int x = 4;
        int n = 5;

        //System.out.println(xPowerN(x, n));
        System.out.println(xPowN(x, n));
    }

    // Naive solution - O(n)
    private static int xPowerN(int x, int n) {
        int result = 1;

        for (int i = 0; i < n; i++)
            result = result * x;

        return result;
    }

    // Efficient solution - O(log n), O(log n) auxiliary space
    // if n is even, then x^n = x^(n/2) * x^(n/2)
    // if n is odd, then x^n = x^(n-1) * x
    private static int xPowN(int x, int n) {
        if (n == 0)
            return 1;

        int temp = xPowN(x, n / 2);
        temp = temp * temp;

        // if n is odd, n/2 will be 0.5 less than the actual value (integer data type)
        // which means, n/2 + n/2 will give us n-1 so we add 1 again to make it n
        if (n % 2 == 0)
            return temp;
        else
            return temp * x;
    }
}
