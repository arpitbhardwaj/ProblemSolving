package com.ab.graphs.sssp;

import com.ab.graphs.impl.GraphUsingAdjacencyList;
import com.ab.graphs.impl.GraphUsingAdjacencyList.Graph;
import com.ab.graphs.impl.Vertex;

import java.util.PriorityQueue;

/**
 * @author Arpit Bhardwaj
 *
 * Dijkstra doesn't work with graphs contain negative cycle.If try to use it on same, it will end up in infinite loop
 *
 * Negative Cycle: There is a cycle and total weight of cycle is a negative number.
 */
public class Dijkstra<T> {

    public static void main(String[] args) {
        //Graph<Character> graph = GraphUsingAdjacencyList.getWeightedSSSPGraph(true);
        Graph<Character> graph = GraphUsingAdjacencyList.getWeightedNegativeCycleSSSPGraph(true);
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstra(graph, graph.getVertices().get(0));
    }

    void dijkstra(Graph<T> graph, Vertex<T> sVertex){
        sVertex.distance = 0;
        PriorityQueue<Vertex<T>> pQueue = new PriorityQueue<>();
        pQueue.addAll(graph.getVertices());
        while (!pQueue.isEmpty()){
            Vertex<T> currentVertex = pQueue.remove();
            for (Vertex<T> adjacentVertex: currentVertex.adjacentVertices) {
                if (pQueue.contains(adjacentVertex)){
                    if (adjacentVertex.distance > currentVertex.distance + currentVertex.weightMap.get(adjacentVertex)){
                        adjacentVertex.distance = currentVertex.distance + currentVertex.weightMap.get(adjacentVertex);
                        adjacentVertex.parent = currentVertex;
                        pQueue.remove(adjacentVertex);
                        pQueue.add(adjacentVertex);
                    }
                }
            }
        }

        for (Vertex<T> vertex:graph.getVertices()) {
            System.out.print(vertex + ", Distance: " + vertex.distance + ", Path: ");
            printShortestPath(vertex);
            System.out.println();
        }
    }

    public <T> void printShortestPath(Vertex<T> vertex){
        if (vertex.parent != null){
            printShortestPath(vertex.parent);
        }
        System.out.print(vertex.name + " ");
    }

}
