package com.kar;

import com.algoexpert.bst.MyBST;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) {
        BST root = new BST(10);
        root = root.insert(15);
        root = root.insert(16);
        root = root.insert(9);

        System.out.println(root.contains(9));

        root = root.remove(9);

        System.out.println(root.contains(9));
    }

    static class BST {
        int value;
        BST left;
        BST right;

        BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            if (value < this.value) {
                if (left != null)
                    left.insert(value);
                else
                    left = new BST(value);
            } else {
                if (right != null)
                    right.insert(value);
                else
                    right = new BST(value);
            }

            return this;
        }

        public boolean contains(int value) {
            BST currNode = this;
            while (currNode != null) {
                if (value < currNode.value)
                    currNode = currNode.left;
                else if (value > currNode.value)
                    currNode = currNode.right;
                else if (value == currNode.value)
                    return true;
            }
            return false;
        }

        public BST remove(int value){
            remove(value, null);
            return this;
        }

        public void remove(int value, BST parentNode) {
            BST currNode = this;

            while(currNode != null){
                if(value <  currNode.value){
                    parentNode = currNode;
                    currNode = currNode.left;
                } else if (value > currNode.value){
                    parentNode = currNode;
                    currNode = currNode.right;
                } else {
                    if(currNode.left != null && currNode.right != null){
                        currNode.value = currNode.right.getMinValue();
                        currNode.right.remove(currNode.value, currNode);
                    } else if(parentNode == null){
                        if(currNode.left != null){
                            currNode.value = currNode.left.value;
                            currNode.right = currNode.left.right;
                            currNode.left = currNode.left.left;
                        } else if(currNode.right != null){
                            currNode.value = currNode.right.value;
                            currNode.left = currNode.right.left;
                            currNode.right = currNode.right.right;
                        } else{
                            // One node tree
                        }
                    } else if(currNode == parentNode.left){
                        currNode.left = currNode.left != null ? currNode.left : currNode.right;
                    } else if(currNode == parentNode.right){
                        currNode.right = currNode.left != null ? currNode.left : currNode.right;
                    }
                    break;
                }
            }
        }

        private int getMinValue() {
            if (left == null)
                return value;
            else
                return left.getMinValue();
        }
    }

}
