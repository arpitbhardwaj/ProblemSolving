package com.ab.graphs;

import com.ab.graphs.impl.GraphUsingAdjacencyList;
import com.ab.graphs.impl.GraphUsingAdjacencyList.Graph;
import com.ab.graphs.impl.Vertex;

/**
 * @author Arpit Bhardwaj
 *
 * DFS used in directed graph.
 *      There is a cycle in a graph only if there is a back edge present in the graph.
 *      A back edge is an edge that is from a node to itself (self-loop) or one of its ancestor in the tree produced by DFS.
 *
 * DFS used in undirected graph
 *      For every visited vertex ‘v’, if there is an adjacent ‘u’ such that u is already visited and u is not parent of v.
 */
public class DetectCycle<T> {
    public static void main(String[] args) {
        Graph<Integer> directedGraph = GraphUsingAdjacencyList.getCyclicGraph(true);
        Graph<Integer> undirectedGraph = GraphUsingAdjacencyList.getCyclicGraph(false);
        DetectCycle<Integer> detectCycle = new DetectCycle<>();
        if(detectCycle.isCyclicDirected(directedGraph)){
            System.out.println("Graph contains cycle");
        }else{
            System.out.println("Graph doesn't contains cycle");
        }
        if(detectCycle.isCyclicUndirected(undirectedGraph)){
            System.out.println("Graph contains cycle");
        }else{
            System.out.println("Graph doesn't contains cycle");
        }
    }

    private boolean isCyclicDirected(Graph<T> directedGraph) {
        for (Vertex<T> vertex : directedGraph.getVertices()) {
            if(!vertex.isVisited){
                if(isCyclicDirectedUtil(vertex)){
                    return true;
                }else{//continue to explore for disconnected graphs
                    continue;
                }
            }
        }
        return false;
    }

    public boolean isCyclicDirectedUtil(Vertex<T> vertex) {
        System.out.print(vertex.name + " ");
        vertex.isVisited = true;
        for (Vertex<T> adjacentVertex: vertex.adjacentVertices) {
            if(!adjacentVertex.isVisited){
                return isCyclicDirectedUtil(adjacentVertex);
            }else{
                return true;
            }
        }
        return false;
    }

    private boolean isCyclicUndirected(Graph<T> directedGraph) {
        for (Vertex<T> vertex : directedGraph.getVertices()) {
            if(!vertex.isVisited){
                if(isCyclicUndirectedUtil(vertex,null)){
                    return true;
                }else{//continue to explore for disconnected graphs
                    continue;
                }
            }
        }
        return false;
    }

    public boolean isCyclicUndirectedUtil(Vertex<T> vertex, Vertex<T> parent) {
        System.out.print(vertex.name + " ");
        vertex.isVisited = true;
        for (Vertex<T> adjacentVertex: vertex.adjacentVertices) {
            //crux condition for undirected graph and the only difference compare to directed algo
            if (adjacentVertex.equals(parent)){
                continue;
            }
            if(!adjacentVertex.isVisited){
                return isCyclicUndirectedUtil(adjacentVertex,vertex);
            }else{
                return true;
            }
        }
        return false;
    }
}
