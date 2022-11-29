package com.ab.trees.impl;

import java.util.LinkedList;
import java.util.Queue;

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

    public static class BinaryTree {
        public Node root;
        public BinaryTree(){
            this.root = null;
        }

        Node searchNode(int data){
            if(root == null){
                return null;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                Node node = queue.poll();
                if (node.data == data){
                    return node;
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            return null;
        }

        /**
         * Step1: A root node is null
         * Step2: The tree exists and we have to look for a first vacant place
         *
         */
        void insertNode(int data){
            if(root == null){
                return;
            }
            Node newNode = new Node(data);
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                Node node = queue.poll();
                if (node.left == null){
                    node.left = newNode;
                    return;
                } else if (node.right == null) {
                    node.right = newNode;
                    return;
                } else {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }

        /**
         * Step 1 - Find the Node
         * Step 2 - Find Deepest Node
         * Step 3 - Set Deepest Node’s value to Current Node
         * Step 4 - Delete Deepest Node
         */
        void deleteNode(int data){
            if(root == null){
                return;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                Node node = queue.poll();
                if (node.data == data){
                    node.data = getDeepestNode().data;
                    deleteDeepestNode();
                    return;
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }

        private Node getDeepestNode(){
            if(root == null){
                return null;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            Node node = null;
            while (!queue.isEmpty()){
                node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            return node;
        }

        private void deleteDeepestNode(){
            if(root == null){
                return;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            Node node, previousNode = null;
            while (!queue.isEmpty()){
                node = queue.poll();
                previousNode = node;
                if (node.left == null){
                    previousNode.right = null;
                    return;
                } else if (node.right == null) {
                    node.left = null;
                    return;
                } else {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }

        void delete(){
            root = null;
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
        System.out.println(bt.root);

        Node node = bt.searchNode(5);
        System.out.println(node.data);
        bt.insertNode(10);
        System.out.println(bt.root);
        bt.deleteNode(3);
        System.out.println(bt.root);
        bt.delete();

        BinaryTree lsbt = getLeftSkewedBinaryTree();
        //System.out.println(lsbt.root);

        BinaryTree rsbt = getRightSkewedBinaryTree();
        //System.out.println(rsbt.root);
    }

}
