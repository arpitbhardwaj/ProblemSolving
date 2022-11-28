package com.ab.trees.impl;

/**
 * @author Arpit Bhardwaj
 *
 *  Binary Tree         : is tree where every node has 0,1 or max 2 childs
 *  Complete Binary Tree: is a BT in which every level, except possibly the last, is completely filled,
 *                        and all nodes are as far left as possible.
 *  Full Binary Tree    : sometimes called proper BT or 2-tree is a tree in which every node other than the leaves
 *                        has two children.
 *  Binary Search Tree  : is a BT with additional constraints that left child is less than parent and right
 *                        child is greater than parent and this should be recursively true for all nodes
 *
 */
public class BinaryTree {
    public Node root;

    public static BinaryTree getSampleBinaryTree(){
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        return tree;
    }

    public static BinaryTree getAnotherSampleBinaryTree(){
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        //tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        //tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(6);
        return tree;
    }


    public static BinaryTree getSampleBinarySearchTree(){
        BinaryTree binaryTree = new BinaryTree();
        Node head = null;
        head = binaryTree.insertNode(head,10);
        binaryTree.root = head;
        head = binaryTree.insertNode(head,15);
        head = binaryTree.insertNode(head,14);
        head = binaryTree.insertNode(head,5);
        head = binaryTree.insertNode(head,7);
        head = binaryTree.insertNode(head,19);
        head = binaryTree.insertNode(head,18);
        head = binaryTree.insertNode(head,20);
        head = binaryTree.insertNode(head,-1);
        head = binaryTree.insertNode(head,21);

        return binaryTree;
    }

    //insertion in Binary search tree
    public Node insertNode(Node root, int data) {
        Node tempRoot = root;
        Node node = new Node(data);
        if(root == null){
            root = node;
            return root;
        }
        Node previous = null;
        while(root != null){
            previous = root;
            if(root.data < data){
                root = root.right;
            }else{
                root = root.left;
            }
        }
        if(previous.data < data){
            previous.right = node;
        }else{
            previous.left = node;
        }
        return tempRoot;
    }

}
