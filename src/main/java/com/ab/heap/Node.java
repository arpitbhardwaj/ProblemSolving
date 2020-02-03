package com.ab.heap;

/**
 * @author Arpit Bhardwaj
 */
public class Node<T> {
    T data;
    int weight;

    public Node(T data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public T getData() {
        return data;
    }

    public int getWeight() {
        return weight;
    }

    public void swap(Node<T> node) {
        int weight = node.weight;
        T data = node.data;

        node.weight = this.weight;
        node.data = this.data;

        this.weight = weight;
        this.data = data;
    }
}
