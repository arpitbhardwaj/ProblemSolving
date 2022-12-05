package com.ab.graphs;

import com.ab.graphs.impl.GraphUsingAdjacencyList.Graph;
import com.ab.graphs.impl.GraphUsingAdjacencyList;
import com.ab.graphs.impl.Vertex;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Arpit Bhardwaj
 *
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices
 * such that for every directed edge uv, vertex u comes before v in the ordering.
 *
 */
public class TopologicalSort<T> {
    public static void main(String[] args) {
        Graph<Integer> intDirectedGraph = GraphUsingAdjacencyList.getAnotherIntegerGraph(true);
        TopologicalSort<Integer> topologicalSort = new TopologicalSort<>();
        Deque<Vertex<Integer>> stack = topologicalSort.topSort(intDirectedGraph);
        System.out.println("Topological Sorting : ");
        while (!stack.isEmpty()){
            System.out.print(stack.poll().getId() + " ");
        }
    }

    private Deque<Vertex<T>> topSort(Graph<T> graph) {
        Deque<Vertex<T>> vertexStack = new ArrayDeque<>();
        for (Vertex<T> vertex : graph.getVertexList()) {
            if(!vertex.isVisited()){
                topSortUtil(vertex,vertexStack);
            }
        }
        return vertexStack;
    }

    private void topSortUtil(Vertex<T> vertex, Deque<Vertex<T>> vertexStack) {
        vertex.setVisited(true);
        for (Vertex<T> adjacentVertex: vertex.getAdjacentVertexList()) {
            if(!adjacentVertex.isVisited()){
                topSortUtil(adjacentVertex,vertexStack);
            }
        }
        //add the element to the stack when its all adjacent vertices are traversed
        vertexStack.offerFirst(vertex);
    }

}
