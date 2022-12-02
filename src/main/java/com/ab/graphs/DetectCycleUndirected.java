package com.ab.graphs;

import com.ab.graphs.impl.Graph;
import com.ab.graphs.impl.Vertex;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Arpit Bhardwaj
 * DFS can be used to detect a cycle in a Undirected Graph
 * For every visited vertex ‘v’, if there is an adjacent ‘u’ such that u is already visited and u is not parent of v, then there is a cycle in graph.
 *
 */
public class DetectCycleUndirected<T> {
    public static void main(String[] args) {
        Graph<Integer> undirectedGraph = Graph.getSampleCycLicGraph(false);
        DetectCycleUndirected<Integer> detectCycle = new DetectCycleUndirected<>();
        if(detectCycle.isCyclic(undirectedGraph)){
            System.out.println("Graph contains cycle");
        }else{
            System.out.println("Graph doesn't contains cycle");
        }
    }

    private boolean isCyclic(Graph<T> directedGraph) {
        Set<Long> visitedVertexSet = new HashSet<>();
        for (Vertex<T> vertex:directedGraph.getAllVertex()) {
            if(!visitedVertexSet.contains(vertex.getId())){
                if(isCyclicUtil(vertex,visitedVertexSet,null)){
                    return true;
                }else{//continue to explore for disconnected graphs
                    continue;
                }
            }
        }
        return false;
    }

    public boolean isCyclicUtil(Vertex<T> vertex, Set<Long> visitedVertexSet,Vertex<T> parent) {
        System.out.print(vertex.getId() + " ");
        visitedVertexSet.add(vertex.getId());
        for (Vertex<T> adjacentVertex:
                vertex.getAdjacentVertexList()) {
            //crux condition for undirected graph and the only difference compare to directed algo
            if (adjacentVertex.equals(parent)){
                continue;
            }
            if(!visitedVertexSet.contains(adjacentVertex.getId())){
                return isCyclicUtil(adjacentVertex,visitedVertexSet,vertex);
            }else{
                return true;
            }
        }
        return false;
    }
}
