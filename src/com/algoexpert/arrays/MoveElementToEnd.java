package com.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(2,1,2,2,2,3,4,2,2);
        int toMove = 2;
        System.out.println(moveElementToEnd(array, toMove));
    }

    // O(n) time and O(1) space
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int left = 0;
        int right = array.size()-1;

        while(left < right){
            // here we want the right pointer to be decremented progressively until it finds a number other than
            // the number to be moved. Also, there's a chance right pointer may go beyond the left pointer in this
            // process which is why we have an additional check "left < right"
            while(left < right && array.get(right) == toMove)
                right--;

            // The below doesn't work
//            if(array.get(right) == toMove)
//                right--;

            if(array.get(left) == toMove)
                swap(array, left, right);

            left++;
        }

        return array;
    }

    private static void swap(List<Integer> array, int left, int right) {
        int temp = array.get(left);
        array.set(left, array.get(right));
        array.set(right, temp);
    }
}
