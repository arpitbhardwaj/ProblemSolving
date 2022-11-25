package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 *
 * Doesn't contain NULL in any of the node.
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

    public void addFirst(T data) {
        //TODO
    }

    public void add(T data) {
        //TODO
    }

    public void addLast(T data) {
        //TODO
    }

    public void deleteFirst(T val){
        //TODO
    }

    public void delete(T val){
        //TODO
    }

    public void deleteLast(T val){
        //TODO
    }

    private static void printCircularDoublyLinkedList(Node head) {
        //TODO
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList<Integer> cll = new CircularDoublyLinkedList<>();
        printCircularDoublyLinkedList(cll.head);
    }
}
