package com.ab.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Arpit Bhardwaj
 */
public class DFS<T> {

    public static void main(String[] args) {
        //Graph<Integer> integerGraph = Graph.getSampleIntegerConnGraph(true);
        Graph<Integer> integerGraph = Graph.getSampleIntegerDisConnGraph(true);
        System.out.println("DFS Traversal : ");
        DFS<Integer> dfs = new DFS<>();
        dfs.printDFSTraversal(integerGraph);
    }

    private void printDFSTraversal(Graph<T> graph) {
        Set<Long> visitedVertexSet = new HashSet<>();
        for (Vertex<T> vertex:graph.getAllVertex()) {
            if(!visitedVertexSet.contains(vertex.getId())){
                DFSUtil(vertex,visitedVertexSet);
            }
        }
    }

    public void DFSUtil(Vertex<T> vertex, Set<Long> visitedVertexSet) {
        visitedVertexSet.add(vertex.getId());
        System.out.print(vertex.getId() + " ");
        for (Vertex<T> adjacentVertex:
                vertex.getAdjacentVertexList()) {
            if(!visitedVertexSet.contains(adjacentVertex.getId())){
                DFSUtil(adjacentVertex,visitedVertexSet);
            }
        }
    }
}
