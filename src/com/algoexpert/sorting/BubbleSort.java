package com.algoexpert.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {8,5,2,9,5,6,3};
        System.out.println(Arrays.toString(bubbleSort(arr)));
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
