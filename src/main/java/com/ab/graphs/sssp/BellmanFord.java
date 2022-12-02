package com.ab.graphs.sssp;

import com.ab.graphs.impl.Graph;
import com.ab.graphs.impl.Vertex;

import java.util.Map;

/**
 * @author Arpit Bhardwaj
 */
public class BellmanFord {
    public static void main(String[] args) {
        Graph<Integer> graph = Graph.getNegativeWeightedSSSPIntGraph(false);
        BellmanFord bellmanFord = new BellmanFord();
        Vertex<Integer> startVertex = graph.getAllVertex().iterator().next();
        Map<Vertex<Integer>,Integer> vertexToDistance = bellmanFord.shortestPath(graph,startVertex);
    }

    private Map<Vertex<Integer>, Integer> shortestPath(Graph<Integer> graph, Vertex<Integer> startVertex) {
        return null;
    }
}
