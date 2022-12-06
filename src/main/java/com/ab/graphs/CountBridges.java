package com.ab.graphs;

import com.ab.graphs.impl.Edge;
import com.ab.graphs.impl.GraphUsingAdjacencyList;
import com.ab.graphs.impl.Vertex;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 */
public class CountBridges {

    private static int time;

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        int result = findCriticalRoads(list);
        System.out.print(result);
    }

    private static int findCriticalRoads(List<List<Integer>> roads) {
        GraphUsingAdjacencyList.Graph graph = GraphUsingAdjacencyList.getIntegerConnectedGraph(false);
        for (List<Integer> edge: roads) {
            graph.addEdge(edge.get(0),edge.get(1));
        }
        return getBridges(graph);
    }

    public static int getBridges(GraphUsingAdjacencyList.Graph<Integer> graph){
        Set<Edge> result = new HashSet<Edge>();
        Map<Vertex,Integer> discovery = new HashMap<>();
        Map<Vertex,Integer> low = new HashMap<>();
        Map<Vertex,Vertex> parent = new HashMap<>();
        Map<Vertex,Boolean> visited = new HashMap<>();

        for(Vertex vertex : graph.getVertexList()){
            if(!visited.containsKey(vertex)){
                BridgeUtil(vertex,result,discovery,low,parent,visited);
            }
        }
        return result.size();
    }

    private static void BridgeUtil(Vertex<Integer> vertex, Set<Edge> result,
                                   Map<Vertex,Integer> discovery,
                                   Map<Vertex,Integer> low,
                                   Map<Vertex,Vertex> parent,
                                   Map<Vertex,Boolean> visited){
        visited.put(vertex, true);
        discovery.put(vertex, time);
        low.put(vertex, time);
        time++;
        for(Vertex<Integer> child : vertex.getAdjacentVertexList()){
            if(!visited.containsKey(child)){
                parent.put(child, vertex);
                BridgeUtil(child,result,discovery,low,parent,visited);
                if(discovery.get(vertex) < low.get(child) ){
                    result.add(new Edge(vertex,child));
                }
                low.put(vertex, Math.min(discovery.get(vertex), low.get(child)));
            }else{
                if(!child.equals(parent.get(vertex))){
                    low.put(vertex,Math.min(discovery.get(vertex), low.get(child)));
                }
            }
        }
    }
}
