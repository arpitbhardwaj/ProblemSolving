package com.ab.trees.impl;

public class BinaryTreeFromArray {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(6);
        bt.insertNode(3);
        bt.insertNode(4);
        bt.insertNode(2);
        bt.insertNode(1);
        bt.insertNode(7);
        bt.insertNode(8);

        bt.preOrder(1);
        System.out.println();
        bt.inOrder(1);
        System.out.println();
        bt.postOrder(1);
        System.out.println();
        bt.levelOrder(1);
        System.out.println();

        System.out.println(bt.searchNode(7));
        bt.deleteNode(1);

        bt.levelOrder(1);
        System.out.println();

        bt.delete();
    }

    public static class BinaryTree{
        int arr[];
        int lastUsedIndex;
        public BinaryTree(int size){
            this.arr = new int[size+1];
            this.lastUsedIndex = 0;
        }

        boolean isFull(){
            return lastUsedIndex == arr.length-1;
        }

        void insertNode(int data){
            if (!isFull()){
                lastUsedIndex++;
                arr[lastUsedIndex] = data;
            }
        }

        void preOrder(int index){
            if (index > lastUsedIndex){
                return;
            }
            System.out.print(arr[index] + "\t");
            preOrder(2*index);
            preOrder(2*index + 1);
        }

        void inOrder(int index){
            if (index > lastUsedIndex){
                return;
            }
            inOrder(2*index);
            System.out.print(arr[index] + "\t");
            inOrder(2*index + 1);
        }

        void postOrder(int index){
            if (index > lastUsedIndex){
                return;
            }
            postOrder(2*index);
            postOrder(2*index + 1);
            System.out.print(arr[index] + "\t");
        }

        void levelOrder(int index){
            for (int i = 1; i <= lastUsedIndex; i++) {
                System.out.print(arr[i] + "\t");
            }
        }

        int searchNode(int data){
            for (int i = 1; i <= lastUsedIndex; i++) {
                if (arr[i] == data){
                    return i;
                }
            }
            return -1;
        }

        void deleteNode(int data){
            int location = searchNode(data);
            if (location == -1){
                return;
            }else{
                arr[location] = arr[lastUsedIndex];
                lastUsedIndex--;
            }
        }

        void delete(){
            arr = null;
        }
    }
}
