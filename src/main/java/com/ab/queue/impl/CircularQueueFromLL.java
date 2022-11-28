package com.ab.queue.impl;

import com.ab.linkedlist.impl.Node;

/**
 * @author Arpit Bhardwaj
 */
public class CircularQueueFromLL<T> {

    public static void main(String[] args) {
        CustomQueue<Integer> queue = new CustomQueue<>();
        queue.enQueue(78);
        queue.enQueue(9);
        queue.enQueue(1);

        queue.deQueue();

        queue.enQueue(4);
        queue.enQueue(2);

        queue.deQueue();

        queue.printQueue();
    }

    public static class CustomQueue<T> {
        public Node<T> front,rear;

        public CustomQueue() {
            this.front = null;
            this.rear = null;
        }

        public void enQueue(T data) {
            Node<T> node = new Node(data);
            if (this.front == null){
                this.front = node;
            }else{
                this.rear.next = node;
            }
            this.rear = node;
            this.rear.next = this.front;
        }

        public T deQueue() {
            if (this.front == null){
                throw new IllegalStateException("Queue is Empty");
            }
            T data;
            if (this.front == this.rear){
                data = this.front.data;
                this.front = null;
                this.rear = null;
            }
            else{
                data = this.front.data;
                this.front = this.front.next;
                this.rear.next = this.front;
            }
            return data;
        }

        public void printQueue() {
            if (this.front == null){
                throw new IllegalStateException("Queue is Empty");
            }
            Node current = this.front;
            System.out.println("Printing Circular Queue");
            do {
                System.out.print(current.data + " ");
                current = current.next;
            }while (current != this.front);

            System.out.println();
        }

    }


}
