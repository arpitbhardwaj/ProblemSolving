package com.ab.trees.traversal;

import com.ab.trees.impl.BinaryTreeFromLL;
import com.ab.trees.impl.Node;

import java.util.Stack;

/**
 * @author Arpit Bhardwaj
 *
 * Iterative Pre Order  : Using 1 Stacks
 * Iterative In Order   : Using 1 Stacks
 * Iterative Post Order : Using 2 Stacks
 *
 * Top Down Approach (Root, Left, Right) or Bottom Up Approach (Left, Right, Root)
 */
public class Traversal {
    public static void main(String[] args) {
        BinaryTreeFromLL.BinaryTree binaryTree = BinaryTreeFromLL.getBinaryTree();
        System.out.println("Iterative PreOrder Traversal : ");
        printIterativePreOrder(binaryTree.root);
        System.out.println();
        printPreOrder(binaryTree.root);
        System.out.println();

        System.out.println("Iterative InOrder Traversal : ");
        printIterativeInOrder(binaryTree.root);
        System.out.println();
        printInOrder(binaryTree.root);
        System.out.println();

        System.out.println("Iterative PostOrder Traversal : ");
        printIterativePostOrder(binaryTree.root);
        System.out.println();
        printPostOrder(binaryTree.root);
    }

    //TC: O(n) and SC: O(h) where h is height of the tree
    private static void printIterativePreOrder(Node root) {
        if(root == null){
            return;
        }
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()){
            Node node = nodeStack.pop();
            //Visit the node
            System.out.print(node.data + "\t");
            if(node.right != null){
                //As Right need to visit last, hence push it to stack first
                nodeStack.push(node.right);
            }
            if (node.left != null){
                //As Left need to visit first(First Out), hence push it to stack last (Last IN) (LIFO)
                nodeStack.push(node.left);
            }
        }
    }

    //TC: O(n) and SC: O(h) where h is height of the tree
    private static void printIterativeInOrder(Node root) {
        if(root == null){
            return;
        }
        Stack<Node> nodeStack = new Stack<>();
        Node node = root;
        while (true){
            if (node != null){
                nodeStack.push(node);       //push the node
                node = node.left;           //traverse the left
            }else{
                if(nodeStack.isEmpty()){
                    break;
                }
                node = nodeStack.pop();
                System.out.print(node.data + "\t"); //read the node
                node = node.right;                  //traverse the right
            }
        }
    }

    //TC: O(n) and SC: O(h) where h is height of the tree
    private static void printIterativePostOrder(Node root) {
        if(root == null){
            return;
        }
        Stack<Node> nodeStack1 = new Stack<>();
        Stack<Node> nodeStack2 = new Stack<>();

        nodeStack1.push(root);
        while (!nodeStack1.isEmpty()){
            Node node = nodeStack1.pop();
            //As node need to visit last push first in stack 2
            nodeStack2.push(node);
            if(node.left != null){
                //As left need to visit first hence, push first in stack 1
                // so later on pop, pushed last in stack 2 to come first out
                nodeStack1.push(node.left);
            }
            if (node.right != null){
                nodeStack1.push(node.right);
            }
        }
        while (!nodeStack2.isEmpty()){
            System.out.print(nodeStack2.pop().data + "\t");
        }
    }

    // TC: O(n) SC: O(n)
    private static void printPreOrder(Node root) {
        if(root != null){
            System.out.print(root.data + "\t");
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
    }

    // TC: O(n) SC: O(n)
    private static void printInOrder(Node root) {
        if(root != null){
            printInOrder(root.left);
            System.out.print(root.data + "\t");
            printInOrder(root.right);
        }
    }

    // TC: O(n) SC: O(n)
    private static void printPostOrder(Node root) {
        if(root != null){
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.print(root.data + "\t");
        }
    }

}
