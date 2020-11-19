package com.algoexpert.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    public static void main(String[] args) {
        int[][] array = {
                {1,2,3,4},
                {12,13,14,5},
                {11,16,15,6},
                {10,9,8,7}
        };

        System.out.println(spiralTraverseV2(array));
    }

    // Iterative - O(n) time and O(n) space
    public static List<Integer> spiralTraverse(int[][] array){
        List<Integer> spiralTraversal = new ArrayList<>();
        int startRow = 0;
        int endRow = array.length - 1;
        int startColumn = 0;
        int endColumn = array[0].length - 1;

        while(startRow <= endRow && startColumn <= endColumn){
            for(int column=startColumn; column<=endColumn; column++)
                spiralTraversal.add(array[startRow][column]);

            for(int row=startRow+1; row<=endRow; row++)
                spiralTraversal.add(array[row][endColumn]);

            for(int column=endColumn-1; column>=startColumn; column--) {
                // Handle the edge case, with single column in the middle of the matrix
                if(startRow == endRow)
                    break;
                spiralTraversal.add(array[endRow][column]);
            }

            for(int row=endRow-1; row>startRow; row--){
                // Handle the edge case, with single row in the middle of the matrix
                if(startColumn == endColumn)
                    break;
                spiralTraversal.add(array[row][startColumn]);
            }

            startRow++;
            endRow--;
            startColumn++;
            endColumn--;
        }

        return spiralTraversal;
    }

    // Recursive - O(n) time and O(n) space
    public static List<Integer> spiralTraverseV2(int[][] array){
        List<Integer> result = new ArrayList<>();

        if(array.length == 0)
            return result;

        spiralFill(array, 0, array.length-1, 0, array[0].length-1, result);
        return result;
    }

    public static void spiralFill(int[][] array, int startRow, int endRow, int startColumn, int endColumn, List<Integer> result){
        if(startRow > endRow || startColumn > endColumn)
            return;

        for(int column=0; column<=endColumn; column++)
            result.add(array[startRow][column]);

        for(int row=0; row<=endRow; row++)
            result.add(array[row][endColumn]);

        for(int column=endColumn-1; column>=startColumn; column--){
            if(startRow == endRow)
                break;
            result.add(array[endRow][column]);
        }

        for(int row=endRow-1; row>startRow; row--){
            if(startColumn == endColumn)
                break;
            result.add(array[row][startColumn]);
        }

        spiralFill(array, startRow+1, endRow-1, startColumn+1, endColumn-1, result);
    }
}
