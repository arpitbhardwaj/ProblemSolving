package com.ab.graphs.traversal;

import com.ab.graphs.impl.GraphUsingAdjacencyList;
import com.ab.graphs.impl.GraphUsingAdjacencyList.Graph;
import com.ab.graphs.impl.Vertex;
import java.util.LinkedList;
import java.util.Queue;
/**
 * @author Arpit Bhardwaj
 */
public class BFS<T> {

    public static void main(String[] args) {
        Graph<Integer> graph = GraphUsingAdjacencyList.getIntegerConnectedGraph(true);
        BFS bfs = new BFS();
        System.out.println("BFS Traversal: ");
        bfs.printBFSTraversal(graph);
    }

    private <T> void printBFSTraversal(Graph<T> graph) {
        Queue<Vertex<T>> vertexQueue = new LinkedList<>();

        for (Vertex vertex : graph.getVertexList()) {
            if(!vertex.isVisited()){
                vertexQueue.add(vertex);
                while (!vertexQueue.isEmpty()){
                    Vertex<T> pollVertex = vertexQueue.poll();
                    System.out.print(pollVertex.getData() + " ");
                    for (Vertex<T> adjacentVertex: pollVertex.getAdjacentVertexList()) {
                        if (!adjacentVertex.isVisited()){
                            vertexQueue.add(adjacentVertex);
                            adjacentVertex.setVisited(true);
                        }
                    }
                }
            }
        }
    }
}
