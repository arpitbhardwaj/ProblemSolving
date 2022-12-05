package com.ab.graphs.impl;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Arpit Bhardwaj
 */

public class GraphUsingAdjacencyList {

    public static void main(String[] args) {
        Graph graph = getIntegerConnectedGraph(false);
        System.out.println(graph);
    }

    public static Graph<Integer> getIntegerConnectedGraph(boolean isDirected) {
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

    public static Graph<Integer> getIntegerDisconnectedGraph(boolean isDirected) {
        Graph<Integer> graph = new Graph<>(isDirected);
        graph.addEdge(1, 2);
        graph.addEdge(1, 9);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(6, 5);
        graph.addEdge(5, 3);
        graph.addEdge(7, 8);
        return graph;
    }

    public static Graph<Character> getCharacterGraph(boolean isDirected) {
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

    public static Graph<Character> getAnotherCharacterGraph(boolean isDirected) {
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

    public static Graph<Integer> getAnotherIntegerGraph(boolean isDirected) {
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

    public static Graph<Integer> getCyclicGraph(boolean isDirected) {
        Graph<Integer> graph = new Graph<>(isDirected);
        graph.addEdge(0, 1);
        //graph.addEdge(0, 2);//makes cycle for undirected not for directed
        graph.addEdge(1, 2);
        //graph.addEdge(2, 0);//cycle
        graph.addEdge(2, 3);
        //graph.addEdge(0, 3);//makes cycle for undirected not for directed
        //graph.addEdge(3, 3);//cycle
        graph.addEdge(4, 5);
        //graph.addEdge(5, 4);//cycle
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
        return graph;
    }

    public static Graph<Integer> getWeightedSSSPIntGraph(boolean isDirected) {
        Graph<Integer> graph = new Graph<>(isDirected);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 2);
        graph.addEdge(1, 4, 9);
        graph.addEdge(1, 5, 3);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 4, 2);
        graph.addEdge(3, 4, 3);
        return graph;
    }

    public static Graph<Integer> getNegativeWeightedSSSPIntGraph(boolean isDirected) {
        Graph<Integer> graph = new Graph<>(isDirected);
        graph.addEdge(0, 3, 8);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 5);
        graph.addEdge(1, 2, -3);
        graph.addEdge(2, 4, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 3, 1);
        return graph;
    }

    public static class Graph<T> {

        private static final AtomicInteger count = new AtomicInteger(0);
        boolean isDirected = false;
        private List<Edge<T>> edgeList;
        private Map<Long, Vertex<T>> vertexMap;

        public Graph(boolean isDirected) {
            this.isDirected = isDirected;
            this.edgeList = new ArrayList<>();
            this.vertexMap = new HashMap<>();
        }

        public List<Edge<T>> getEdgeList() {
            return edgeList;
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

        public Collection<Vertex<T>> getAllVertex() {
            return vertexMap.values();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Collection<Vertex<T>> allVertex = getAllVertex();
            for (Vertex v : allVertex) {
                sb.append(v.getId() + ": ");
                List<Vertex> vertexList = v.getAdjacentVertexList();
                for (int i = 0; i < vertexList.size(); i++) {
                    if (i == vertexList.size()-1){
                        sb.append(vertexList.get(i).getId());
                    }else{
                        sb.append(vertexList.get(i).getId() + " -> ");
                    }
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }
}


