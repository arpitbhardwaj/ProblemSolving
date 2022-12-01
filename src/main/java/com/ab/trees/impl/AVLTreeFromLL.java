package com.ab.trees.impl;

/**
 * @author Arpit Bhardwaj
 *
 * An AVL tree is a self-balancing Binary Search Tree (BST) where the difference between heights of left and right
 * subtrees cannot be more than one for all nodes.
 *
 * If at any time heights of left and right subtrees differ by more than one, then rebalancing is done to restore
 * AVL property, this process is called rotation.
 */

public class AVLTreeFromLL {
    public static void main(String[] args) {
        AVLTree avl = getAVLTree();
        System.out.println(avl.root);

        System.out.println(avl.searchNode(15).data);
        avl.deleteNode(5);
        avl.deleteNode(30);
        avl.deleteNode(20);
        System.out.println(avl.root);

        avl.delete();
    }

    public static AVLTree getAVLTree(){
        AVLTree tree = new AVLTree();
        //this sequence of insertion run all conditions
        tree.insertNode(30);
        tree.insertNode(25);
        tree.insertNode(35);
        tree.insertNode(20);
        tree.insertNode(15);
        tree.insertNode(5);
        tree.insertNode(10);
        tree.insertNode(50);
        tree.insertNode(60);
        tree.insertNode(70);
        tree.insertNode(65);
        return tree;
    }

    public static class AVLTree {
        Node root;

        public AVLTree(){
            this.root = null;
        }

        private int getHeight(Node node){
            if (node == null){
                return 0;
            }
            return node.height;
        }

        //rotate right
        private Node rotateRight(Node disbalancedNode){
            Node newRoot = disbalancedNode.left;
            disbalancedNode.left = disbalancedNode.left.right;
            newRoot.right = disbalancedNode;
            disbalancedNode.height = 1+ Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
            newRoot.height = 1+ Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
            return newRoot;
        }

        //rotate left
        private Node rotateLeft(Node disbalancedNode){
            Node newRoot = disbalancedNode.right;
            disbalancedNode.right = disbalancedNode.right.left;
            newRoot.left = disbalancedNode;
            disbalancedNode.height = 1+ Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
            newRoot.height = 1+ Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
            return newRoot;
        }

        private int getBalance(Node node){
            if (node == null){
                return 0;
            }
            return getHeight(node.left) - getHeight(node.right);
        }

        void insertNode(int data) {
            root = insertNodeRecursiveUtil(root, data);
        }

        Node insertNodeRecursiveUtil(Node currentNode, int data) {
            if(currentNode == null){
                Node node = new Node(data);
                node.height = 1;
                return node;
            } else if(currentNode.data < data){
                currentNode.right = insertNodeRecursiveUtil(currentNode.right, data);
            } else{
                currentNode.left = insertNodeRecursiveUtil(currentNode.left, data);
            }

            currentNode.height = 1+ Math.max(getHeight(currentNode.left), getHeight(currentNode.right));
            int balance = getBalance(currentNode);

            //LL
            if (balance > 1 && data < currentNode.left.data){
                return rotateRight(currentNode);
            }

            //LR
            if (balance > 1 && data > currentNode.left.data){
                currentNode.left = rotateLeft(currentNode.left);
                return rotateRight(currentNode);
            }

            //RR
            if (balance < -1 && data > currentNode.right.data){
                return rotateLeft(currentNode);
            }

            //RL
            if (balance < -1 && data < currentNode.right.data){
                currentNode.right = rotateRight(currentNode.right);
                return rotateLeft(currentNode);
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

        /**
         * Rotation is not required
         *  Case 1: The node to be deleted is a leaf node
         *  Case 2: The node has one child
         *  Case 3: The node has two children
         *
         *  Rotation is required
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

            int balance = getBalance(currentNode);

            //LL
            if (balance > 1 && getBalance(currentNode.left) >= 0){
                return rotateRight(currentNode);
            }

            //LR
            if (balance > 1 && getBalance(currentNode.left) < 0){
                currentNode.left = rotateLeft(currentNode.left);
                return rotateRight(currentNode);
            }

            //RR
            if (balance < -1 && getBalance(currentNode.right) <= 0){
                return rotateLeft(currentNode);
            }

            //RL
            if (balance < -1 && getBalance(currentNode.right) > 0){
                currentNode.right = rotateRight(currentNode.right);
                return rotateLeft(currentNode);
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
