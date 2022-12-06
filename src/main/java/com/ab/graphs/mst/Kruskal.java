package com.ab.graphs.mst;

import com.ab.disjoint.DisjointSet;
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
 */
public class Kruskal<T> {
    public static void main(String[] args) {
        Graph<Character> weightedIntGraph = GraphUsingAdjacencyList.getWeightedIntegerGraph(false);
        Kruskal kruskal = new Kruskal();
        List<Edge<Character>> edgeCollection = kruskal.kruskalMST(weightedIntGraph);
        for (Edge<Character> edge: edgeCollection) {
            System.out.println(edge);
        }
    }

    private List<Edge<T>> kruskalMST(Graph<T> graph) {
        List<Edge<T>> resultEdgeList = new ArrayList<>();
        List<Edge<T>> allEdges = graph.getEdgeList();
        Collections.sort(allEdges, new Comparator<Edge<T>>() {
            @Override
            public int compare(Edge<T> edge1, Edge<T> edge2) {
                if (edge1.weight > edge2.weight){
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        DisjointSet<Integer> disjointSet = new DisjointSet<>();
        for (Vertex<T> vertex: graph.getVertexList()) {
            disjointSet.makeSet(vertex.id);
        }

        for (Edge<T> edge: allEdges) {
            long identity1 = disjointSet.findSet(edge.vertex1.id);
            long identity2 = disjointSet.findSet(edge.vertex2.id);

            if (identity1 != identity2) {
                resultEdgeList.add(edge);
                disjointSet.union(edge.vertex1.id,edge.vertex2.id);
            }
        }
        return resultEdgeList;
    }
}
