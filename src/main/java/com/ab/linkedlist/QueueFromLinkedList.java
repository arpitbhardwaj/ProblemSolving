package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 */
public class QueueFromLinkedList<T> {
    Node<T> front, rear;

    public QueueFromLinkedList() {
        this.front = this.rear = null;
    }

    public void enQueue(T item) {
        Node<T> node = new Node<>(item);
        if (rear == null){
            front = rear = node;
            return;
        }

        //add the node at the end of linked list
        rear.next = node;
        rear = node;
    }

    private void deQueue() {
        if (front == null){
            throw new IllegalStateException("Queue is Empty");
        }

        //remove the node from the head of linked list
        front = front.next;

        if(front == null){
            rear = null;
        }
    }

    public void display() {
        LinkedList.printLinkedList(front);
    }

    public static void main(String[] args) {
        QueueFromLinkedList<Integer> queue = new QueueFromLinkedList<>();
        queue.enQueue(12);
        queue.enQueue(14);
        queue.enQueue(25);
        queue.enQueue(9);

        queue.display();

        queue.deQueue();
        queue.deQueue();

        queue.display();
    }
}
