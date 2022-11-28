package com.ab.trees;

import com.ab.trees.impl.BinaryTree;
import com.ab.trees.impl.Node;

/**
 * @author Arpit Bhardwaj
 */
public class BinaryTreeLeavesCount {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.getLeftSkewedBinaryTree();
        System.out.println(binaryTree.root);
        int leavesCount = getLeavesCount(binaryTree.root);
        System.out.println("Leaves count in Sample Binary Tree is : " + leavesCount);
    }

    private static int getLeavesCount(Node root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return getLeavesCount(root.left) + getLeavesCount(root.right);
    }
}
