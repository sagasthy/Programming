package com.newer;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] randomArr = random.ints(10, 1, 100)
                        .toArray();

        System.out.println("Before sorting: " + Arrays.toString(randomArr));
        quickSort(randomArr);
        System.out.println("After sorting: " + Arrays.toString(randomArr));
    }

    private static void quickSort(int[] randomArr) {
        quickSort(randomArr, 0, randomArr.length-1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if(start >= end)
            return;

        int pivotIndex = new Random().nextInt(end-start) + start;
        System.out.println("pivotIndex: " + pivotIndex);
        swap(arr, pivotIndex, end);
        int pivot = arr[end];

        int leftPointer = partition(arr, start, end, pivot);

        quickSort(arr, start, leftPointer - 1);
        quickSort(arr, leftPointer + 1, end);
    }

    private static int partition(int[] arr, int start, int end, int pivot) {
        int leftPointer = start;
        int rightPointer = end;

        while(leftPointer < rightPointer) {
            while(arr[leftPointer] <= pivot && leftPointer < rightPointer)
                leftPointer++;
            while (arr[rightPointer] >= pivot && leftPointer < rightPointer)
                rightPointer--;

            swap(arr, leftPointer, rightPointer);
        }

        // handling edge case where last element could be out of order
        if(arr[leftPointer] > arr[end])
            swap(arr, leftPointer, end);
        else
            leftPointer = end;

        return leftPointer;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
