package com.ab.queue.impl;

import java.util.Arrays;

public class CircularQueueFromArray {
    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue(4);
        queue.enQueue(11);
        queue.enQueue(20);
        queue.enQueue(3);
        queue.printQueue();

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        queue.enQueue(23);
        queue.enQueue(12);
        queue.printQueue();

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        queue.enQueue(34);
        queue.printQueue();

        System.out.println(queue.peek());
        queue.delete();
        queue.printQueue();
    }

    private static class CustomQueue {
        int arr[];
        int beginningOfQueue;
        int topOfQueue;

        public CustomQueue(int size) {
            this.arr = new int[size];
            this.beginningOfQueue = -1;
            this.topOfQueue = -1;
        }

        public boolean isEmpty(){
            return beginningOfQueue == -1 || topOfQueue == -1;
        }

        public boolean isFull(){
            return (topOfQueue+1 == beginningOfQueue || (beginningOfQueue == 0 && topOfQueue+1 == arr.length));
        }

        public void enQueue(int data) {
            if (isEmpty()){
                beginningOfQueue = 0;
                topOfQueue++;
                arr[topOfQueue] = data;
            }
            else if (!isFull()){
                if (topOfQueue+1 == arr.length) {
                    topOfQueue = 0;
                } else {
                    topOfQueue++;
                }
                arr[topOfQueue] = data;
            }
        }

        public int deQueue() {
            if (!isEmpty()){
                int ele = arr[beginningOfQueue];
                arr[beginningOfQueue++] = 0;
                if (beginningOfQueue > topOfQueue){
                    beginningOfQueue = topOfQueue = -1;
                }else if (beginningOfQueue == arr.length){
                    beginningOfQueue = 0;
                }
                return ele;
            }
            return -1;
        }

        public int peek() {
            if (!isEmpty()){
                return arr[beginningOfQueue];
            }
            return -1;
        }

        public void delete() {
            arr = null;
        }

        public void printQueue(){
            System.out.println(Arrays.toString(arr));
        }
    }
}
