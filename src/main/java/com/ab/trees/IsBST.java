package com.ab.trees;

/**
 * @author Arpit Bhardwaj
 */
public class IsBST {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.getSampleBinarySearchTree();
        //BinaryTree binaryTree = BinaryTree.getSampleBinaryTree();
        //BinaryTree binaryTree = BinaryTree.getAnotherSampleBinaryTree();
        System.out.println(binaryTree.root);
        boolean isBST = isBST(binaryTree.root);
        System.out.println("is given tree a BST : " + isBST);
    }

    public static boolean isBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBST(Node root, int min, int max) {
        if (root == null){
            return true;
        }
        if (root.data <= min || root.data > max){
            return false;
        }
        return isBST(root.left, min, root.data) && isBST(root.right,root.data,max);
    }
}
