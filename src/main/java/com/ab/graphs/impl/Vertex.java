package com.ab.graphs.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Arpit Bhardwaj
 */
public class Vertex<T> {
    long id;                                                        //for consider id as index also
    private T data;
    private List<Edge<T>> edgeList = new ArrayList<>();
    private List<Vertex<T>> adjacentVertexList = new ArrayList<>(); //for adjacencyList impl

    public Vertex(long id) {
        this.id = id;
    }

    public Vertex(long id, T data) {
        this.id = id;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public List<Edge<T>> getEdgeList() {
        return edgeList;
    }

    public List<Vertex<T>> getAdjacentVertexList() {
        return adjacentVertexList;
    }

    public void addAdjacentVertex(Edge<T> edge, Vertex<T> vertex2) {
        edgeList.add(edge);
        adjacentVertexList.add(vertex2);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return id == vertex.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void swap(Vertex<T> vertex) {
        long id = vertex.id;
        T data = vertex.data;

        vertex.id = this.id;
        vertex.data = this.data;

        this.id = id;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                '}';
    }
}
