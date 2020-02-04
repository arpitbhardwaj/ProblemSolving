package com.ab.trees;

/**
 * @author Arpit Bhardwaj
 */
public class BinaryTreeSize {

    public static void main(String[] args) {
        //BinaryTree binaryTree = BinaryTree.getSampleBinaryTree();
        BinaryTree binaryTree = BinaryTree.getAnotherSampleBinaryTree();
        int size = determineSize(binaryTree.root);
        System.out.println("Size of Sample Binary Tree is : " + size);
    }

    public static int determineSize(Node root) {
        if(root == null){
            return 0;
        }
        int leftSubTreeSize = determineSize(root.left);
        int rightSubTreeSize = determineSize(root.right);
        return leftSubTreeSize + rightSubTreeSize + 1;
    }

}
