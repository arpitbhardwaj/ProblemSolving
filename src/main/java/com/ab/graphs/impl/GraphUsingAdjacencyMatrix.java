package com.ab.graphs.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 */
public class GraphUsingAdjacencyMatrix {

    public static void main(String[] args) {
        List<Vertex> vertexList = new ArrayList<>();
        vertexList.add(new Vertex(0,"A"));
        vertexList.add(new Vertex(1,"B"));
        vertexList.add(new Vertex(2,"C"));
        vertexList.add(new Vertex(3,"D"));
        vertexList.add(new Vertex(4,"E"));

        Graph graph = new Graph(vertexList);
        graph.addUndirectedEdge(0,1);
        graph.addUndirectedEdge(0,2);
        graph.addUndirectedEdge(0,3);
        graph.addUndirectedEdge(1,4);
        graph.addUndirectedEdge(2,3);
        graph.addUndirectedEdge(3,4);

        System.out.println(graph);
    }

    private static class Graph{
        List<Vertex> vertexList;
        int[][] adjacencyMatrix;

        public Graph(List<Vertex> vertexList) {
            this.vertexList = vertexList;
            this.adjacencyMatrix = new int[vertexList.size()][vertexList.size()];
        }

        private void addUndirectedEdge(int index1, int index2) {
            adjacencyMatrix[index1][index2] = 1;
            adjacencyMatrix[index2][index1] = 1;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("  ");
            for (int i = 0; i < vertexList.size(); i++) {
                sb.append(vertexList.get(i).name + " ");
            }
            sb.append("\n");

            for (int i = 0; i < vertexList.size(); i++) {
                sb.append(vertexList.get(i).name + " ");
                for (int j:
                     adjacencyMatrix[i]) {
                    sb.append(j + " ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }
}
