package com.ab.graphs;

import com.ab.graphs.impl.GraphUsingAdjacencyList.Graph;
import com.ab.graphs.impl.GraphUsingAdjacencyList;
import com.ab.graphs.impl.Vertex;
import java.util.Stack;

/**
 * @author Arpit Bhardwaj
 *
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices
 * such that for every directed edge uv, vertex u comes before v in the ordering.
 *
 * DFS
 *
 */
public class TopologicalSort<T> {
    public static void main(String[] args) {
        Graph<Character> intDirectedGraph = GraphUsingAdjacencyList.getGraphForTopological(true);
        TopologicalSort<Character> topologicalSort = new TopologicalSort<>();
        Stack<Vertex<Character>> stack = topologicalSort.topSort(intDirectedGraph);
        System.out.println("Topological Sorting : ");
        while (!stack.isEmpty()){
            System.out.print(stack.pop().getData() + " ");
        }
    }

    private Stack<Vertex<T>> topSort(Graph<T> graph) {
        Stack<Vertex<T>> vertexStack = new Stack<>();
        for (Vertex<T> vertex : graph.getVertexList()) {
            if(!vertex.isVisited()){
                topSortUtil(vertex,vertexStack);
            }
        }
        return vertexStack;
    }

    private void topSortUtil(Vertex<T> vertex, Stack<Vertex<T>> vertexStack) {
        for (Vertex<T> adjacentVertex: vertex.getAdjacentVertexList()) {
            if(!adjacentVertex.isVisited()){
                topSortUtil(adjacentVertex,vertexStack);
            }
        }
        vertex.setVisited(true);
        //add the element to the stack when it's all adjacent vertices are traversed
        vertexStack.push(vertex);
    }
}
