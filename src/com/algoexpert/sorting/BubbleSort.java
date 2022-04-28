package com.algoexpert.sorting;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {8,5,2,9,5,6,3};

        Random random = new Random();
        int[] randomArr = random.ints(10, 1, 100)
                .toArray();

        System.out.println("Before sorting: " + Arrays.toString(randomArr));
        int[] sorted = bubbleSort(randomArr);
        System.out.println("After sorting: " + Arrays.toString(sorted));
    }

    private static int[] bubbleSort(int[] array) {
        int swapCounter = 0;
        boolean isSorted = false;

        while(!isSorted){
            isSorted = true;
            for(int i=0; i<array.length-1-swapCounter; i++){
                if(array[i] > array[i+1]){
                    swap(array, i, i+1);
                    isSorted = false;
                }
            }
            swapCounter++;
        }

        return array;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
