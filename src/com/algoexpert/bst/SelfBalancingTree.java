package com.algoexpert.bst;

public class SelfBalancingTree {
    static Node insert(Node root,int val) {
        if (root == null){
            Node n = new Node();
            n.val = val;
            n.ht = 0;
            return n;
        }

        Node n;

        if(val > root.val){
            n = insert(root.right,val);
            root.right = n;
        }else{
            n = insert(root.left,val);
            root.left = n;
        }

        if(root.ht==n.ht)
            root.ht++;

        root = balance(root);

        return root;
    }

    static Node balance(Node root){
        int htLeft = (root.left==null)?0:root.left.ht+1;
        int htRight = (root.right==null)?0:root.right.ht+1;
        if(htLeft-htRight<-1){
            //rotate left
            Node child = root.right;
            int childBF = ((child.left==null)?0:child.left.ht+1) - ((child.right==null)?0:child.right.ht+1);
            if (childBF > 0){
                Node newChildRoot = child.left;
                Node tmp = newChildRoot.right;
                newChildRoot.right = child;
                child.left = tmp;
                root.right = newChildRoot;
                int tmpH = child.ht;
                child.ht=newChildRoot.ht;
                newChildRoot.ht = tmpH;
            }
            Node newRoot = root.right;
            Node tmp = newRoot.left;
            newRoot.left = root;
            root.right = tmp;
            int tmpH = root.ht;
            root.ht=newRoot.ht-1;
            newRoot.ht = tmpH-1;
            root = newRoot;
        } else if(htLeft-htRight>1){
            //rotate right
            Node child = root.left;
            int childBF = ((child.left==null)?0:child.left.ht+1) - ((child.right==null)?0:child.right.ht+1);
            if (childBF < 0){
                Node newChildRoot = child.right;
                Node tmp = newChildRoot.left;
                newChildRoot.left = child;
                child.right = tmp;
                root.left = newChildRoot;
                int tmpH = child.ht;
                child.ht=newChildRoot.ht;
                newChildRoot.ht = tmpH;
            }
            Node newRoot = root.left;
            Node tmp = newRoot.right;
            newRoot.right = root;
            root.left = tmp;
            int tmpH = root.ht;
            root.ht=newRoot.ht-1;
            newRoot.ht = tmpH-1;
            root = newRoot;
        }

        return root;
    }
}

class Node {
    int val;
    Node left;
    Node right;
    int ht;
}
