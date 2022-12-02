package com.ab.graphs;

import com.ab.graphs.impl.Graph;
import com.ab.graphs.impl.Vertex;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Arpit Bhardwaj
 *
 * BFS or DFS starting from every unvisited vertex, and we get all strongly connected components.
 * Print count of connected components in an undirected disconnected graph
 * Print connected components one after the other
 */
public class ConnectedComponentsUndirected<T> {

    static int countConnCompo = 0;

    public static void main(String[] args) {
        Graph<Integer> integerGraph = Graph.getSampleIntegerDisConnGraph(true);

        ConnectedComponentsUndirected<Integer> connComp = new ConnectedComponentsUndirected<>();
        connComp.printConnectedComponents(integerGraph);
        System.out.println("Count of Connected Components : " + countConnCompo);
    }

    private void printConnectedComponents(Graph<T> integerGraph) {
        DFS<T> dfs = new DFS<>();
        Set<Long> visitedVertexSet = new HashSet<>();
        for (Vertex<T> vertex:integerGraph.getAllVertex()) {
            if(!visitedVertexSet.contains(vertex.getId())){
                dfs.DFSUtil(vertex,visitedVertexSet);
                System.out.println();
                countConnCompo++;
            }
        }
    }
}
