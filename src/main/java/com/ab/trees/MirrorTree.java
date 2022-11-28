package com.ab.trees;

import com.ab.trees.impl.BinaryTree;
import com.ab.trees.impl.Node;

/**
 * @author Arpit Bhardwaj
 *
 * Given a Binary Tree, convert it into its mirror.
 */
public class MirrorTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.getSampleBinaryTree();
        System.out.println(binaryTree.root);
        Node mirrorImageBTRoot = getMirrorImageBinaryTree(binaryTree.root);
        System.out.println(mirrorImageBTRoot);
    }

    private static Node getMirrorImageBinaryTree(Node root) {
        //base case
        if (root == null){
            return root;
        }
        //get left and right binary tree mirror image
        Node left = getMirrorImageBinaryTree(root.left);
        Node right = getMirrorImageBinaryTree(root.right);

        //swap the left and right node
        root.left = right;
        root.right = left;

        return root;
    }
}
