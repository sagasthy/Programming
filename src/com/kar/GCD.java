package com.kar;

import sun.font.CreatedFontTracker;

public class GCD {

    public static void main(String[] args) {
        int a = 120;
        int b = 72;
        System.out.println(findGCD(a, b));
        System.out.println(optimumSolution(a, b));
        System.out.println(byEuclidMethodv1(a, b));
    }

    private static int findGCD(int a, int b) {
        int result = Math.min(a, b);

        while(result > 0){
            if(a%result==0 && b%result==0)
                break;
            result--;
        }

        return result;
    }

    // O(log(min(a,b)))
    private static int optimumSolution(int a, int b){
        // also uses Euclid method but differently
        // when we use modulo operator for second argument, it makes sure the subsequent second arguments are
        // always lesser, and for the final iteration it becomes zero
        if(b == 0)
            return a;
        else
            return optimumSolution(b, a%b);
    }

    private static int byEuclidMethodv1(int a, int b){

        while(a != b){
            if(a > b)
                a = a-b;
            else
                b = b-a;
        }

        return a;
    }

    private static int byEuclidMethodv2(int a, int b){

        if(a == b)
            return a;

        // Euclid method states that GCD(a, b) = GCD(a-b, b), a>b
        return byEuclidMethodv2(a>b ? a-b : b-a, Math.min(a, b));
    }
}
