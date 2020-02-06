package com.ab.trees;

/**
 * @author Arpit Bhardwaj
 *
 * Traversal implemented using recursion
 */
public class Traversal {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.getSampleBinaryTree();
        System.out.print("PreOrder Traversal : ");
        printPreOrderTraversal(binaryTree.root);
        System.out.println();
        System.out.print("InOrder Traversal : ");
        printInOrderTraversal(binaryTree.root);
        System.out.println();
        System.out.print("PostOrder Traversal : ");
        printPostOrderTraversal(binaryTree.root);
    }

    private static void printPreOrderTraversal(Node root) {
        if(root != null){
            System.out.print(root.data + "\t");
            printPreOrderTraversal(root.left);
            printPreOrderTraversal(root.right);
        }
    }

    private static void printInOrderTraversal(Node root) {
        if(root != null){
            printInOrderTraversal(root.left);
            System.out.print(root.data + "\t");
            printInOrderTraversal(root.right);
        }
    }

    private static void printPostOrderTraversal(Node root) {
        if(root != null){
            printPostOrderTraversal(root.left);
            printPostOrderTraversal(root.right);
            System.out.print(root.data + "\t");
        }
    }
}
