package com.newer;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{22, 5, 11, 9, 8, 17};
//        sort(arr);
        sortV2(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = new int[]{1,22,54,7,10,29,71,99};
        int count = count(arr2);
        System.out.println("count: " + count);
    }

    private static int minIdx(int[] arr, int start, int end) {
        int minIdx = -1;
        int min = Integer.MAX_VALUE;

        for(int i=start; i<end; i++) {
            if(arr[i] < min) {
                min = arr[i];
                minIdx = i;
            }
        }
        return minIdx;
    }

    private static void sort(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n-1; i++) {
            int minIdx = i;
            for (int j=i+1; j<n; j++)
                if(arr[j] < arr[minIdx]) minIdx = j;

            swap(arr, i, minIdx);
        }
    }

    private static void sortV2(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n-1; i++) {
            int minIdx = minIdx(arr, i+1, n);
            swap(arr, i, minIdx);
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static int count(int[] arr) {
        return countR(0, arr.length-1, 0);
    }

    private static int countR(int start, int end, int currentCount) {
        currentCount += 1;

        if(start >= end) return currentCount;

        return countR(start+1, end, currentCount);
    }
}