package com.ab.trees;

/**
 * @author Arpit Bhardwaj
 *
 *  * Spiral LOT : 2 Stack / 1 Dequeue and delimeter / 1 Dequeue and counter
 *  * Reverse Spiral LOT :
 */
public class SpiralOrder {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.getSampleBinaryTree();
        System.out.println(binaryTree.root);
        System.out.print("Spiral Level order Traversal : ");
        printSpiralLevelOrder(binaryTree.root);
        System.out.println();
        System.out.print("Reverse Spiral Level order Traversal : ");
        printReverseSpiralLevelOrder(binaryTree.root);
    }

    private static void printReverseSpiralLevelOrder(Node root) {
        int height = HeightAndDiameter.determineHeight(root);
        boolean ltr = false;
        for (int i = height; i >= 1; i--) {
            printSpiralLevelOrderUtil(root,i,ltr);
            ltr = !ltr;
        }
    }

    private static void printSpiralLevelOrder(Node root) {
        int height = HeightAndDiameter.determineHeight(root);
        boolean ltr = false;
        for (int i = 1; i <= height; i++) {
            printSpiralLevelOrderUtil(root,i,ltr);
            ltr = !ltr;
        }
    }

    private static void printSpiralLevelOrderUtil(Node root, int level, boolean ltr) {
        if(root == null){
            return;
        }
        if (level == 1){
            System.out.print(root.data + "\t");
        }else {
            if (ltr){
                printSpiralLevelOrderUtil(root.left, level - 1,ltr);
                printSpiralLevelOrderUtil(root.right, level - 1,ltr);
            }else {
                printSpiralLevelOrderUtil(root.right, level - 1,ltr);
                printSpiralLevelOrderUtil(root.left, level - 1,ltr);
            }
        }
    }
}
