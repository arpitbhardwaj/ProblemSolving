package com.ab.graphs.impl;

import java.util.Objects;

/**
 * @author Arpit Bhardwaj
 */
public class Edge<T> {
    private boolean isDirected = false;
    private Vertex<T> vertex1;
    private Vertex<T> vertex2;
    private int weight;

    public Edge(Vertex<T> vertex1, Vertex<T> vertex2) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    public Edge(boolean isDirected, Vertex<T> vertex1, Vertex<T> vertex2) {
        this.isDirected = isDirected;
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    public Edge(boolean isDirected, Vertex<T> vertex1, Vertex<T> vertex2, int weight) {
        this.isDirected = isDirected;
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public Vertex<T> getVertex1() {
        return vertex1;
    }

    public Vertex<T> getVertex2() {
        return vertex2;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> edge = (Edge<?>) o;
        return Objects.equals(vertex1, edge.vertex1) &&
                Objects.equals(vertex2, edge.vertex2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertex1, vertex2);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "isDirected=" + isDirected +
                ", vertex1=" + vertex1 +
                ", vertex2=" + vertex2 +
                ", weight=" + weight +
                '}';
    }
}
