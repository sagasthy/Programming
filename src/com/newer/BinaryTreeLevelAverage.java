package com.newer;

import java.util.*;

public class BinaryTreeLevelAverage {
    public static void main(String[] args) {
        /*
            4
           / \
          7   9
         / \   \
        10  2   6
             \
              6
             /
            2
         */
        Node root = new Node(4);
        root.left = new Node(7);
        root.left.left = new Node(10);
        root.left.right = new Node(2);
        root.left.right.right = new Node(6);
        root.left.right.right.left = new Node(2);
        root.right = new Node(9);
        root.right.right = new Node(6);

//        inorder(root);
//        System.out.println(levelAverage(root));
//        System.out.println(levelAverageOptimal(root));
        System.out.println(levelAverageBfs(root));
        System.out.println("*********************");

        /*
            1
           / \
          2   3
         / \
        4   5
         */

        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);

//        inorder(tree);
//        System.out.println(levelAverage(tree));
//        System.out.println(levelAverageOptimal(tree));
        System.out.println(levelAverageBfs(tree));
    }

    private static List<Float> levelAverageBfs(Node root) {
        if(root == null)
            return new ArrayList<>();

        List<Float> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int sum = 0;
            int count = 0;
            int levelSize = queue.size();

            for(int i=0; i<levelSize; i++) {
                Node curr = queue.poll();
                sum += curr.val;
                count += 1;
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }

            result.add((float) sum / count);
        }
        return result;
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    private static List<Float> levelAverage(Node root) {
        List<Float> result = new ArrayList<>();
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        populateLevelMap(root, levelMap, 0);

        System.out.println("levelMap: " + levelMap);

        for(int level: levelMap.keySet()) {
            List<Integer> thisLevel = levelMap.get(level);
            int sum = thisLevel
                    .stream()
                    .reduce(Integer::sum)
                    .get();
            result.add((float) sum / thisLevel.size());
        }

        return result;
    }

    // In this method, instead of saving a list of values for each level,
    // save a tuple of level sum and level size. This will be space optimal for
    // large inputs
    private static List<Float> levelAverageOptimal(Node root) {
        List<Float> result = new ArrayList<>();
        Map<Integer, int[]> levelTuple = new HashMap<>();
        populateLevelTuple(root, levelTuple, 0);

        for(int level: levelTuple.keySet())
            result.add(
                    (float) levelTuple.get(level)[0] / levelTuple.get(level)[1]
            );

        return result;
    }

    private static void populateLevelTuple(Node root, Map<Integer, int[]> levelTuple, int level) {
        if(root == null)
            return;

        if(levelTuple.containsKey(level)) {
            int[] tuple = levelTuple.get(level);
            tuple[0] += root.val;
            tuple[1] += 1;
            levelTuple.put(level, tuple);
        } else {
            levelTuple.put(level, new int[]{root.val, 1});
        }

        if(root.left != null)
            populateLevelTuple(root.left, levelTuple, level + 1);

        if(root.right != null)
            populateLevelTuple(root.right, levelTuple, level + 1);
    }

    private static void populateLevelMap(Node root, Map<Integer, List<Integer>> levelMap, int level) {
        if(root == null)
            return;

        if(levelMap.containsKey(level))
            levelMap.get(level).add(root.val);
        else
            levelMap.put(level, new ArrayList<>(Arrays.asList(root.val)));

        if(root.left != null)
            populateLevelMap(root.left, levelMap, level+1);

        if(root.right != null)
            populateLevelMap(root.right, levelMap, level+1);
    }

    // not needed for the actual problem
    private static void inorder(Node root) {
        if(root == null)
            return;

        if(root.left != null)
            inorder(root.left);

        System.out.println(root.val);

        if(root.right != null)
            inorder(root.right);
    }
}

class Node {
    int val;
    Node left;
    Node right;

    Node (int val) {
        this.val = val;
    }
}
