package com.ab.trees;

/**
 * @author Arpit Bhardwaj
 *
 * Given a binary tree in which each node element contains a number.
 * Find the maximum possible sum from one leaf node to another.
 */
public class MaxPathSum {
    static int maxSum = Integer.MIN_VALUE;
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.getSampleBinaryTree();
        System.out.println(binaryTree.root);

        System.out.println(maxPathSum(binaryTree.root));
    }

    private static int maxPathSum(Node root) {
        /*if (root.left ==null && root.right == null){
            return root.data;
        }
        int leftSum = maxPathSum(root.left);
        int rightSum = maxPathSum(root.right);
        return Math.max(maxSum,leftSum+rightSum);*/
        return 0;
    }
}
