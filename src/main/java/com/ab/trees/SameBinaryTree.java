package com.ab.trees;

import com.ab.trees.impl.BinaryTreeFromLL;
import com.ab.trees.impl.Node;

/**
 * @author Arpit Bhardwaj
 */
public class SameBinaryTree {
    public static void main(String[] args) {
        BinaryTreeFromLL.BinaryTree bt1 = BinaryTreeFromLL.getBinaryTree();
        BinaryTreeFromLL.BinaryTree bt2 = BinaryTreeFromLL.getBinaryTree();
        System.out.println(bt1.root);
        System.out.println(bt2.root);
        //BinaryTree bt2 = BinaryTree.getAnotherSampleBinaryTree();
        boolean isSame = isSameBinaryTree(bt1.root,bt2.root);
        System.out.println("Are both trees same : " + isSame);
    }

    private static boolean isSameBinaryTree(Node node1, Node node2) {
        if(node1 == null && node2 == null){
            return true;
        }else if(node1 == null || node2 == null){
            return false;
        }else{
            return node1.data == node2.data
                    && isSameBinaryTree(node1.left, node2.left)
                    && isSameBinaryTree(node1.right, node2.right);
        }
    }
}
