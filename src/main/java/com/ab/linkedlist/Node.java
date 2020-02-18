package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 */
public class Node<T> {
    public T data;
    public Node next;
    public Node before;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.before = null;
    }
}
