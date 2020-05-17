package com.ab.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Arpit Bhardwaj
 *
 * Regular Level Order Traversal (LOT): 1 Queue
 * Level By Level LOT : 2 Queue / 1 Queue and delimeter / 1 Queue and counter
 * Reverse LOT : 1 Queue + 1 Stack
 */
public class LevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.getSampleBinaryTree();
        System.out.println(binaryTree.root);
        System.out.print("Level order Traversal : ");
        //printIterativeLevelOrder(binaryTree.root);
        printRecursiveLevelOrder(binaryTree.root);
        System.out.println();
        System.out.println("Level by level level order Traversal : ");
        printLBLLevelOrder(binaryTree.root);
        System.out.println();
        System.out.print("Reverse Level order Traversal : ");
        printIterativeReverseLevelOrder(binaryTree.root);
        System.out.println();
    }

    private static void printRecursiveLevelOrder(Node root) {
        int height = HeightAndDiameter.determineHeight(root);
        for (int i = 1; i <= height; i++) {
            printRecursiveLevelOrderUtil(root,i);
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
        Queue<Node> nodeQueue = new LinkedList<>();
        //add and offer inserts the element if there is a space
        //add throws IllegalStateException if Queue capacity restricted and no space is left for insertion
        //offer does not throws an exception when the capacity of the queue is full, it returns false instead.
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()){
            //poll and remove returns and removes the element
            //poll does not throw exception when the Queue is empty, it returns null instead
            //remove throws an NoSuchElementException when the Queue is empty
            Node node = nodeQueue.poll();
            System.out.print(node.data + "\t");
            if(node.left != null){
                nodeQueue.add(node.left);
            }
            if(node.right != null){
                nodeQueue.add(node.right);
            }
        }
    }

    private static void printLBLLevelOrder(Node root) {
        int height = HeightAndDiameter.determineHeight(root);
        for (int i = 1; i <= height; i++) {
            printRecursiveLevelOrderUtil(root,i);
            System.out.println();
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
