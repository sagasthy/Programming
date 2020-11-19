package com.algoexpert.arrays;

import java.util.Arrays;
import java.util.List;

public class MonotonicArray {
    public static void main(String[] args) {
//        int[] array = {-1,-5,-10,-1100,-1100,-1102,-9001};
        int[] array = {1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10, 11};
        System.out.println(isMonotonicV2(array));
    }

    // Monotonic array is an array in which all the elements are entirely non-increasing or non-decreasing (can be same)
    public static boolean isMonotonic(int[] array) {
        if(array.length==0 || array.length==1)
            return true;

        boolean nonIncreasing = array[1]-array[0] <= 0;
        boolean nonDecreasing = array[1]-array[0] >= 0;

        for(int i=2; i<array.length; i++){
            if(nonDecreasing && nonIncreasing){
                nonDecreasing = array[i]-array[i-1]>=0;
                nonIncreasing = array[i]-array[i-1]<=0;
            }

            if(nonDecreasing && array[i]<array[i-1])
                return false;

            if(nonIncreasing && array[i]>array[i-1])
                return false;
        }

        return true;
    }

    // O(n) time O(1) space
    public static boolean isMonotonicV2(int[] array){
        boolean nonIncreasing = true;
        boolean nonDecreasing = true;

        for(int i=1; i<array.length; i++){
            if(array[i] < array[i-1])
                nonDecreasing = false;

            if(array[i] > array[i-1])
                nonIncreasing = false;
        }

        return nonDecreasing || nonIncreasing;
    }
}
