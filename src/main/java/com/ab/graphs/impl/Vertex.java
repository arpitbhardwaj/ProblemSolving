package com.ab.graphs.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Arpit Bhardwaj
 */
public class Vertex<T> {
    public int id;                                        //consider id as index if using vertexList and id if using vertexMap
    public T name;
    public List<Edge<T>> adjacentEdges = new ArrayList<>();         //used in prim impl
    public List<Vertex<T>> adjacentVertices = new ArrayList<>();    //used in adjacencyList impl
    public boolean isVisited = false;                               //used in bfs, dfs
    public Vertex<T> parent;

    public Vertex(int id, T name) {
        this.id = id;
        this.name = name;
    }

    public void addAdjacentVertex(Edge<T> edge, Vertex<T> vertex2) {
        adjacentEdges.add(edge);
        adjacentVertices.add(vertex2);
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
        int id = vertex.id;
        T data = vertex.name;

        vertex.id = this.id;
        vertex.name = this.name;

        this.id = id;
        this.name = data;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                '}';
    }
}
