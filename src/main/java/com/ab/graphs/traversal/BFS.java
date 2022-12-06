package com.ab.graphs.traversal;

import com.ab.graphs.impl.GraphUsingAdjacencyList;
import com.ab.graphs.impl.GraphUsingAdjacencyList.Graph;
import com.ab.graphs.impl.Vertex;
import java.util.LinkedList;
import java.util.Queue;
/**
 * @author Arpit Bhardwaj
 */
public class BFS<T> {

    public static void main(String[] args) {
        Graph<Integer> graph = GraphUsingAdjacencyList.getIntegerConnectedGraph(true);
        BFS bfs = new BFS();
        bfs.printBFSTraversal(graph);
    }

    private void printBFSTraversal(Graph<T> graph) {
        for (Vertex<T> vertex : graph.getVertexList()) {
            if(!vertex.isVisited){
                BFSUtil(vertex);
            }
        }
    }

    public <T> void BFSUtil(Vertex<T> vertex) {
        Queue<Vertex<T>> vertexQueue = new LinkedList<>();
        vertexQueue.add(vertex);
        while (!vertexQueue.isEmpty()){
            Vertex<T> removedVertex = vertexQueue.remove();
            removedVertex.isVisited = true;
            System.out.print(removedVertex.name + " ");
            for (Vertex<T> adjacentVertex: removedVertex.adjacentVertices) {
                if (!adjacentVertex.isVisited){
                    vertexQueue.add(adjacentVertex);
                    adjacentVertex.isVisited = true;
                }
            }
        }
    }
}
