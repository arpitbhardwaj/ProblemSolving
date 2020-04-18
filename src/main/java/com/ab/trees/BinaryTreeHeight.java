package com.ab.trees;

/**
 * The task is to find the height of regular binary tree. actually it doesn't matter it is applicable to all trees
 * Height = Maximum Depth = the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *
 * @author Arpit Bhardwaj
 */
public class BinaryTreeHeight {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.getSampleBinaryTree();
        int height = determineHeight(binaryTree.root);
        System.out.println(binaryTree.root);
        System.out.println("Height of Sample Binary Tree is : " + height);
    }

    public static int determineHeight(Node root) {
        if(root == null){
            return 0;
        }
        int leftSubTreeHeight = determineHeight(root.left);
        int rightSubTreeHeight = determineHeight(root.right);
        return Math.max(leftSubTreeHeight,rightSubTreeHeight) + 1;
    }
}
