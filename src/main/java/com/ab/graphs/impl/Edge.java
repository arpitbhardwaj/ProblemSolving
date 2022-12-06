package com.ab.graphs.impl;

import java.util.Objects;

/**
 * @author Arpit Bhardwaj
 */
public class Edge<T> {
    public Vertex<T> vertex1;
    public Vertex<T> vertex2;
    public int weight;

    public Edge(Vertex vertex1, Vertex vertex2) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    public Edge(Vertex<T> vertex1, Vertex<T> vertex2, int weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
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
                "vertex1=" + vertex1 +
                ", vertex2=" + vertex2 +
                ", weight=" + weight +
                '}';
    }
}
