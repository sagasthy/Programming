package com.algoexpert.bst;

import java.util.ArrayList;
import java.util.List;

/*
      10
     /  \
    5   15
   / \    \
  2   5    22
 /
1

For the above tree, in-order traversal will output [1,2,5,5,10,15,22]
                    pre-order traversal will output [10,5,2,1,5,15,22]
                    post-order traversal will output [1,2,5,5,22,15,10]
 */
public class BstTraversals {

    public static void main(String[] args) {
        BstTraversals.BST root = new BstTraversals.BST(10);
        root.left = new BstTraversals.BST(5);
        root.left.left = new BstTraversals.BST(2);
        root.left.left.left = new BstTraversals.BST(1);
        root.left.right = new BstTraversals.BST(5);
        root.right = new BstTraversals.BST(15);
//        root.right.left = new BstTraversals.BST(13);
//        root.right.left.right = new BstTraversals.BST(14);
        root.right.right = new BstTraversals.BST(22);

        System.out.println(inOrderTraverse(root, new ArrayList<>()));
        System.out.println(preOrderTraverse(root, new ArrayList<>()));
        System.out.println(postOrderTraverse(root, new ArrayList<>()));

//        testTraversal(root);
    }

    static class BST{
        int value;
        BST left;
        BST right;

        public BST(int value){
            this.value = value;
        }
    }

    // O(n) time, O(n) space
    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array){
        if(tree.left != null)
            inOrderTraverse(tree.left, array);

        array.add(tree.value);

        if(tree.right != null)
            inOrderTraverse(tree.right, array);

        return array;
    }

    // O(n) time, O(n) space
    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array){
        array.add(tree.value);

        if(tree.left != null)
            preOrderTraverse(tree.left, array);

        if(tree.right != null)
            preOrderTraverse(tree.right, array);

        return array;
    }

    // O(n) time, O(n) space
    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array){
        if(tree.left != null)
            postOrderTraverse(tree.left, array);

        if(tree.right != null)
            postOrderTraverse(tree.right, array);

        array.add(tree.value);

        return array;
    }

    public static void testTraversal(BST tree){
        if(tree == null)
            return;

        testTraversal(tree.left);

        testTraversal(tree.right);

        System.out.println(tree.value);
    }
}
