package com.ab.disjoint;

import com.ab.graphs.Edge;
import com.ab.graphs.Graph;
import com.ab.graphs.Vertex;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 */
public class KruskalMST {
    public static void main(String[] args) {
        Graph<Integer> weightedIntGraph = Graph.getWeightedSampleIntGraph(false);
        KruskalMST kruskal = new KruskalMST();
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
