package com.ab.graphs.impl;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Arpit Bhardwaj
 */

public class GraphUsingAdjacencyList {

    public static void main(String[] args) {
        Graph g1 = getIntegerConnectedGraph(false);
        System.out.println(g1);
        Graph g2 = getIntegerDisconnectedGraph(false);
        System.out.println(g2);
        Graph g4 = getGraphForTopological(true);
        System.out.println(g4);
        Graph g5 = getCyclicGraph(false);
        System.out.println(g5);
        Graph g6 = getWeightedIntegerGraph(false);
        System.out.println(g6);
    }

    public static class Graph<T> {

        private static final AtomicInteger count = new AtomicInteger(0);
        boolean isDirected = false;
        private List<Edge<T>> edgeList;
        //private Map<Integer, Vertex<T>> vertexMap;
        private List<Vertex<T>> vertexList;

        public Graph(List<Vertex<T>> vertexList, boolean isDirected) {
            this.isDirected = isDirected;
            this.vertexList = vertexList;
            this.edgeList = new ArrayList<>();
        }

        public List<Edge<T>> getEdgeList() {
            return edgeList;
        }

        public List<Vertex<T>> getVertexList() {
            return vertexList;
        }

        public void addEdge(int id1, int id2){
            addEdge(id1, id2, 0);
        }

        private void addEdge(int id1, int id2, int weight) {
            Vertex vertex1 = vertexList.get(id1);
            Vertex vertex2 = vertexList.get(id2);
            Edge<T> edge = new Edge<>(isDirected,vertex1,vertex2,weight);

            edgeList.add(edge);
            vertex1.addAdjacentVertex(edge,vertex2);
            if(!isDirected){
                vertex2.addAdjacentVertex(edge,vertex1);
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Vertex v : vertexList) {
                sb.append(v.getData() + ": ");
                List<Vertex> adjacentVertexList = v.getAdjacentVertexList();
                for (int i = 0; i < adjacentVertexList.size(); i++) {
                    if (i == adjacentVertexList.size()-1){
                        sb.append(adjacentVertexList.get(i).getData());
                    }else{
                        sb.append(adjacentVertexList.get(i).getData() + " -> ");
                    }
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }

    public static Graph<Integer> getIntegerConnectedGraph(boolean isDirected) {
        List<Vertex<Integer>> vertexList = new ArrayList<>();
        vertexList.add(new Vertex(0,1));
        vertexList.add(new Vertex(1,2));
        vertexList.add(new Vertex(2,3));
        vertexList.add(new Vertex(3,4));
        vertexList.add(new Vertex(4,5));
        vertexList.add(new Vertex(5,6));

        Graph<Integer> graph = new Graph<>(vertexList, isDirected);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(5, 4);
        graph.addEdge(4, 2);
        return graph;
    }

    public static Graph<Integer> getIntegerDisconnectedGraph(boolean isDirected) {
        List<Vertex<Integer>> vertexList = new ArrayList<>();
        vertexList.add(new Vertex(0,1));
        vertexList.add(new Vertex(1,2));
        vertexList.add(new Vertex(2,3));
        vertexList.add(new Vertex(3,4));
        vertexList.add(new Vertex(4,5));
        vertexList.add(new Vertex(5,6));
        vertexList.add(new Vertex(6,7));
        vertexList.add(new Vertex(7,8));
        vertexList.add(new Vertex(8,9));

        Graph<Integer> graph = new Graph<>(vertexList, isDirected);
        graph.addEdge(0, 1);
        graph.addEdge(0, 8);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(5, 4);
        graph.addEdge(4, 2);
        graph.addEdge(6, 7);
        return graph;
    }

    public static Graph<Character> getGraphForTopological(boolean isDirected) {
        List<Vertex<Character>> vertexList = new ArrayList<>();
        vertexList.add(new Vertex(0,'A'));
        vertexList.add(new Vertex(1,'B'));
        vertexList.add(new Vertex(2,'C'));
        vertexList.add(new Vertex(3,'D'));
        vertexList.add(new Vertex(4,'E'));
        vertexList.add(new Vertex(5,'F'));
        vertexList.add(new Vertex(6,'G'));
        vertexList.add(new Vertex(7,'H'));

        Graph<Character> graph = new Graph<>(vertexList, isDirected);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 7);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        return graph;
    }

    public static Graph<Integer> getCyclicGraph(boolean isDirected) {
        List<Vertex<Integer>> vertexList = new ArrayList<>();
        vertexList.add(new Vertex(0,1));
        vertexList.add(new Vertex(1,2));
        vertexList.add(new Vertex(2,3));
        vertexList.add(new Vertex(3,4));
        vertexList.add(new Vertex(4,5));
        vertexList.add(new Vertex(5,6));

        Graph<Integer> graph = new Graph<>(vertexList, isDirected);
        graph.addEdge(0, 1);
        //graph.addEdge(0, 2);//makes cycle for undirected
        graph.addEdge(1, 2);
        //graph.addEdge(2, 0);//make cycle for both
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        return graph;
    }

    public static Graph<Integer> getWeightedIntegerGraph(boolean isDirected) {
        List<Vertex<Integer>> vertexList = new ArrayList<>();
        vertexList.add(new Vertex(0,1));
        vertexList.add(new Vertex(1,2));
        vertexList.add(new Vertex(2,3));
        vertexList.add(new Vertex(3,4));
        vertexList.add(new Vertex(4,5));
        vertexList.add(new Vertex(5,6));
        vertexList.add(new Vertex(6,7));
        vertexList.add(new Vertex(7,8));
        vertexList.add(new Vertex(8,9));

        Graph<Integer> graph = new Graph<>(vertexList, isDirected);
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
}


