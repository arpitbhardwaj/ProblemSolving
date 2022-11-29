package com.ab.trees.impl;

/**
 * @author Arpit Bhardwaj
 *
 *  Binary Tree         : is tree where every node has 0,1 or max 2 childs
 *  Complete Binary Tree: is a BT in which every level, except possibly the last, is completely filled,
 *                        and all nodes are as far left as possible.
 *  Full Binary Tree    : sometimes called proper BT or 2-tree is a tree in which every node other than the leaves
 *                        has two children.
 *  Perfect Binary Tree: in which all non leaf node that are located at the same depth should have 2 childrens.
 *                        and the leaf nodes should not have any children
 *  Balanced Binary Tree: all leaf nodes should be located at the same distance from root node.
 *  Binary Search Tree  : is a BT with additional constraints that left child is less than parent and right
 *                        child is greater than parent and this should be recursively true for all nodes
 */
public class BinaryTreeFromLL {

    public static class BinaryTree{
        public Node root;

        public BinaryTree(){
            this.root = null;
        }
    }

    public static BinaryTree getBinaryTree(){
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

    public static BinaryTree getLeftSkewedBinaryTree(){
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.left.left = new Node(4);
        tree.root.left.left.left = new Node(6);
        return tree;
    }

    public static BinaryTree getRightSkewedBinaryTree(){
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.right = new Node(2);
        tree.root.right.right = new Node(4);
        tree.root.right.right.right = new Node(6);
        return tree;
    }

    public static void main(String[] args) {
        BinaryTree bt = getBinaryTree();
        BinaryTree lsbt = getLeftSkewedBinaryTree();
        BinaryTree rsbt = getRightSkewedBinaryTree();
        System.out.println(bt.root);
        System.out.println(lsbt.root);
        System.out.println(rsbt.root);
    }

}
