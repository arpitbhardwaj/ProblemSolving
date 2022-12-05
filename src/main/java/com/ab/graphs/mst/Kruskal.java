package com.ab.graphs.mst;

import com.ab.disjoint.DisjointSet;
import com.ab.graphs.impl.Edge;
import com.ab.graphs.impl.GraphUsingAdjacencyList;
import com.ab.graphs.impl.GraphUsingAdjacencyList.Graph;
import com.ab.graphs.impl.Vertex;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 */
public class Kruskal {
    public static void main(String[] args) {
        Graph<Integer> weightedIntGraph = GraphUsingAdjacencyList.getWeightedSampleIntGraph(false);
        Kruskal kruskal = new Kruskal();
        List<Edge<Integer>> edgeCollection = kruskal.kruskalMST(weightedIntGraph);
        for (Edge<Integer> edge:
                edgeCollection) {
            System.out.println(edge);
        }
    }

    private List<Edge<Integer>> kruskalMST(Graph<Integer> graph) {
        List<Edge<Integer>> resultEdgeList = new ArrayList<>();
        List<Edge<Integer>> allEdges = graph.getEdgeList();
        Collections.sort(allEdges, new Comparator<Edge<Integer>>() {
            @Override
            public int compare(Edge<Integer> edge1, Edge<Integer> edge2) {
                if (edge1.getWeight() > edge2.getWeight()){
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        DisjointSet<Long> disjointSet = new DisjointSet<>();
        for (Vertex<Integer> vertex:
             graph.getAllVertex()) {
            disjointSet.makeSet(vertex.getId());
        }

        for (Edge<Integer> edge:
             allEdges) {
            long identity1 = disjointSet.findSet(edge.getVertex1().getId());
            long identity2 = disjointSet.findSet(edge.getVertex2().getId());

            if (identity1 != identity2) {
                resultEdgeList.add(edge);
                disjointSet.union(edge.getVertex1().getId(),edge.getVertex2().getId());
            }
        }
        return resultEdgeList;
    }
}
