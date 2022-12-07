package com.ab.disjoint;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arpit Bhardwaj
 *
 *  Disjoint sets using path compression and union by rank. it supports 3 operations
 *  1) makeSet: used to create initial set
 *  2) union: merge 2 given sets
 *  3) findSet: returns the set name in which the element is present
 *
 *  For m operations and total n elements time complexity is O(m*f(n)) where f(n) is
 *  very slowly growing function. For most cases f(n) <= 4 so effectively
 *  total time will be O(m)
 */
public class DisjointSet<T> {

    private Map<T,Node<T>> nodeMap = new HashMap<>();

    public void makeSet(T data){
        Node<T> node = new Node<>(data);
        nodeMap.put(data,node);
    }

    public boolean union(T data1, T data2){
        Node<T> node1 = nodeMap.get(data1);
        Node<T> node2 = nodeMap.get(data2);

        Node<T> parent1 = findSetPathCompression(node1);
        Node<T> parent2 = findSetPathCompression(node2);
        //if they are part of same set do nothing
        if(parent1.data == parent2.data){
            return false;
        }
        //else whomsoever rank is higher becomes parent of other
        else{
            if(parent1.rank == parent2.rank){
                parent1.rank++;
                parent2.parent = parent1;
            }else if (parent1.rank > parent2.rank){
                parent2.parent = parent1;
            }else{
                parent1.parent = parent2;
            }
            return true;
        }
    }

    public T findSet(T data){
        return findSetPathCompression(nodeMap.get(data)).data;
    }

    private Node<T> findSetPathCompression(Node<T> node) {
        Node parent = node.parent;
        if(node == parent){
            return parent;
        }
        //below line is doing path compression
        node.parent = findSetPathCompression(node.parent);
        return node.parent;
    }

    public static void main(String[] args) {
        DisjointSet<Integer> disjointSet = new DisjointSet<>();
        for (int i = 1; i < 8; i++) {
            disjointSet.makeSet(i);
        }
        disjointSet.union(1,2);
        disjointSet.union(2,3);
        disjointSet.union(4,5);
        disjointSet.union(6,7);
        disjointSet.union(5,6);
        disjointSet.union(3,7);

        for (int i = 1; i < 8; i++) {
            System.out.println(disjointSet.findSet(i));
        }
    }

}
