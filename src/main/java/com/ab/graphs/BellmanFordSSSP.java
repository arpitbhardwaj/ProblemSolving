package com.ab.graphs;

import java.util.Map;

/**
 * @author Arpit Bhardwaj
 */
public class BellmanFordSSSP {
    public static void main(String[] args) {
        Graph<Integer> graph = Graph.getNegativeWeightedSSSPIntGraph(false);
        BellmanFordSSSP bellmanFordSSSP = new BellmanFordSSSP();
        Vertex<Integer> startVertex = graph.getAllVertex().iterator().next();
        Map<Vertex<Integer>,Integer> vertexToDistance = bellmanFordSSSP.shortestPath(graph,startVertex);
    }

    private Map<Vertex<Integer>, Integer> shortestPath(Graph<Integer> graph, Vertex<Integer> startVertex) {
        return null;
    }
}
