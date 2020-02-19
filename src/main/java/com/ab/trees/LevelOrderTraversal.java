package com.ab.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Arpit Bhardwaj
 * Regular Level Order Traversal (LOT): 1 Queue
 * Level By Level LOT : 2 Queue / 1 Queue and delimeter / 1 Queue and counter
 * Reverse LOT : 1 Queue + 1 Stack
 * Spiral LOT : 2 Stack / 1 Dequeue and delimeter / 1 Dequeue and counter
 *
 */
public class LevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.getSampleBinaryTree();
        System.out.print("Level order Traversal : ");
        printLevelOrder(binaryTree.root);
        System.out.println();
        System.out.print("Level by level level order Traversal : ");
        printLBLLevelOrder(binaryTree.root);
        System.out.println();
        System.out.print("Reverse Level order Traversal : ");
        printReverseLevelOrder(binaryTree.root);
        System.out.println();
        System.out.print("Spiral Level order Traversal : ");
        printSpiralLevelOrder(binaryTree.root);
    }

    private static void printLevelOrder(Node root) {
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
    }

    private static void printReverseLevelOrder(Node root) {
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

    private static void printSpiralLevelOrder(Node root) {
    }
}
