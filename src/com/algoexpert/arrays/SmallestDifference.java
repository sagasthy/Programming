package com.algoexpert.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmallestDifference {

    public static void main(String[] args) {
//        int[] arrayOne = {-1, 5, 10, 20, 28, 3};
//        int[] arrayTwo = {26, 134, 135, 15, 17};

        int[] arrayOne = {10, 0, 20, 25, 2000};
        int[] arrayTwo = {1005, 1006, 1014, 1032, 1031};

        int[] result = smallestDifference(arrayOne, arrayTwo);

        System.out.println(Arrays.toString(result));
    }

    // O(n^2) time, O(n) space
    public static int[] smallestDifferenceMine(int[] arrayOne, int[] arrayTwo) {
        int smallestDiff = Integer.MAX_VALUE;
        Map<Integer, int[]> map = new HashMap<>();

        for(int i=0; i<arrayOne.length; i++){
            for(int j=0; j<arrayTwo.length; j++){
                int currentDiff = Math.abs(arrayOne[i] - arrayTwo[j]);
                smallestDiff = Math.min(smallestDiff,currentDiff);
                map.put(currentDiff, new int[]{arrayOne[i],arrayTwo[j]});
            }
        }

        return map.get(smallestDiff)!=null ? map.get(smallestDiff) : new int[0];
    }

    // O(nlog(n) + mlog(m)) time, O(1) space
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int indexOne = 0;
        int indexTwo = 0;
        int smallestDiff = Integer.MAX_VALUE;
        int currentDiff = Integer.MAX_VALUE;
        int[] smallestPair = new int[2];

        while(indexOne < arrayOne.length && indexTwo < arrayTwo.length){
//            System.out.println("********START**********");

            int firstNum = arrayOne[indexOne];
            int secondNum = arrayTwo[indexTwo];

//            System.out.println("firstNum: " + firstNum + " secondNum: " + secondNum);

            if(firstNum > secondNum){
                currentDiff = firstNum - secondNum;
                indexTwo++;
//                System.out.println("indexTwo++");
            } else if(firstNum < secondNum){
                currentDiff = secondNum - firstNum;
                indexOne++;
//                System.out.println("indexOne++");
            } else{ // to handle edge case in which both numbers are equal
//                System.out.println("Returning " + firstNum + " and " + secondNum);
                return new int[] {firstNum, secondNum};
            }

//            System.out.println("currentDiff: " + currentDiff);
//            System.out.println("smallestDiff: " + smallestDiff);

            if(currentDiff < smallestDiff){
                smallestDiff = currentDiff;
                smallestPair = new int[] {firstNum, secondNum};
            }
//            System.out.println("Smallest pair so far: " + Arrays.toString(smallestPair));
//            System.out.println("********END**********");
        }

        return smallestPair;
    }
}
