package com.ab.graphs.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Arpit Bhardwaj
 */
public class Vertex<T> {
    int id;                                        //consider id as index if using vertexList and id if using vertexMap
    private T data;
    private List<Edge<T>> edgeList = new ArrayList<>();             //used in prim impl
    private List<Vertex<T>> adjacentVertexList = new ArrayList<>(); //used in adjacencyList impl
    private boolean isVisited;                                      //used in bfs, dfs

    public Vertex(int id, T data) {
        this.id = id;
        this.data = data;
        this.isVisited = false;
    }

    public int getId() {
        return id;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
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
        int id = vertex.id;
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
