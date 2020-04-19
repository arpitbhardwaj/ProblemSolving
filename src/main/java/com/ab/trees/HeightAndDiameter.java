package com.ab.trees;

/**
 * The task is to find the height of regular binary tree. actually it doesn't matter it is applicable to all trees
 * Height = Maximum Depth = the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * The diameter of a tree is the number of nodes on the longest path between two leaves in the tree.
 *
 * @author Arpit Bhardwaj
 */
public class HeightAndDiameter {
    static int diameter = Integer.MIN_VALUE;

    public static void main(String[] args) {
        //BinaryTree binaryTree = BinaryTree.getSampleBinaryTree();
        BinaryTree binaryTree = BinaryTree.getSampleBinarySearchTree();
        int height = determineHeight(binaryTree.root);
        System.out.println(binaryTree.root);
        System.out.println("Height of Sample Binary Tree is : " + height);
        System.out.println("Diameter of Sample Binary Tree is : " + diameter);
    }

    public static int determineHeight(Node root) {
        if(root == null){
            return 0;
        }
        int leftSubTreeHeight = determineHeight(root.left);
        int rightSubTreeHeight = determineHeight(root.right);
        diameter = Math.max(diameter, leftSubTreeHeight+rightSubTreeHeight+1);
        return Math.max(leftSubTreeHeight,rightSubTreeHeight) + 1;
    }
}
