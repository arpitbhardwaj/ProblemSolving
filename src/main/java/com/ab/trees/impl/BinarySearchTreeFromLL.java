package com.ab.trees.impl;

public class BinarySearchTreeFromLL {

    public static void main(String[] args) {
        BinarySearchTree bst = getBinarySearchTree();
        System.out.println(bst.root);

        BinarySearchTree bst2 = getAnotherBinarySearchTree();
        System.out.println(bst2.root);


        System.out.println(bst.searchNode(19).data);
        System.out.println(bst.root);

        bst.deleteNode(19);
        System.out.println(bst.root);

        bst.delete();
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
        return tree;
    }

    public static BinarySearchTree getAnotherBinarySearchTree(){
        BinarySearchTree tree = new BinarySearchTree();
        //this sequence of insertion run all conditions
        tree.insertNodeRecursive(30);
        tree.insertNodeRecursive(25);
        tree.insertNodeRecursive(35);
        tree.insertNodeRecursive(20);
        tree.insertNodeRecursive(15);
        tree.insertNodeRecursive(5);
        tree.insertNodeRecursive(10);
        tree.insertNodeRecursive(50);
        tree.insertNodeRecursive(60);
        tree.insertNodeRecursive(70);
        tree.insertNodeRecursive(65);
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
            root = insertNodeRecursiveUtil(root, data);
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
            if (currentNode == null){
                return null;
            } else if (currentNode.data == data){
                return currentNode;
            } else if (currentNode.data < data){
                return searchNodeUtil(currentNode.right, data);
            } else {
                return searchNodeUtil(currentNode.left, data);
            }
        }

        /**
         * Case 1: The node to be deleted is a leaf node
         * Case 2: The node has one child
         * Case 3: The node has two children
         */
        void deleteNode(int data){
            deleteNodeUtil(root, data);
        }

        Node deleteNodeUtil(Node currentNode, int data){
            if(currentNode == null){
                return null;
            } else if (currentNode.data < data){
                currentNode.right = deleteNodeUtil(currentNode.right, data);
            } else if (currentNode.data > data){
                currentNode.left = deleteNodeUtil(currentNode.left, data);
            } else{
                //case 1
                if (currentNode.left != null && currentNode.right != null){
                    Node minNodeRight = getMinimumNode(currentNode.right);
                    currentNode.data = minNodeRight.data;
                    currentNode.right = deleteNodeUtil(currentNode.right, minNodeRight.data);
                }
                //case 2
                else if (currentNode.left != null) {
                    currentNode = currentNode.left;
                }
                //case 2
                else if (currentNode.right != null) {
                    currentNode = currentNode.right;
                }
                //case 3
                else {
                    currentNode = null;
                }
            }
            return currentNode;
        }

        Node getMinimumNode(Node currentNode){
            if (currentNode.left == null){
                return currentNode;
            }
            return getMinimumNode(currentNode.left);
        }

        void delete(){
            root = null;
        }

    }
}
