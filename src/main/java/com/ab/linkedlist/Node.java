package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 */
public class Node<T> {
    T data;
    Node next;
    Node before;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.before = null;
    }
}
