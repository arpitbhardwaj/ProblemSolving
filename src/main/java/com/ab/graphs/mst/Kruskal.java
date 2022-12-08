package com.ab.graphs.mst;

import com.ab.graphs.impl.DisjointSet;
import com.ab.graphs.impl.Edge;
import com.ab.graphs.impl.GraphUsingAdjacencyList;
import com.ab.graphs.impl.GraphUsingAdjacencyList.Graph;
import com.ab.graphs.impl.Vertex;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 *
 * A Minimum Spanning Tree (MST) is a subset of the edges of connected, weighted and undirected graph which :
 * - Connects all vertices together
 * - No cycle
 * - Minimum total edge
 * Real life problem
 * - Connect five island with bridges
 * - The cost of bridges between island varies based on different factors
 * - Which bridge should be constructed so that all islands are accessible and the cost is minimum
 *
 *
 */
public class Kruskal<T> {
    public static void main(String[] args) {
        Graph<Character> weightedIntGraph = GraphUsingAdjacencyList.getWeightedIntegerGraph(false);
        Kruskal kruskal = new Kruskal();
        List<Edge<Character>> edges = kruskal.kruskal(weightedIntGraph);
        for (Edge<Character> edge: edges) {
            System.out.println(edge);
        }
    }

    //works with DisjointSet impl in graphs.impl package
    private List<Edge<T>> kruskal(Graph<T> graph) {
        List<Edge<T>> resultEdges = new ArrayList<>();
        List<Edge<T>> edges = graph.getEdges();
        DisjointSet<T> disjointSet = new DisjointSet<>();
        int cost = 0;

        edges.sort(Comparator.comparingInt(edge -> edge.weight));
        for (Vertex<T> vertex: graph.getVertices()) {
            disjointSet.makeSet(vertex);
        }
        for (Edge<T> edge: edges) {
            DisjointSet<T> set1 = disjointSet.findSet(edge.firstVertex);
            DisjointSet<T> set2 = disjointSet.findSet(edge.secondVertex);
            if (set1 != set2) {
                disjointSet.union(edge.firstVertex, edge.secondVertex);
                resultEdges.add(edge);
                cost += edge.weight;
            }
        }
        System.out.println("Total Cost: " + cost);
        return resultEdges;
    }

    /*
    //works with DisjointSet impl in disjoint package
    private List<Edge<T>> kruskal(Graph<T> graph) {
        List<Edge<T>> resultEdges = new ArrayList<>();
        List<Edge<T>> edges = graph.getEdges();
        DisjointSet<T> disjointSet = new DisjointSet<>();
        int cost = 0;

        edges.sort(Comparator.comparingInt(edge -> edge.weight));
        for (Vertex<T> vertex: graph.getVertices()) {
            disjointSet.makeSet(vertex.name);
        }
        for (Edge<T> edge: edges) {
            T identity1 = disjointSet.findSet(edge.firstVertex.name);
            T identity2 = disjointSet.findSet(edge.secondVertex.name);
            if (identity1 != identity2) {
                disjointSet.union(edge.firstVertex.name, edge.secondVertex.name);
                resultEdges.add(edge);
                cost += edge.weight;
            }
        }
        System.out.println("Total Cost: " + cost);
        return resultEdges;
    }
    */
}
