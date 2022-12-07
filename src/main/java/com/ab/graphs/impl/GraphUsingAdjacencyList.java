package com.ab.graphs.impl;

import java.util.*;

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
        boolean isDirected;
        private List<Edge<T>> edges;
        private List<Vertex<T>> vertices;

        public Graph(List<Vertex<T>> vertices, boolean isDirected) {
            this.isDirected = isDirected;
            this.vertices = vertices;
            this.edges = new ArrayList<>();
        }

        public List<Edge<T>> getEdges() { return edges; }

        public List<Vertex<T>> getVertices() {
            return vertices;
        }

        public void addEdge(int index1, int index2){
            Vertex vertex1 = vertices.get(index1);
            Vertex vertex2 = vertices.get(index2);
            Edge<T> edge = new Edge<>(vertex1,vertex2);

            edges.add(edge);
            vertex1.addAdjacentVertex(edge,vertex2);
            if(!isDirected){
                vertex2.addAdjacentVertex(edge,vertex1);
            }
        }

        private void addWeightedEdge(int index1, int index2, int weight) {
            Vertex vertex1 = vertices.get(index1);
            Vertex vertex2 = vertices.get(index2);
            Edge<T> edge = new Edge<>(vertex1,vertex2,weight);

            edges.add(edge);
            vertex1.addAdjacentVertex(edge,vertex2);
            if(!isDirected){
                vertex2.addAdjacentVertex(edge,vertex1);
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Vertex v : vertices) {
                sb.append(v.name + ": ");
                List<Vertex> adjacentVertexList = v.adjacentVertices;
                for (int i = 0; i < adjacentVertexList.size(); i++) {
                    if (i == adjacentVertexList.size()-1){
                        sb.append(adjacentVertexList.get(i).name);
                    }else{
                        sb.append(adjacentVertexList.get(i).name + " -> ");
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

    public static Graph<Character> getWeightedIntegerGraph(boolean isDirected) {
        List<Vertex<Character>> vertexList = new ArrayList<>();
        vertexList.add(new Vertex(0,'A'));
        vertexList.add(new Vertex(1,'B'));
        vertexList.add(new Vertex(2,'C'));
        vertexList.add(new Vertex(3,'D'));
        vertexList.add(new Vertex(4,'E'));

        Graph<Character> graph = new Graph<>(vertexList, isDirected);
        graph.addWeightedEdge(0, 1, 5);
        graph.addWeightedEdge(0, 2, 13);
        graph.addWeightedEdge(0, 4, 15);
        graph.addWeightedEdge(1, 2, 10);
        graph.addWeightedEdge(1, 3, 8);
        graph.addWeightedEdge(2, 3, 6);
        graph.addWeightedEdge(2, 4, 20);
        return graph;
    }

    public static Graph<Character> getWeightedSSSPGraph(boolean isDirected) {
        List<Vertex<Character>> vertexList = new ArrayList<>();
        vertexList.add(new Vertex(0,'A'));
        vertexList.add(new Vertex(1,'B'));
        vertexList.add(new Vertex(2,'C'));
        vertexList.add(new Vertex(3,'D'));
        vertexList.add(new Vertex(4,'E'));
        vertexList.add(new Vertex(5,'F'));
        vertexList.add(new Vertex(6,'G'));

        Graph<Character> graph = new Graph<>(vertexList, isDirected);
        graph.addWeightedEdge(0, 1, 2);
        graph.addWeightedEdge(0, 2, 5);
        graph.addWeightedEdge(1, 2, 6);
        graph.addWeightedEdge(1, 3, 1);
        graph.addWeightedEdge(1, 4, 3);
        graph.addWeightedEdge(2, 5, 8);
        graph.addWeightedEdge(2, 4, 4);
        graph.addWeightedEdge(4, 6, 9);
        graph.addWeightedEdge(5, 6, 7);
        return graph;
    }

    public static Graph<Character> getWeightedNegativeCycleSSSPGraph(boolean isDirected) {
        List<Vertex<Character>> vertexList = new ArrayList<>();
        vertexList.add(new Vertex(0,'A'));
        vertexList.add(new Vertex(1,'B'));
        vertexList.add(new Vertex(2,'C'));
        vertexList.add(new Vertex(3,'D'));
        vertexList.add(new Vertex(4,'E'));

        Graph<Character> graph = new Graph<>(vertexList, isDirected);
        graph.addWeightedEdge(0, 2, 6);
        graph.addWeightedEdge(0, 3, -6);
        graph.addWeightedEdge(1, 0, 3);
        graph.addWeightedEdge(2, 3, 1);
        graph.addWeightedEdge(3, 1, 1);
        graph.addWeightedEdge(4, 1, 4);
        graph.addWeightedEdge(4, 3, 2);
        return graph;
    }
}


