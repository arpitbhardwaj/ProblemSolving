package com.ab.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Arpit Bhardwaj
 * Given a directed graph, check whether the graph contains a cycle or not.
 *
 * DFS can be used to detect a cycle in a Graph.
 * DFS for a connected graph produces a tree.
 * There is a cycle in a graph only if there is a back edge present in the graph.
 * A back edge is an edge that is from a node to itself (self-loop) or one of its ancestor in the tree produced by DFS.
 */
public class DetectCycleDirected<T> {
    public static void main(String[] args) {
        Graph<Integer> directedGraph = Graph.getSampleCycLicGraph(true);
        //Graph<Integer> directedGraph = Graph.getAnotherSampleIntGraph(true);
        DetectCycleDirected<Integer> detectCycle = new DetectCycleDirected<>();
        if(detectCycle.isCyclic(directedGraph)){
            System.out.println("Graph contains cycle");
        }else{
            System.out.println("Graph doesn't contains cycle");
        }
    }

    private boolean isCyclic(Graph<T> directedGraph) {
        Set<Long> visitedVertexSet = new HashSet<>();
        for (Vertex<T> vertex:directedGraph.getAllVertex()) {
            if(!visitedVertexSet.contains(vertex.getId())){
                return isCyclicUtil(vertex,visitedVertexSet);
            }
        }
        return false;
    }

    public boolean isCyclicUtil(Vertex<T> vertex, Set<Long> visitedVertexSet) {
        visitedVertexSet.add(vertex.getId());
        for (Vertex<T> adjacentVertex:
                vertex.getAdjacentVertexList()) {
            if(!visitedVertexSet.contains(adjacentVertex.getId())){
                return isCyclicUtil(adjacentVertex,visitedVertexSet);
            }else{
                return true;
            }
        }
        return false;
    }
}
