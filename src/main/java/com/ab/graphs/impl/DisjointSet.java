package com.ab.graphs.impl;

import com.ab.disjoint.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Arpit Bhardwaj
 *
 */
public class DisjointSet<T> {

    private List<Vertex<T>> vertices = new ArrayList<>();

    public void makeSet(List<Vertex<T>> vertices){
        for (Vertex<T> vertex:vertices) {
            DisjointSet<T> set = new DisjointSet<>();
            set.vertices.add(vertex);
            vertex.disjointSet = set;
        }
    }

    public DisjointSet<T> findSet(Vertex<T> vertex){
        return vertex.disjointSet;
    }

    public DisjointSet<T> union(Vertex<T> vertex1, Vertex<T> vertex2){
        DisjointSet<T> set1 = vertex1.disjointSet;
        DisjointSet<T> set2 = vertex2.disjointSet;

        //if they are part of same set then return either of one
        if(set1 == set2){
            return set1;
        }
        //else whomsoever size is larger will gulp the smaller one and the same will be returned
        else{
            if (set1.vertices.size() > set2.vertices.size()) {
                List<Vertex<T>> set2Vertices = set2.vertices;
                for (Vertex<T> vertex : set2Vertices) {
                    set1.vertices.add(vertex);
                    vertex.disjointSet = set1;
                }
                return set1;
            }else {
                List<Vertex<T>> set1Vertices = set1.vertices;
                for (Vertex<T> vertex : set1Vertices) {
                    set2.vertices.add(vertex);
                    vertex.disjointSet = set2;
                }
                return set2;
            }
        }
    }
}
