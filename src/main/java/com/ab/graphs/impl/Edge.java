package com.ab.graphs.impl;

import java.util.Objects;

/**
 * @author Arpit Bhardwaj
 */
public class Edge<T> {
    public Vertex<T> firstVertex;
    public Vertex<T> secondVertex;
    public int weight;

    public Edge(Vertex firstVertex, Vertex secondVertex) {
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
    }

    public Edge(Vertex<T> firstVertex, Vertex<T> secondVertex, int weight) {
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> edge = (Edge<?>) o;
        return Objects.equals(firstVertex, edge.firstVertex) &&
                Objects.equals(secondVertex, edge.secondVertex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstVertex, secondVertex);
    }

    @Override
    public String toString() {
        return "Edge (" + firstVertex + "," + secondVertex + "), weight=" + weight;
    }
}
