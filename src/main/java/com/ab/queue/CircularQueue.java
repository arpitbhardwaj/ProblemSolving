package com.ab.queue;

import com.ab.linkedlist.Node;

/**
 * @author Arpit Bhardwaj
 */
public class CircularQueue<T> {

    Node<T> front,rear;

    public CircularQueue() {
        this.front = null;
        this.rear = null;
    }

    public static void main(String[] args) {
        CircularQueue<Integer> circularQueue = new CircularQueue<>();
        circularQueue.enQueue(78);
        circularQueue.enQueue(9);
        circularQueue.enQueue(1);

        circularQueue.deQueue();

        circularQueue.enQueue(4);
        circularQueue.enQueue(2);

        circularQueue.deQueue();

        circularQueue.printCircularQueue();
    }

    public void printCircularQueue() {
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


}
