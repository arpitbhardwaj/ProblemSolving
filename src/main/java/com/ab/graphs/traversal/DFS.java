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
        for (Vertex<T> vertex : graph.getVertices()) {
            if(!vertex.isVisited){
                DFSUtil(vertex);
                //DFSUtilRecursive(vertex);
            }
        }
    }

    //Time Complexity for below method is O(V+E) where V is number of vertices and E is number of edges
    public void DFSUtil(Vertex<T> vertex) {
        Stack<Vertex<T>> vertexStack = new Stack<>();
        vertexStack.push(vertex);
        while (!vertexStack.isEmpty()){
            Vertex<T> poppedVertex = vertexStack.pop();
            poppedVertex.isVisited = true;
            System.out.print(poppedVertex.name + " ");
            for (Vertex<T> adjacentVertex: poppedVertex.adjacentVertices) {
                if (!adjacentVertex.isVisited){
                    vertexStack.push(adjacentVertex);
                    adjacentVertex.isVisited = true;
                }
            }
        }
    }

    //Time Complexity for below method is O(V+E) where V is number of vertices and E is number of edges
    public void DFSUtilRecursive(Vertex<T> vertex) {
        vertex.isVisited = true;
        System.out.print(vertex.name + " ");
        for (Vertex<T> adjacentVertex: vertex.adjacentVertices) {
            if(!adjacentVertex.isVisited){
                DFSUtilRecursive(adjacentVertex);
            }
        }
    }
}
