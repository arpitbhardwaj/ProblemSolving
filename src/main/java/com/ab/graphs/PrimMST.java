package com.ab.graphs;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 */
public class PrimMST<T> {
    public static void main(String[] args) {
        Graph<Integer> weightedIntGraph = Graph.getWeightedSampleIntGraph(false);
        PrimMST prims = new PrimMST();
        Collection<Edge<Integer>> edgeCollection = prims.primMST(weightedIntGraph);
        for (Edge<Integer> edge:
             edgeCollection) {
            System.out.println(edge);
        }
    }

    private List<Edge<T>> primMST(Graph<T> weightedIntGraph) {
        //required a binary min heap data structure
        MinBinaryHeap<Vertex<T>> minBinaryHeap = new MinBinaryHeap<>();

        //Map of vertex to edge
        Map<Vertex<T>,Edge<T>> vertexToEdge = new HashMap<>();

        //result
        List<Edge<T>> resultEdgeList = new ArrayList<>();

        //insert all vertices with infinite value initially.
        for (Vertex<T> vertex:
             weightedIntGraph.getAllVertex()) {
             minBinaryHeap.add(vertex, Integer.MAX_VALUE);
        }

        //start from any random vertex
        Vertex<T> startVertex = weightedIntGraph.getAllVertex().iterator().next();

        //for the start vertex decrease the value in heap + map to 0
        minBinaryHeap.decreaseWeight(startVertex,0);

        //iterate till heap + map has elements in it
        while (!minBinaryHeap.empty()){
            //extract min value vertex from heap + map
            Vertex<T> vertex = minBinaryHeap.extractMin();

            //get the corresponding edge for this vertex if present and add it to final result.
            //This edge wont be present for first vertex.
            Edge<T> spanningTreeEdge = vertexToEdge.get(vertex);

            if(spanningTreeEdge != null) {
                resultEdgeList.add(spanningTreeEdge);
            }


            //iterate through all the adjacent vertices
            for (Edge<T> edge:
                 vertex.getEdgeList()) {
                //get the adjacent vertex
                Vertex<T> adjacentVertex = getVertexForEdge(vertex, edge);
                //check if adjacent vertex exist in heap + map and weight attached with this vertex is greater than this edge weight
                if (minBinaryHeap.containsVertex(adjacentVertex)
                && minBinaryHeap.getWeight(adjacentVertex) > edge.getWeight()){
                    minBinaryHeap.decreaseWeight(adjacentVertex,edge.getWeight());
                    vertexToEdge.put(adjacentVertex,edge);
                }
            }
        }
        return resultEdgeList;
    }

    private Vertex<T> getVertexForEdge(Vertex<T> v, Edge<T> e){
        return e.getVertex1().equals(v) ? e.getVertex2() : e.getVertex1();
    }

}
