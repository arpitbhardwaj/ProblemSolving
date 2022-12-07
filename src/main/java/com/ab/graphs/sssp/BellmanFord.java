package com.ab.graphs.sssp;

import com.ab.graphs.impl.GraphUsingAdjacencyList;
import com.ab.graphs.impl.GraphUsingAdjacencyList.Graph;
import com.ab.graphs.impl.Vertex;

/**
 * @author Arpit Bhardwaj
 *
 * Bellman Ford works with all
 */
public class BellmanFord<T> {
    public static void main(String[] args) {
        //Graph<Character> graph = GraphUsingAdjacencyList.getWeightedSSSPGraph(true);
        Graph<Character> graph = GraphUsingAdjacencyList.getWeightedNegativeCycleSSSPGraph(true);
        BellmanFord bellmanFord = new BellmanFord();
        bellmanFord.bellmanFord(graph, graph.getVertices().get(0));
    }

    void bellmanFord(GraphUsingAdjacencyList.Graph<T> graph, Vertex<T> sVertex){
        boolean isNegativeCycle = false;
        sVertex.distance = 0;
        for (int i = 0; i < graph.getVertices().size(); i++) {
            for (Vertex<T> currentVertex: graph.getVertices()) {
                for (Vertex<T> adjacentVertex: currentVertex.adjacentVertices) {
                    if (adjacentVertex.distance > currentVertex.distance + currentVertex.weightMap.get(adjacentVertex)){
                        adjacentVertex.distance = currentVertex.distance + currentVertex.weightMap.get(adjacentVertex);
                        adjacentVertex.parent = currentVertex;
                    }
                }
            }
        }

        System.out.println("Checking for negative cycle...");
        for (Vertex<T> currentVertex: graph.getVertices()) {
            for (Vertex<T> adjacentVertex: currentVertex.adjacentVertices) {
                if (adjacentVertex.distance > currentVertex.distance + currentVertex.weightMap.get(adjacentVertex)){
                    isNegativeCycle = true;
                    System.out.println("Negative cycle found.");
                }
            }
        }

        if (!isNegativeCycle){
            System.out.println("Negative cycle not found.");
            for (Vertex<T> vertex:graph.getVertices()) {
                System.out.print(vertex + ", Distance: " + vertex.distance + ", Path: ");
                printShortestPath(vertex);
                System.out.println();
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
