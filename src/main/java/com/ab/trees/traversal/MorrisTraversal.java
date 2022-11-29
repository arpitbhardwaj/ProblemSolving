package com.ab.trees.traversal;

import com.ab.trees.impl.BinaryTreeFromLL;
import com.ab.trees.impl.Node;

/**
 * @author Arpit Bhardwaj
 *
 * Morris Traversal is based on Threaded Binary Tree.
 * Using Morris Traversal, we can traverse the tree without using stack and recursion.
 * we first create links to Inorder successor and print the data using these links, and finally revert the changes to restore original tree.
 *
 * Inorder Predecessor = Rightmost on the left subtree
 */
public class MorrisTraversal {
    public static void main(String[] args) {
        BinaryTreeFromLL.BinaryTree binaryTree = BinaryTreeFromLL.getBinaryTree();
        System.out.print("PreOrder Traversal : ");
        printMorrisInOrderTraversal(binaryTree.root);
    }

    private static void printMorrisInOrderTraversal(Node root) {
        Node current = root;
        while (current != null){
            if (current.left == null){
                System.out.print(current.data + "\t");
                current = current.right;
            }
            else{
                //find the inorder predecessor
                Node inorderPredecessor = current.left;
                while (inorderPredecessor.right != current
                && inorderPredecessor.right != null){
                    inorderPredecessor = inorderPredecessor.right;
                }

                //if right node is null then go left after establishing link from predecessor to current.
                if (inorderPredecessor.right == null){
                    inorderPredecessor.right = current;
                    current = current.left;
                }
                //left is already visit. Go rigth after visiting current.
                else{
                    inorderPredecessor.right = null;
                    System.out.print(current.data + "\t");
                    current = current.right;
                }
            }
        }
    }
}
