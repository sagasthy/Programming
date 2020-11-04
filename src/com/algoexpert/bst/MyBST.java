package com.algoexpert.bst;

import java.util.stream.IntStream;

// Implement a BST with insert, search and remove operations
public class MyBST {
    public static void main(String[] args) {
        MyBST.BST root = new MyBST.BST(10);
        root.left = new MyBST.BST(5);
        root.left.left = new MyBST.BST(2);
        root.left.left.left = new MyBST.BST(1);
        root.left.right = new MyBST.BST(5);
        root.right = new MyBST.BST(15);
        root.right.left = new MyBST.BST(13);
        root.right.left.right = new MyBST.BST(14);
        root.right.right = new MyBST.BST(22);

        System.out.println(root.contains(15));
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        // Average: O(log n) time and O(1) space
        // Worst: O(n) time and O(1) space
        public BST insert(int value) {
            BST currNode = this;

            while (true) {
                if (value < currNode.value) {
                    if (currNode.left == null) {
                        currNode.left = new BST(value);
                        break;
                    } else {
                        currNode = currNode.left;
                    }
                } else {
                    if (currNode.right == null) {
                        currNode.right = new BST(value);
                        break;
                    } else {
                        currNode = currNode.right;
                    }
                }
            }

            return this;
        }

        // Average: O(log n) time and O(1) space
        // Worst: O(n) time and O(1) space
        public boolean contains(int value) {
            BST currNode = this;

            while (currNode != null) {
                if (value < currNode.value) {
                    currNode = currNode.left;
                } else if (value > currNode.value) {
                    currNode = currNode.right;
                } else {
                    return true;
                }
            }

            return false;
        }

        // Average: O(log n) time and O(1) space
        // Worst: O(n) time and O(1) space
        public BST remove(int value) {
            remove(value, null);
            return this;
        }

        public void remove(int value, BST parentNode) {
            BST currNode = this;

            while (currNode != null) {
                if (value < currNode.value) {
                    parentNode = currNode;
                    currNode = currNode.left;
                } else if (value > currNode.value) {
                    parentNode = currNode;
                    currNode = currNode.right;
                } else {
                    // if the node has both left and right children nodes, then replace its value
                    // with the smallest value of the right subtree and delete the latter
                    if (currNode.left != null && currNode.right != null) {
                        currNode.value = currNode.right.getMinValue();
                        currNode.right.remove(currNode.value, currNode);
                    } else if (parentNode == null) {
                        if (currNode.left != null) {
                            currNode.value = currNode.left.value;
                            currNode.left = currNode.left.left;
                            currNode.right = currNode.left.right;
                        } else if (currNode.right != null) {
                            currNode.value = currNode.right.value;
                            currNode.left = currNode.right.left;
                            currNode.right = currNode.right.right;
                        } else {
                            // do nothing for one-node tree
                        }
                    } else if (currNode == parentNode.left) {
                        parentNode.left =
                                currNode.left != null ? currNode.left : currNode.right;
                    } else if (currNode == parentNode.right) {
                        parentNode.right =
                                currNode.right != null ? currNode.right : currNode.left;
                    }
                    break;
                }
            }
        }

        // Smallest value of the tree
        private int getMinValue() {
            if (left == null)
                return value;
            else
                return left.getMinValue();
        }
    }

}


