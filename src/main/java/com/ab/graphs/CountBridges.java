package com.ab.graphs;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 */
public class CountBridges {

    static class Graph {
        boolean isDirected = false;
        private List<Edge> edgeList;
        private Map<Long, Vertex> vertexMap;

        public Graph(boolean isDirected) {
            this.isDirected = isDirected;
            this.edgeList = new ArrayList<>();
            this.vertexMap = new HashMap<>();
        }

        public List<Edge> getEdgeList() {
            return edgeList;
        }

        public Map<Long, Vertex> getVertexMap() {
            return vertexMap;
        }

        public void addEdge(long id1, long id2){
            addEdge(id1, id2, 0);
        }

        private void addEdge(long id1, long id2, int weight) {
            Vertex vertex1 = null;
            if(vertexMap.containsKey(id1)){
                vertex1 = vertexMap.get(id1);
            }else{
                vertex1 = new Vertex(id1);
                vertexMap.put(id1,vertex1);
            }

            Vertex vertex2 = null;
            if(vertexMap.containsKey(id2)){
                vertex2 = vertexMap.get(id2);
            }else{
                vertex2 = new Vertex(id2);
                vertexMap.put(id2,vertex2);
            }

            Edge edge = new Edge(isDirected,vertex1,vertex2,weight);

            edgeList.add(edge);
            vertex1.addAdjacentVertex(edge,vertex2);
            if(!isDirected){
                vertex2.addAdjacentVertex(edge,vertex1);
            }
        }

        public Collection<Vertex> getAllVertex() {
            return vertexMap.values();
        }

        public void setDataForVertex(long id, int data){
            if (vertexMap.containsKey(id)){
                Vertex vertex = vertexMap.get(id);
                vertex.setData(data);
            }
        }

        public Vertex getVertex(long id){
            return vertexMap.get(id);
        }
    }

    static class Edge {
        private boolean isDirected = false;
        private Vertex vertex1;
        private Vertex vertex2;
        private int weight;

        public Edge(Vertex vertex1, Vertex vertex2) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
        }

        public Edge(boolean isDirected, Vertex vertex1, Vertex vertex2) {
            this.isDirected = isDirected;
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
        }

        public Edge(boolean isDirected, Vertex vertex1, Vertex vertex2, int weight) {
            this.isDirected = isDirected;
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }

        public boolean isDirected() {
            return isDirected;
        }

        public Vertex getVertex1() {
            return vertex1;
        }

        public Vertex getVertex2() {
            return vertex2;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return Objects.equals(vertex1, edge.vertex1) &&
                    Objects.equals(vertex2, edge.vertex2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(vertex1, vertex2);
        }

    }

    static class Vertex {
        long id;//for simple use case consider id as data itself
        private int data;
        private List<Edge> edgeList = new ArrayList<>();
        private List<Vertex> adjacentVertexList = new ArrayList<>();

        public Vertex(long id) {
            this.id = id;
        }

        public Vertex(long id, int data) {
            this.id = id;
            this.data = data;
        }

        public long getId() {
            return id;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public List<Edge> getEdgeList() {
            return edgeList;
        }

        public List<Vertex> getAdjacentVertexList() {
            return adjacentVertexList;
        }

        public void addAdjacentVertex(Edge edge, Vertex vertex2) {
            edgeList.add(edge);
            adjacentVertexList.add(vertex2);
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return id == vertex.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        public void swap(Vertex vertex) {
            long id = vertex.id;
            int data = vertex.data;

            vertex.id = this.id;
            vertex.data = this.data;

            this.id = id;
            this.data = data;
        }
    }

    private static int time;

    public static int getBridges(Graph graph){

        Set<Edge> result = new HashSet<Edge>();
        Map<Vertex,Integer> discovery = new HashMap<Vertex,Integer>();
        Map<Vertex,Integer> low = new HashMap<Vertex,Integer>();
        Map<Vertex,Vertex> parent = new HashMap<Vertex,Vertex>();
        Map<Vertex,Boolean> visited = new HashMap<Vertex,Boolean>();

        for(Vertex vertex : graph.getAllVertex()){
            if(!visited.containsKey(vertex)){
                BridgeUtil(vertex,result,discovery,low,parent,visited);
            }
        }
        return result.size();
    }

    private static void BridgeUtil(Vertex vertex, Set<Edge> result,Map<Vertex,Integer> discovery,
                            Map<Vertex,Integer> low,Map<Vertex,Vertex> parent,Map<Vertex,Boolean> visited){
        visited.put(vertex, true);
        discovery.put(vertex, time);
        low.put(vertex, time);
        time++;
        for(Vertex child : vertex.getAdjacentVertexList()){
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

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        int result = findCriticalRoads(list);
        System.out.print(result);
    }

    private static int findCriticalRoads(List<List<Integer>> roads) {
        Graph graph = new Graph(false);
        for (List<Integer> edge:
                roads) {
            graph.addEdge(edge.get(0),edge.get(1));
        }
        return getBridges(graph);
    }

}
