package com.ab.disjoint;

/**
 * @author Arpit Bhardwaj
 */
public class Node<T> {
    T data;
    Node parent;
    int rank;

    public Node(T data) {
        this.data = data;
        this.parent = this;
        this.rank = 0;
    }
}
