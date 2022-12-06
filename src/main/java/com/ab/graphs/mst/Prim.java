package com.ab.graphs.mst;

import com.ab.graphs.impl.Edge;
import com.ab.graphs.impl.GraphUsingAdjacencyList;
import com.ab.graphs.impl.GraphUsingAdjacencyList.Graph;
import com.ab.graphs.impl.Vertex;
import com.ab.heap.impl.MinBinaryHeapWithAddedFunc;
import com.ab.heap.impl.Node;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 */
public class Prim<T> {
    public static void main(String[] args) {
        Graph<Character> weightedIntGraph = GraphUsingAdjacencyList.getWeightedIntegerGraph(false);
        Prim prims = new Prim();
        Collection<Edge<Integer>> edgeCollection = prims.primMST(weightedIntGraph);
        for (Edge<Integer> edge: edgeCollection) {
            System.out.println(edge);
        }
    }

    private List<Edge<T>> primMST(Graph<T> weightedIntGraph) {
        //required a binary min heap data structure
        MinBinaryHeapWithAddedFunc<Vertex<T>> minBinaryHeap = new MinBinaryHeapWithAddedFunc<>();

        //Map of vertex to edge
        Map<Vertex<T>,Edge<T>> vertexToEdge = new HashMap<>();

        //result
        List<Edge<T>> resultEdgeList = new ArrayList<>();

        //insert all vertices with infinite value initially.
        for (Vertex<T> vertex: weightedIntGraph.getVertexList()) {
             Node<Vertex<T>> node = new Node<>(vertex, Integer.MAX_VALUE);
             minBinaryHeap.insertNode(node);
        }

        //start from any random vertex
        Vertex<T> startVertex = weightedIntGraph.getVertexList().iterator().next();

        //for the start vertex decrease the value in heap + map to 0
        minBinaryHeap.decreaseWeight(startVertex,0);

        //iterate till heap + map has elements in it
        while (!minBinaryHeap.empty()){
            //extract min value vertex from heap + map
            Vertex<T> vertex = minBinaryHeap.extractHead().getData();

            //get the corresponding edge for this vertex if present and add it to final result.
            //This edge wont be present for first vertex.
            Edge<T> spanningTreeEdge = vertexToEdge.get(vertex);

            if(spanningTreeEdge != null) {
                resultEdgeList.add(spanningTreeEdge);
            }


            //iterate through all the adjacent vertices
            for (Edge<T> edge: vertex.adjacentEdges) {
                //get the adjacent vertex
                Vertex<T> adjacentVertex = getVertexForEdge(vertex, edge);
                //check if adjacent vertex exist in heap + map and weight attached with this vertex is greater than this edge weight
                if (minBinaryHeap.containsData(adjacentVertex)
                && minBinaryHeap.getWeight(adjacentVertex) > edge.weight){
                    minBinaryHeap.decreaseWeight(adjacentVertex,edge.weight);
                    vertexToEdge.put(adjacentVertex,edge);
                }
            }
        }
        return resultEdgeList;
    }

    private Vertex<T> getVertexForEdge(Vertex<T> v, Edge<T> e){
        return e.vertex1.equals(v) ? e.vertex2 : e.vertex1;
    }

}
