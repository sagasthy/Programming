package com.algoexpert.bst;

public class BSTValidation {
    public static void main(String[] args) {
        BSTValidation.BST root = new BSTValidation.BST(10);
        root.left = new BSTValidation.BST(5);
        root.left.left = new BSTValidation.BST(2);
        root.left.left.left = new BSTValidation.BST(1);
        root.left.right = new BSTValidation.BST(5);
        root.right = new BSTValidation.BST(15);
        root.right.left = new BSTValidation.BST(13);
        root.right.left.right = new BSTValidation.BST(14);
        root.right.right = new BSTValidation.BST(22);

        System.out.println(validateBST(root));
    }

    static class BST {
        public int value;
        public BSTValidation.BST left;
        public BSTValidation.BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static boolean validateBST(BST tree){
        return validateBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // O(n) time, O(d) space where d is the depth of the Binary Tree
    // Here when we call the validate method on the root node, it in turn calls it on
    // its left and right subtrees till it reaches the leaf nodes, so the call stack has
    // to be maintained at the max (d) at any given time, hence O(d) space.
    private static boolean validateBST(BST tree, int minValue, int maxValue) {
        if(tree.value < minValue || tree.value >= maxValue)
            return false;
        if(tree.left != null && !validateBST(tree.left, minValue, tree.value))
            return false;
        if(tree.right != null && !validateBST(tree.right, tree.value, maxValue))
            return false;

        return true;
    }
}
