package com.ab.graphs.mst;

import com.ab.graphs.impl.GraphUsingAdjacencyList;
import com.ab.graphs.impl.GraphUsingAdjacencyList.Graph;
import com.ab.graphs.impl.Vertex;
import java.util.*;

/**
 * @author Arpit Bhardwaj
 */
public class Prim<T> {
    public static void main(String[] args) {
        Graph<Character> graph = GraphUsingAdjacencyList.getWeightedIntegerGraph(false);
        Prim prims = new Prim();
        prims.prims(graph, graph.getVertices().get(0));
    }

    private void prims(Graph<T> graph, Vertex<T> vertex) {
        vertex.distance = 0;
        PriorityQueue<Vertex<T>> pQueue = new PriorityQueue<>();
        pQueue.addAll(graph.getVertices());
        while (!pQueue.isEmpty()){
            Vertex<T> currentVertex = pQueue.remove();
            for (Vertex<T> adjacentVertex: currentVertex.adjacentVertices) {
                if (pQueue.contains(adjacentVertex)){
                    if (adjacentVertex.distance > currentVertex.weightMap.get(adjacentVertex)){
                        adjacentVertex.distance = currentVertex.weightMap.get(adjacentVertex);
                        adjacentVertex.parent = currentVertex;
                        pQueue.remove(adjacentVertex);
                        pQueue.add(adjacentVertex);
                    }
                }
            }
        }

        int cost = 0;
        for (Vertex<T> v : graph.getVertices()) {
            System.out.print(v + ", Distance: " + v.distance + ", Parent: " + v.parent);
            cost += v.distance;
            System.out.println();
        }
        System.out.println("Total Cost: " + cost);
    }
}
