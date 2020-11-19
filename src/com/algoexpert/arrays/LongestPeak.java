package com.algoexpert.arrays;

public class LongestPeak {
    public static void main(String[] args) {
        int[] array = {1,2,3,3,4,0,10,6,5,-1,-3,2,3};
        int result = longestPeak(array);
    }

    private static int longestPeak(int[] array) {
        if(array.length < 3)
            return -1;

        int longest = 0;

        for(int i=1; i<array.length-1; i++){
            if(array[i] > array[i-1] && array[i] > array[i+1]){
                if(longest == 0)
                    longest = 3;
            }

        }

        return longest;
    }
}
