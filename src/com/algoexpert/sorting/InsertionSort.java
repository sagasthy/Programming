package com.algoexpert.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {8,5,2,9,5,6,3};
        System.out.println(Arrays.toString(insertionSort(arr)));
    }

    private static int[] insertionSort(int[] array) {
        for(int i=1; i<array.length; i++){
            int j=i;
            while(j>0 && array[j] < array[j-1]){
                swap(array, j, j-1);
                j--;
            }
        }

        return array;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
