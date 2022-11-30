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
        tree.insertNode(21);
        tree.insertNodeRecursive(6);
        System.out.println(tree.searchNode(19).data);
        tree.delete();
        return tree;
    }

    public static class BinarySearchTree {
        public Node root;

        public BinarySearchTree(){
            this.root = null;
        }

        void insertNode(int data) {
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

        void insertNodeRecursive(int data) {
            insertNodeRecursiveUtil(root, data);
        }

        Node insertNodeRecursiveUtil(Node currentNode, int data) {
            if(currentNode == null){
                Node node = new Node(data);
                currentNode = node;
            } else if(currentNode.data < data){
                currentNode.right = insertNodeRecursiveUtil(currentNode.right, data);
            } else{
                currentNode.left = insertNodeRecursiveUtil(currentNode.left, data);
            }
            return currentNode;
        }

        Node searchNode(int data){
            return searchNodeUtil(root, data);
        }

        Node searchNodeUtil(Node currentNode, int data){
            if(currentNode == null){
                return null;
            } else if(currentNode.data == data){
                return currentNode;
            } else if(currentNode.data < data){
                return searchNodeUtil(currentNode.right, data);
            } else{
                return searchNodeUtil(currentNode.left, data);
            }
        }

        void deleteNode(int data){
            //TODO
        }

        void delete(){
            root = null;
        }

    }
}
