package com.ab.graphs.sssp;

import com.ab.graphs.impl.Graph;
import com.ab.graphs.impl.Vertex;

import java.util.Map;

/**
 * @author Arpit Bhardwaj
 *
 * Dijkstra doesn't work with negative weights and if cycle is present in graph
 */
public class Dijkstra {
    public static void main(String[] args) {
        Graph<Integer> weightedIntGraph = Graph.getWeightedSSSPIntGraph(false);
        Dijkstra dijkstra = new Dijkstra();
        Vertex<Integer> sourceVertex = weightedIntGraph.getVertex(1);
        Map<Vertex<Integer>,Integer> vertexToDistance = dijkstra.shortestPath(weightedIntGraph,sourceVertex);
    }

    private Map<Vertex<Integer>, Integer> shortestPath(Graph<Integer> graph, Vertex<Integer> sourceVertex) {
        return null;
    }
}
