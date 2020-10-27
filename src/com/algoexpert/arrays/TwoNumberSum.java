package com.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoNumberSum {

    public static void main(String[] args) {

        // Input arr,targetSum; Output: [-1,11]
        int[] arr = {3,5,-4,8,11,1,-1,6};
        int targetSum = 10;

        int[] result = twoNumberSumv2(arr, targetSum);

        System.out.println(Arrays.toString(result));
    }

    // O(n) time and O(n) space
    private static int[] twoNumberSum(int[] arr, int targetSum) {
        Set<Integer> nums = new HashSet<>();

        for(int num: arr){
            int potentialMatch = targetSum - num;
            if(nums.contains(potentialMatch)){
                return new int[] {num, potentialMatch};
            } else{
                nums.add(num);
            }
        }

        return new int[]{};
    }

    // O(nlog(n)) time and O(1) space
    private static int[] twoNumberSumv2(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            int currentSum = arr[left] + arr[right];
            if(currentSum == targetSum){
                return new int[]{arr[left], arr[right]};
            } else if(currentSum < targetSum){
                left++;
            } else if(currentSum > targetSum){
                right--;
            }
        }

        return new int[]{};
    }

}
