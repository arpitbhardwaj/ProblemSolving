package com.ab.graphs.traversal;

import com.ab.graphs.impl.GraphUsingAdjacencyList.Graph;
import com.ab.graphs.impl.GraphUsingAdjacencyList;
import com.ab.graphs.impl.Vertex;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Arpit Bhardwaj
 *
 * DFS uses stack, hence can be implemented using recursion
 */
public class DFS<T> {

    public static void main(String[] args) {
        //Graph<Integer> integerGraph = GraphUsingAdjacencyList.getIntegerConnectedGraph(true);
        Graph<Integer> integerGraph = GraphUsingAdjacencyList.getIntegerDisconnectedGraph(true);
        System.out.println("DFS Traversal: ");
        DFS<Integer> dfs = new DFS<>();
        dfs.printDFSTraversal(integerGraph);
    }

    private void printDFSTraversal(Graph<T> graph) {
        for (Vertex<T> vertex : graph.getVertexList()) {
            if(!vertex.isVisited()){
                DFSUtil(vertex);
            }
        }
    }

    public void DFSUtil(Vertex<T> vertex) {
        vertex.setVisited(true);
        System.out.print(vertex.getData() + " ");
        for (Vertex<T> adjacentVertex: vertex.getAdjacentVertexList()) {
            if(!adjacentVertex.isVisited()){
                DFSUtil(adjacentVertex);
            }
        }
    }
}
