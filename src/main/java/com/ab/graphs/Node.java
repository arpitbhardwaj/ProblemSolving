package com.ab.graphs;

/**
 * @author Arpit Bhardwaj
 */
public class Node<T> {
    T key;
    int weight;

    public Node(T key, int weight) {
        this.key = key;
        this.weight = weight;
    }

    public T getKey() {
        return key;
    }

    public int getWeight() {
        return weight;
    }

    public void swap(Node<T> node) {
        int weight = node.weight;
        T key = node.key;

        node.weight = this.weight;
        node.key = this.key;

        this.weight = weight;
        this.key = key;
    }

}
