package com.ab.graphs;

import com.ab.graphs.impl.GraphUsingAdjacencyList;
import com.ab.graphs.impl.GraphUsingAdjacencyList.Graph;
import com.ab.graphs.impl.Vertex;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Arpit Bhardwaj
 */
public class BFS<T> {

    public static void main(String[] args) {
        Graph<Integer> graph = GraphUsingAdjacencyList.getIntegerConnectedGraph(true);
        BFS bfs = new BFS();
        System.out.println("BFS Traversal : ");
        bfs.printBFSTraversal(graph);
    }

    private <T> void printBFSTraversal(Graph<T> graph) {
        Set<Long> visitedVertexSet = new HashSet<>();
        Queue<Vertex<T>> vertexQueue = new LinkedList<>();

        for (Vertex vertex : graph.getVertexList()) {
            long vertexId = vertex.getId();

            if(!visitedVertexSet.contains(vertexId)){
                visitedVertexSet.add(vertexId);
                vertexQueue.add(vertex);
                while (!vertexQueue.isEmpty()){
                    Vertex<T> pollVertex = vertexQueue.poll();
                    System.out.print(pollVertex.getId() + " ");
                    for (Vertex<T> adjacentVertex: pollVertex.getAdjacentVertexList()) {
                        long adjacentVertexId = adjacentVertex.getId();
                        if (!visitedVertexSet.contains(adjacentVertexId)){
                            visitedVertexSet.add(adjacentVertexId);
                            vertexQueue.add(adjacentVertex);
                        }
                    }
                }
            }
        }
    }
}
