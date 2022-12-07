package com.ab.graphs.sssp;

import com.ab.graphs.impl.GraphUsingAdjacencyList;
import com.ab.graphs.impl.GraphUsingAdjacencyList.Graph;
import com.ab.graphs.impl.Vertex;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Arpit Bhardwaj
 *
 * A single source problem is about finding a path between a given vertex (called source) to all other vertices in
 * a graph such that the total distance between them (source and destination) is minimum.
 * The problem:
 * - Five offices in different cities.
 * - Travel costs between these cities are known.
 * - Find the cheapest way from head office to branches in different cities
 *
 * BFS doesn't work with weighted graphs
 */

public class BFS<T> {
    public static void main(String[] args) {
        Graph<Integer> graph = GraphUsingAdjacencyList.getIntegerConnectedGraph(true);
        BFS bfs = new BFS();
        bfs.BFSTraversal(graph);
    }

    private void BFSTraversal(Graph<T> graph) {
        for (Vertex<T> vertex : graph.getVertices()) {
            if(!vertex.isVisited){
                BFSUtil(vertex);
            }
        }
    }

    public <T> void BFSUtil(Vertex<T> vertex) {
        Queue<Vertex<T>> vertexQueue = new LinkedList<>();
        vertexQueue.add(vertex);
        while (!vertexQueue.isEmpty()){
            Vertex<T> currentVertex = vertexQueue.remove();
            currentVertex.isVisited = true;
            System.out.print("Printing path for node " + currentVertex.name + ": ");
            printShortestPath(currentVertex);
            System.out.println();
            for (Vertex<T> adjacentVertex: currentVertex.adjacentVertices) {
                if (!adjacentVertex.isVisited){
                    vertexQueue.add(adjacentVertex);
                    adjacentVertex.isVisited = true;
                    adjacentVertex.parent = currentVertex; //crux (different from BFS)
                }
            }
        }
    }

    public <T> void printShortestPath(Vertex<T> vertex){
        if (vertex.parent != null){
            printShortestPath(vertex.parent);
        }
        System.out.print(vertex.name + " ");
    }
}
