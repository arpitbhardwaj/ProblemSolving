package com.ab.graphs;

import com.ab.graphs.impl.GraphUsingAdjacencyList;
import com.ab.graphs.impl.GraphUsingAdjacencyList.Graph;
import com.ab.graphs.impl.Vertex;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Arpit Bhardwaj
 * Given a directed graph, check whether the graph contains a cycle or not.
 *
 * DFS can be used to detect a cycle in directed Graph.
 * There is a cycle in a graph only if there is a back edge present in the graph.
 * A back edge is an edge that is from a node to itself (self-loop) or one of its ancestor in the tree produced by DFS.
 *
 * DFS can be used to detect a cycle in a Undirected Graph
 * For every visited vertex ‘v’, if there is an adjacent ‘u’ such that u is already visited and u is not parent of v, then there is a cycle in graph.
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
        Set<Long> visitedVertexSet = new HashSet<>();
        for (Vertex<T> vertex : directedGraph.getVertexList()) {
            if(!visitedVertexSet.contains(vertex.getId())){
                if(isCyclicDirectedUtil(vertex,visitedVertexSet)){
                    return true;
                }else{//continue to explore for disconnected graphs
                    continue;
                }
            }
        }
        return false;
    }

    public boolean isCyclicDirectedUtil(Vertex<T> vertex, Set<Long> visitedVertexSet) {
        System.out.print(vertex.getId() + " ");
        visitedVertexSet.add(vertex.getId());
        for (Vertex<T> adjacentVertex:
                vertex.getAdjacentVertexList()) {
            if(!visitedVertexSet.contains(adjacentVertex.getId())){
                return isCyclicDirectedUtil(adjacentVertex,visitedVertexSet);
            }else{
                return true;
            }
        }
        return false;
    }

    private boolean isCyclicUndirected(Graph<T> directedGraph) {
        Set<Long> visitedVertexSet = new HashSet<>();
        for (Vertex<T> vertex : directedGraph.getVertexList()) {
            if(!visitedVertexSet.contains(vertex.getId())){
                if(isCyclicUndirectedUtil(vertex,visitedVertexSet,null)){
                    return true;
                }else{//continue to explore for disconnected graphs
                    continue;
                }
            }
        }
        return false;
    }

    public boolean isCyclicUndirectedUtil(Vertex<T> vertex, Set<Long> visitedVertexSet,Vertex<T> parent) {
        System.out.print(vertex.getId() + " ");
        visitedVertexSet.add(vertex.getId());
        for (Vertex<T> adjacentVertex:
                vertex.getAdjacentVertexList()) {
            //crux condition for undirected graph and the only difference compare to directed algo
            if (adjacentVertex.equals(parent)){
                continue;
            }
            if(!visitedVertexSet.contains(adjacentVertex.getId())){
                return isCyclicUndirectedUtil(adjacentVertex,visitedVertexSet,vertex);
            }else{
                return true;
            }
        }
        return false;
    }
}
