package com.ab.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Arpit Bhardwaj
 */
public class BFS<T> {

    private Graph<T> graph;

    public BFS() {
        //this.graph = Graph.getSampleIntegerGraph(true);
        //this.graph = Graph.getSampleCharGraph(true);
    }

    public BFS(Graph<T> graph) {
        this.graph = graph;
    }

    public static void main(String[] args) {
        //Graph<Integer> integerGraph = Graph.getSampleIntegerDisConnGraph(true);
        Graph<Integer> integerGraph = Graph.getSampleIntegerConnGraph(true);
        System.out.println("BFS Traversal : ");
        printBFSTraversal(integerGraph);

        /*BFS bfs = new BFS();
        System.out.println("\nBFS Traversal : ");
        bfs.printBFSTraversal();*/
    }

    private static void printBFSTraversal(Graph<Integer> graph) {
        Set<Long> visitedVertexSet = new HashSet<>();
        Queue<Vertex<Integer>> vertexQueue = new LinkedList<>();
        //Outer loop is to cover disconnected graph use case
        for (Vertex<Integer> vertex:graph.getAllVertex()) {
            long vertexId = vertex.getId();
            if(!visitedVertexSet.contains(vertexId)){
                visitedVertexSet.add(vertexId);
                vertexQueue.add(vertex);
                while (!vertexQueue.isEmpty()){
                    Vertex<Integer> pollVertex = vertexQueue.poll();
                    //System.out.print(pollVertex.getId() + " -> ");
                    System.out.print(pollVertex.getId() + " -> ");
                    for (Vertex<Integer> adjacentVertex:
                         pollVertex.getAdjacentVertexList()) {
                        long adjacentVertexId = adjacentVertex.getId();
                        if (!visitedVertexSet.contains(adjacentVertexId)){
                            visitedVertexSet.add(adjacentVertexId);
                            vertexQueue.add(adjacentVertex);
                        }
                    }
                }
            }
        }
    }

    private <T> void printBFSTraversal() {
        Set<Long> visitedVertexSet = new HashSet<>();
        Queue<Vertex<T>> vertexQueue = new LinkedList<>();

        for (Vertex vertex:graph.getAllVertex()) {
            long vertexId = vertex.getId();

            if(!visitedVertexSet.contains(vertexId)){
                visitedVertexSet.add(vertexId);
                vertexQueue.add(vertex);
                while (!vertexQueue.isEmpty()){
                    Vertex<T> pollVertex = vertexQueue.poll();
                    //System.out.print(pollVertex.getId() + " -> ");
                    System.out.print(pollVertex.getData() + " -> ");
                    for (Vertex<T> adjacentVertex:
                            pollVertex.getAdjacentVertexList()) {
                        long adjacentVertexId = adjacentVertex.getId();
                        if (!visitedVertexSet.contains(adjacentVertexId)){
                            visitedVertexSet.add(adjacentVertexId);
                            vertexQueue.add(adjacentVertex);
                        }
                    }
                }
            }
        }
    }
}
