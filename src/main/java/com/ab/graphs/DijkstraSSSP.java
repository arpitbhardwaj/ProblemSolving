package com.ab.graphs;

import java.util.Map;

/**
 * @author Arpit Bhardwaj
 *
 * Dijkstra doesn't work with negative weights and if cycle is present in graph
 */
public class DijkstraSSSP {
    public static void main(String[] args) {
        Graph<Integer> weightedIntGraph = Graph.getWeightedSSSPIntGraph(false);
        DijkstraSSSP dijkstraSSSP = new DijkstraSSSP();
        Vertex<Integer> sourceVertex = weightedIntGraph.getVertex(1);
        Map<Vertex<Integer>,Integer> vertexToDistance = dijkstraSSSP.shortestPath(weightedIntGraph,sourceVertex);
    }

    private Map<Vertex<Integer>, Integer> shortestPath(Graph<Integer> graph, Vertex<Integer> sourceVertex) {
        return null;
    }
}
