package com.ab.graphs.impl;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 */
public class Vertex<T> implements Comparable<Vertex<T>> {
    public int index;                                        //consider id as index if using vertexList and id if using vertexMap
    public T name;
    public List<Edge<T>> adjacentEdges = new ArrayList<>();         //used in prim impl
    public List<Vertex<T>> adjacentVertices = new ArrayList<>();    //used in adjacencyList impl
    public boolean isVisited = false;                               //used in bfs, dfs
    public Vertex<T> parent;                                        //used in bfs(sssp)
    public int distance;
    public Map<Vertex<T>/*adjacent vertex to this vertex*/, Integer> weightMap = new HashMap<>();

    public Vertex(int index, T name) {
        this.index = index;
        this.name = name;
        this.distance = Integer.MAX_VALUE;
    }

    public void addAdjacentVertex(Edge<T> edge, Vertex<T> vertex) {
        adjacentEdges.add(edge);
        adjacentVertices.add(vertex);
        weightMap.put(vertex, edge.weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return index == vertex.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }

    public void swap(Vertex<T> vertex) {
        int id = vertex.index;
        T data = vertex.name;

        vertex.index = this.index;
        vertex.name = this.name;

        this.index = id;
        this.name = data;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name=" + name +
                '}';
    }

    @Override
    public int compareTo(Vertex<T> v) {
        return this.distance - v.distance;
    }
}
