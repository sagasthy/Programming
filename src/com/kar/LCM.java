package com.kar;

public class LCM {

    public static void main(String[] args) {
        int a = 4;
        int b = 6;

        System.out.println(findLCMBasic(a, b));
        System.out.println(optimumSolution(a, b));
    }

    // Naive solution - O(a*b-max(a,b))
    private static int findLCMBasic(int a, int b) {
        int result = Math.max(a, b);
        while (result % a != 0 || result % b != 0) {
            result++;
        }
        return result;
    }

    // Based on the principle, a*b = GCD(a,b)*LCM(a,b) => LCM(a,b) = a*b/GCD(a,b)
    // O(log(min(a,b)))
    private static int optimumSolution(int a, int b){
        return a*b/gcd(a,b);
    }

    private static int gcd(int a, int b){
        if(b == 0)
            return a;
        else
            return gcd(b, a%b);
    }
}
