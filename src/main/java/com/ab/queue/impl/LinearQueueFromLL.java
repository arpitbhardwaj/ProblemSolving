package com.ab.queue.impl;

import java.util.LinkedList;

public class LinearQueueFromLL {
    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue();
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

    private static class CustomQueue<T> {
        LinkedList<T> ll;

        public CustomQueue() {
            this.ll = new LinkedList<>();
        }

        public boolean isEmpty(){
            return ll.isEmpty();
        }

        public void isFull(){
            //TODO
        }

        public void enQueue(T data) {
            ll.offerLast(data);
        }

        public T deQueue() {
            return ll.pollFirst();
        }

        public T peek() {
            return ll.peekFirst();
        }

        public void delete() {
            ll.clear();
        }

        public void printQueue(){
            for (T item : ll) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
