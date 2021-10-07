package com.ab.trees;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 *
 * Level Order Traversal (LOT)
 *
 * Regular LOT          : 1 Queue
 * Level By Level LOT   : 2 Queue / 1 Queue and delimeter / 1 Queue and counter
 * Reverse LOT          : 1 Queue + 1 Stack
 */
public class LevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.getSampleBinaryTree();
        System.out.println(binaryTree.root);

        System.out.println("LOT : ");
        printIterativeLevelOrder(binaryTree.root);
        System.out.println();
        printRecursiveLevelOrder(binaryTree.root);
        System.out.println();

        System.out.println("LBL LOT : ");
        printIterativeLBLLevelOrder(binaryTree.root);
        System.out.println();

        System.out.println("Reverse LOT: ");
        printIterativeReverseLevelOrder(binaryTree.root);
    }

    private static void printRecursiveLevelOrder(Node root) {
        int height = Dimensions.determineHeight(root);
        for (int i = 1; i <= height; i++) {
            printRecursiveLevelOrderUtil(root,i);
            //System.out.println();//for level by level
        }
    }

    private static void printRecursiveLevelOrderUtil(Node root, int level) {
        if(root == null){
            return;
        }
        if (level == 1){
            System.out.print(root.data + "\t");
        }else {
            printRecursiveLevelOrderUtil(root.left, level - 1);
            printRecursiveLevelOrderUtil(root.right, level - 1);
        }
    }

    private static void printIterativeLevelOrder(Node root) {
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.data + "\t");
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }

    private static void printIterativeLBLLevelOrder(Node root) {
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> levelNodes = new ArrayList<>();
            int levelSize = queue.size();
            while (levelSize > 0){
                Node node = queue.poll();
                levelNodes.add(node.data);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                levelSize--;
            }
            System.out.println(levelNodes);
        }
    }

    private static void printIterativeReverseLevelOrder(Node root) {
        if(root == null){
            return;
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        Stack<Node> nodeStack = new Stack<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()){
            Node node = nodeQueue.poll();
            if(node.right != null){
                nodeQueue.offer(node.right);
            }
            if(node.left != null){
                nodeQueue.offer(node.left);
            }
            nodeStack.push(node);
        }
        while (!nodeStack.isEmpty()){
            System.out.print(nodeStack.pop().data + "\t");
        }
    }
}
