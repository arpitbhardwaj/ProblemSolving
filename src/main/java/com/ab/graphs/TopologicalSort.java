package com.ab.graphs;

import com.ab.graphs.impl.Graph;
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
        Graph<Integer> intDirectedGraph = Graph.getAnotherSampleIntGraph(true);
        TopologicalSort<Integer> topologicalSort = new TopologicalSort<>();
        Deque<Vertex<Integer>> stack = topologicalSort.topSort(intDirectedGraph);
        System.out.println("Topological Sorting : ");
        while (!stack.isEmpty()){
            System.out.print(stack.poll().getId() + " ");
        }
    }

    private Deque<Vertex<T>> topSort(Graph<T> graph) {
        Deque<Vertex<T>> vertexStack = new ArrayDeque<>();
        Set<Long> visitedVertexSet = new HashSet<>();

        for (Vertex<T> vertex:graph.getAllVertex()) {
            if(!visitedVertexSet.contains(vertex.getId())){
                topSortUtil(vertex,vertexStack,visitedVertexSet);
            }
        }
        return vertexStack;
    }

    private void topSortUtil(Vertex<T> vertex, Deque<Vertex<T>> vertexStack, Set<Long> visitedVertexSet) {
        visitedVertexSet.add(vertex.getId());
        for (Vertex<T> adjacentVertex:
                vertex.getAdjacentVertexList()) {
            if(!visitedVertexSet.contains(adjacentVertex.getId())){
                topSortUtil(adjacentVertex,vertexStack,visitedVertexSet);
            }
        }
        //add the element to the stack when its all adjacent vertices are traversed
        vertexStack.offerFirst(vertex);
    }

}
