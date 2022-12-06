package com.ab.graphs.traversal;

import com.ab.graphs.impl.GraphUsingAdjacencyList.Graph;
import com.ab.graphs.impl.GraphUsingAdjacencyList;
import com.ab.graphs.impl.Vertex;
import java.util.Stack;

/**
 * @author Arpit Bhardwaj
 *
 * DFS uses stack, hence can be implemented using recursion
 */
public class DFS<T> {

    public static void main(String[] args) {
        Graph<Integer> graph = GraphUsingAdjacencyList.getIntegerConnectedGraph(true);
        DFS<Integer> dfs = new DFS<>();
        dfs.printDFSTraversal(graph);
    }

    private void printDFSTraversal(Graph<T> graph) {
        for (Vertex<T> vertex : graph.getVertexList()) {
            if(!vertex.isVisited()){
                DFSUtil(vertex);
                //DFSUtilRecursive(vertex);
            }
        }
    }

    public void DFSUtil(Vertex<T> vertex) {
        Stack<Vertex<T>> vertexStack = new Stack<>();
        vertexStack.push(vertex);
        while (!vertexStack.isEmpty()){
            Vertex<T> poppedVertex = vertexStack.pop();
            poppedVertex.setVisited(true);
            System.out.print(poppedVertex.getData() + " ");
            for (Vertex<T> adjacentVertex: poppedVertex.getAdjacentVertexList()) {
                if (!adjacentVertex.isVisited()){
                    vertexStack.push(adjacentVertex);
                    adjacentVertex.setVisited(true);
                }
            }
        }
    }

    public void DFSUtilRecursive(Vertex<T> vertex) {
        vertex.setVisited(true);
        System.out.print(vertex.getData() + " ");
        for (Vertex<T> adjacentVertex: vertex.getAdjacentVertexList()) {
            if(!adjacentVertex.isVisited()){
                DFSUtilRecursive(adjacentVertex);
            }
        }
    }
}
