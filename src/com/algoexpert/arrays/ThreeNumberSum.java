package com.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    public static void main(String[] args) {
        // Input array, targetSum; Output: [[-8,2,6], [-8,3,5], [-6,1,5]]
        int[] array = {12,3,1,2,-6,5,-8,6};
        int targetSum = 0;

        List<Integer[]> result = threeNumberSum(array, targetSum);

        for (Integer[] triplet: result) {
            System.out.println(Arrays.toString(triplet));
        }
    }

    // O(n^2) time and O(n) space
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> triplets = new ArrayList<>();

        for(int i=0; i<array.length; i++){
            int left = i+1;
            int right = array.length-1;

            while(left < right){
                int currentSum = array[i] + array[left] + array[right];
                if(currentSum == targetSum){
                    triplets.add(new Integer[]{array[i], array[left], array[right]});
                    left++;
                    right--;
                } else if(currentSum < targetSum){
                    left++;
                } else if(currentSum > targetSum){
                    right--;
                }
            }
        }

        return triplets;
    }

}
