package com.algoexpert.bst;

import java.util.List;

public class MinHeightBST {
    public static void main(String[] args) {

    }

    public static BST minHeightBst(List<Integer> array) {
        //return constructMinHeightBst(array, null, 0, array.size()-1);
        return constructMinHeightBstv2(array, 0, array.size()-1);
    }

    // This version has the pre-implemented insert method provided to us, so leveraged it
    // O(n log n) time, O(n) space
    private static BST constructMinHeightBst(List<Integer> array, BST bst, int startIndex, int endIndex){
        if(endIndex < startIndex)
            return null;

        int midIndex = (startIndex + endIndex) / 2;
        int valueToAdd = array.get(midIndex);

        if(bst == null)
            bst = new BST(valueToAdd);
        else
            bst.insert(valueToAdd);

        constructMinHeightBst(array, bst, startIndex, midIndex-1);
        constructMinHeightBst(array, bst, midIndex+1, endIndex);

        return bst;
    }

    // This version doesn't use the provided insert method
    // O(n) time, O(n) space
    private static BST constructMinHeightBstv2(List<Integer> array, int startIndex, int endIndex) {
        if(startIndex > endIndex)
            return null;

        int midIndex = (startIndex + endIndex) / 2;

        BST bst = new BST(array.get(midIndex));
        bst.left = constructMinHeightBstv2(array, startIndex, midIndex-1);
        bst.right = constructMinHeightBstv2(array, midIndex+1, endIndex);

        return bst;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }

}
