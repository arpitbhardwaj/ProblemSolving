package com.ab.trees;

/**
 * @author Arpit Bhardwaj
 *
 * Given a Binary Tree, we need to print the bottom view from left to right.
 * A node x is there in output if x is the bottommost node at its horizontal distance.
 */
public class BottomView {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.getSampleBinaryTree();
        System.out.println(binaryTree.root);
        System.out.println("Bottom View : ");
        printBottomView(binaryTree.root);
    }

    private static void printBottomView(Node root) {

    }
}
