package com.ab.trees.impl;

public class BinarySearchTreeFromLL {

    public static void main(String[] args) {
        BinarySearchTree bst = getBinarySearchTree();
        System.out.println(bst.root);
    }

    public static BinarySearchTree getBinarySearchTree(){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertNode(10);
        tree.insertNode(15);
        tree.insertNode(14);
        tree.insertNode(5);
        tree.insertNode(7);
        tree.insertNode(19);
        tree.insertNode(18);
        tree.insertNode(20);
        tree.insertNode(-1);
        tree.insertNode(21);
        return tree;
    }

    public static class BinarySearchTree {
        public Node root;

        public BinarySearchTree(){
            this.root = null;
        }

        public void insertNode(int data) {
            Node node = new Node(data);
            if(root == null){
                root = node;
                return;
            }
            Node previous = null;
            Node temp = root;
            while(temp != null){
                previous = temp;
                if(temp.data < data){
                    temp = temp.right;
                }else{
                    temp = temp.left;
                }
            }
            if(previous.data < data){
                previous.right = node;
            }else{
                previous.left = node;
            }
        }

    }
}
