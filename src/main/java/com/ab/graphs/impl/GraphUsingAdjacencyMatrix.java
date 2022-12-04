package com.ab.graphs.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphUsingAdjacencyMatrix {

    public static void main(String[] args) {
        List<Vertex> nodeList = new ArrayList<>();
        nodeList.add(new Vertex(0,"A"));
        nodeList.add(new Vertex(1,"B"));
        Graph graph = new Graph(nodeList);
        graph.addEdge(0,1);
        System.out.println(graph);
    }

    private static class Graph{
        List<Vertex> nodeList;
        int[][] adjacencyMatrix;

        public Graph(List<Vertex> nodeList) {
            this.nodeList = nodeList;
            this.adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
        }

        private void addEdge(int index1, long index2) {

        }

        @Override
        public String toString() {

            return "Graph{" +
                    "nodeList=" + nodeList +
                    ", adjacencyMatrix=" + Arrays.toString(adjacencyMatrix) +
                    '}';
        }
    }
}
