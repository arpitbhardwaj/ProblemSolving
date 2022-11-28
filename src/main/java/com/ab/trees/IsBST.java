package com.ab.trees;

import com.ab.trees.impl.BinaryTree;
import com.ab.trees.impl.Node;

/**
 * @author Arpit Bhardwaj
 */
public class IsBST {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.getBinarySearchTree();
        //BinaryTree binaryTree = BinaryTree.getSampleBinaryTree();
        //BinaryTree binaryTree = BinaryTree.getAnotherSampleBinaryTree();
        System.out.println(binaryTree.root);
        boolean isBST = isBST(binaryTree.root);
        System.out.println("is given tree a BST : " + isBST);
    }

    public static boolean isBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBST(Node node, int min, int max) {
        if (node == null){
            return true;
        }
        if (node.data <= min || node.data > max){
            return false;
        }
        return isBST(node.left, min, node.data) && isBST(node.right,node.data,max);
    }
}
