package com.ab.graphs;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Arpit Bhardwaj
 */
public class Graph<T> {
    private static final AtomicInteger count = new AtomicInteger(0);
    boolean isDirected = false;
    private List<Edge<T>> edgeList;
    private Map<Long, Vertex<T>> vertexMap;

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
        this.edgeList = new ArrayList<>();
        this.vertexMap = new HashMap<>();
    }

    public static Graph<Integer> getSampleIntegerConnGraph(boolean isDirected) {
        Graph<Integer> graph = new Graph<>(isDirected);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(6, 5);
        graph.addEdge(5, 3);
        return graph;
    }

    public static Graph<Integer> getSampleIntegerDisConnGraph(boolean isDirected) {
        Graph<Integer> graph = new Graph<>(isDirected);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(6, 5);
        graph.addEdge(5, 3);
        graph.addEdge(7, 8);
        return graph;
    }

    public static Graph<Character> getSampleCharGraph(boolean isDirected) {
        Graph<Character> graph = new Graph<>(isDirected);
        graph.addEdge('a', 'b');
        graph.addEdge('a', 'c');
        graph.addEdge('b', 'd');
        graph.addEdge('c', 'd');
        graph.addEdge('d', 'f');
        graph.addEdge('f', 'e');
        graph.addEdge('e', 'c');
        return graph;
    }

    public static Graph<Character> getAnotherSampleCharGraph(boolean isDirected) {
        Graph<Character> graph = new Graph<>(isDirected);
        graph.addEdge('a', 'c');
        graph.addEdge('b', 'c');
        graph.addEdge('b', 'd');
        graph.addEdge('c', 'e');
        graph.addEdge('d', 'f');
        graph.addEdge('e', 'h');
        graph.addEdge('e', 'f');
        graph.addEdge('f', 'g');
        return graph;
    }

    public static Graph<Integer> getAnotherSampleIntGraph(boolean isDirected) {
        Graph<Integer> graph = new Graph<>(isDirected);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 8);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        return graph;
    }

    public static Graph<Integer> getWeightedSampleIntGraph(boolean isDirected) {
        Graph<Integer> graph = new Graph<>(isDirected);

        graph.addEdge(0, 1, 4);
        graph.addEdge(1, 2, 8);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 9);
        graph.addEdge(4, 5, 10);
        graph.addEdge(2, 5, 4);
        graph.addEdge(1, 7, 11);
        graph.addEdge(0, 7, 8);
        graph.addEdge(2, 8, 2);
        graph.addEdge(3, 5, 14);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 8, 6);
        graph.addEdge(6, 7, 1);
        graph.addEdge(7, 8, 7);

        /*graph.addEdge(1, 2, 3);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 1, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 4, 3);
        graph.addEdge(4, 5, 6);
        graph.addEdge(5, 6, 2);
        graph.addEdge(3, 5, 5);
        graph.addEdge(3, 6, 4);*/
        return graph;
    }

    public List<Edge<T>> getEdgeList() {
        return edgeList;
    }

    public Map<Long, Vertex<T>> getVertexMap() {
        return vertexMap;
    }

    public void addEdge(long id1, long id2){
        addEdge(id1, id2, 0);
    }

    
    private void addEdge(long id1, long id2, int weight) {
        Vertex<T> vertex1 = null;
        if(vertexMap.containsKey(id1)){
            vertex1 = vertexMap.get(id1);
        }else{
            vertex1 = new Vertex<>(id1);
            vertexMap.put(id1,vertex1);
        }

        Vertex<T> vertex2 = null;
        if(vertexMap.containsKey(id2)){
            vertex2 = vertexMap.get(id2);
        }else{
            vertex2 = new Vertex<>(id2);
            vertexMap.put(id2,vertex2);
        }

        Edge<T> edge = new Edge<>(isDirected,vertex1,vertex2,weight);

        edgeList.add(edge);
        vertex1.addAdjacentVertex(edge,vertex2);
        if(!isDirected){
            vertex2.addAdjacentVertex(edge,vertex1);
        }
    }

    public void addEdge(T data1, T data2){
        addEdge(data1, data2, 0);
    }

    private void addEdge(T data1, T data2, int weight) {
        /*Vertex<T> vertex1 = null;
        if(vertexMap.containsValue(id1)){
            vertex1 = vertexMap.get(id1);
        }else{
            final long vertexId = count.incrementAndGet();
            vertex1 = new Vertex<>(vertexId,data1);
            vertexMap.put(vertexId,vertex1);
        }

        Vertex<T> vertex2 = null;
        if(vertexMap.containsKey(id2)){
            vertex2 = vertexMap.get(id2);
        }else{
            final long vertexId = count.incrementAndGet();
            vertex2 = new Vertex<>(vertexId,data2);
            vertexMap.put(vertexId,vertex2);
        }

        Edge<T> edge = new Edge<>(isDirected,vertex1,vertex2,weight);

        edgeList.add(edge);
        vertex1.addAdjacentVertex(edge,vertex2);
        if(!isDirected){
            vertex2.addAdjacentVertex(edge,vertex1);
        }*/
    }

    public Collection<Vertex<T>> getAllVertex() {
       return vertexMap.values();
    }

    public void setDataForVertex(long id, T data){
        if (vertexMap.containsKey(id)){
            Vertex<T> vertex = vertexMap.get(id);
            vertex.setData(data);
        }
    }
}
