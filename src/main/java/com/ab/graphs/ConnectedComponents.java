package com.ab.graphs;

import com.ab.graphs.impl.GraphUsingAdjacencyList;
import com.ab.graphs.impl.GraphUsingAdjacencyList.Graph;
import com.ab.graphs.impl.Vertex;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Arpit Bhardwaj
 *
 * BFS or DFS starting from every unvisited vertex, and we get all strongly connected components.
 * Print count of connected components in an undirected disconnected graph
 * Print connected components one after the other
 *
 * A directed graph is strongly connected if there is a path between all pairs of vertices.
 * A strongly connected component (SCC) of a directed graph is a maximal strongly connected subgraph.
 *
 * Kosaraju’s algorithm :
 * Tarjan’s algorithm :
 */
public class ConnectedComponents<T> {

    static int countConnCompo = 0;

    public static void main(String[] args) {
        Graph<Integer> integerGraph = GraphUsingAdjacencyList.getIntegerDisconnectedGraph(true);
        ConnectedComponents<Integer> connComp = new ConnectedComponents<>();
        connComp.printConnectedComponentsUndirected(integerGraph);
        System.out.println("Count of Connected Components : " + countConnCompo);
    }

    private void printConnectedComponentsUndirected(Graph<T> integerGraph) {
        DFS<T> dfs = new DFS<>();
        Set<Long> visitedVertexSet = new HashSet<>();
        for (Vertex<T> vertex : integerGraph.getVertexList()) {
            if(!visitedVertexSet.contains(vertex.getId())){
                dfs.DFSUtil(vertex,visitedVertexSet);
                System.out.println();
                countConnCompo++;
            }
        }
    }

    private void printConnectedComponentsDirected(Graph<T> integerGraph) {
        //TODO
    }
}
