package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 *
 * In Circular Doubly linked list,
 * doesn't contain NULL in any of the node.
 * The last node of the list contains the address of the first node of the list.
 * The first node of the list also contain address of the last node in its previous pointer.
 */
public class CircularDoublyLinkedList<T> {
    Node head;
    Node tail;

    public CircularDoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addLast(T data) {
        //TODO
    }

    public void delete(T val){
        //TODO
    }

    private static void printCircularLinkedList(Node head) {
        //TODO
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList<Integer> cll = new CircularDoublyLinkedList<>();
        System.out.println("Printing Circular Doubly linked list:");
        printCircularLinkedList(cll.head);
    }
}
