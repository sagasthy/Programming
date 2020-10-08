package com.kar;

public class CountDigitsInANumber {

    public static void main(String[] args) {
        long n = 788749748;
        System.out.println(countDigits(n));
    }

    private static int countDigits(long n){
        return (int) Math.floor(Math.log10(n) + 1);
    }
}
