package com.ab.heap.impl;

import com.ab.utils.Utils;

public class BinaryHeapFromArray {
    public static void main(String[] args) {
        //BinaryHeap bh = new MaxBinaryHeap(6);
        BinaryHeap bh = new MinBinaryHeap(6);
        bh.insertNode(10);
        bh.insertNode(5);
        bh.insertNode(15);
        bh.insertNode(1);
        bh.insertNode(4);
        bh.insertNode(6);

        bh.levelOrder();
        System.out.println();

        System.out.println(bh.searchNode(15));
        bh.peek();
        //bh.extractHead();

        bh.levelOrder();
        System.out.println();

        bh.delete();
    }

    public abstract static class BinaryHeap{
        int arr[];
        int lastUsedIndex;

        public BinaryHeap(int size){
            this.arr = new int[size+1];
            this.lastUsedIndex = 0;
        }

        boolean isEmpty(){
            return lastUsedIndex == 0;
        }

        boolean isFull(){
            return lastUsedIndex == arr.length-1;
        }

        void levelOrder(){
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

        void insertNode(int data){
            if (!isFull()){
                lastUsedIndex++;
                arr[lastUsedIndex] = data;
                heapifyBottomToTop(lastUsedIndex);
            }
        }

        int peek(){
            if (isEmpty()){
                return -1;
            }else{
                return arr[1];
            }
        }

        int extractHead(){
            if (isEmpty()){
                return -1;
            }else{
                int extracted = arr[1];
                arr[1] = arr[lastUsedIndex];
                lastUsedIndex--;
                heapifyTopToBottom(1);
                return extracted;
            }
        }

        abstract void heapifyBottomToTop(int index);

        abstract void heapifyTopToBottom(int index);

        void delete(){
            arr = null;
        }
    }

    public static class MaxBinaryHeap extends BinaryHeap{

        public MaxBinaryHeap(int size) {
            super(size);
        }

        void heapifyBottomToTop(int index){
            if (index <= 1){
                return;
            }
            int parent = index / 2;
            if (arr[index] > arr[parent]){
                Utils.swapArrayElements(arr, index, parent);
            }
            heapifyBottomToTop(parent);
        }

        void heapifyTopToBottom(int index){
            //TODO
        }
    }

    public static class MinBinaryHeap extends BinaryHeap{

        public MinBinaryHeap(int size) {
            super(size);
        }

        void heapifyBottomToTop(int index){
            if (index <= 1){
                return;
            }
            int parent = index / 2;
            if (arr[index] < arr[parent]){
                Utils.swapArrayElements(arr, index, parent);
            }
            heapifyBottomToTop(parent);
        }

        void heapifyTopToBottom(int index){
            //TODO
        }
    }
}
