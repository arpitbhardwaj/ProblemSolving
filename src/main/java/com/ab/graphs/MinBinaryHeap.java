package com.ab.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Binary Min Heap: The key at root must be minimum among all keys present in Binary Heap.
 *                  The same property must be recursively true for all nodes in Binary Tree.
 *
 * Data structure to support following operations
 * extracMin - O(logn) (Extract and returns the min node value of the heap)
 * min() - Get the heap min value without extracting
 * addToHeap - O(logn) Add key and its weight to the heap
 * containsData - O(1) Checks where the key exists in heap or not
 * decreaseWeight - O(logn) Decreases the weight of given key to newWeight
 * getWeight - O(1) Get the weight of given key
 *
 * It is a combination of binary heap and hash map
 * @author Arpit Bhardwaj
 */
public class MinBinaryHeap<T> {

    private List<Node<T>> allNodes  = new ArrayList<>();
    private Map<T,Integer> nodePosition = new HashMap<>();

    public int calculateParentIndex(int index){
        return (index - 1)/2;
    }

    public boolean empty(){
        return allNodes.size() == 0;
    }

    public void add(T key, int weight) {
        Node<T> node = new Node(key,weight);
        allNodes.add(node);
        int size = allNodes.size();
        int current = size - 1;
        int parentIndex = (current - 1) / 2;
        nodePosition.put(node.key, current);

        while (parentIndex >= 0) {
            Node<T> parentNode = allNodes.get(parentIndex);
            Node<T> currentNode = allNodes.get(current);
            if (parentNode.weight > currentNode.weight) {
                parentNode.swap(currentNode);
                updatePositionMap(parentNode.key,currentNode.key,parentIndex,current);
                current = parentIndex;
                parentIndex = (parentIndex - 1) / 2;
            } else {
                break;
            }
        }
    }

    private void updatePositionMap(T data1, T data2, int pos1, int pos2){
        nodePosition.remove(data1);
        nodePosition.remove(data2);
        nodePosition.put(data1, pos1);
        nodePosition.put(data2, pos2);
    }

    public T min(){
        return allNodes.get(0).key;
    }

    public T extractMin(){
        Node<T> node = extractMinVertex();
        return node.key;
    }

    public Node<T> extractMinVertex(){
        if(allNodes.isEmpty()){
            throw new IllegalStateException("Heap Underflow");
        }

        int size = allNodes.size() - 1;
        Node<T> minNode = new Node<>(allNodes.get(0).key,allNodes.get(0).weight);

        allNodes.get(0).key = allNodes.get(size).key;
        allNodes.get(0).weight = allNodes.get(size).weight;

        nodePosition.remove(minNode.key);
        nodePosition.remove(allNodes.get(0).key);
        nodePosition.put(allNodes.get(0).key,0);

        allNodes.remove(size);

        minHeapify(0);
        return minNode;
    }

    public void minHeapify(int currentIndex) {
        int size = allNodes.size() - 1;
        while (true){
            int leftIndex = 2*currentIndex + 1;
            int rightIndex = 2*currentIndex + 2;
            if(leftIndex > size){
                break;
            }
            if(rightIndex > size){
                rightIndex = leftIndex;
            }
            int smallerIndex = allNodes.get(leftIndex).weight<= allNodes.get(rightIndex).weight
                    ?leftIndex:rightIndex;
            if(allNodes.get(currentIndex).weight > allNodes.get(smallerIndex).weight){
                allNodes.get(currentIndex).swap(allNodes.get(smallerIndex));
                updatePositionMap(allNodes.get(currentIndex).key, allNodes.get(smallerIndex).key, currentIndex,smallerIndex);
                currentIndex = smallerIndex;
            }else{
                break;
            }
        }
    }

    public boolean containsVertex(T key){
        return nodePosition.containsKey(key);
    }

    public Integer getWeight(T key){
        Integer position = nodePosition.get(key);
        if(position != null){
            return allNodes.get(position).weight;
        }
        else{
            return null;
        }
    }

    public void decreaseWeight(T data, int newWeight){
        Integer position = nodePosition.get(data);
        allNodes.get(position).weight = newWeight;

        //perform heapification bottom up starting from current position parent
        int parent = calculateParentIndex(position);
        while (parent >= 0){
            if (allNodes.get(parent).weight > allNodes.get(position).weight){
                allNodes.get(parent).swap(allNodes.get(position));
                updatePositionMap(allNodes.get(parent).key, allNodes.get(position).key,parent,position);
                position = parent;
                parent = calculateParentIndex(parent);
            }else{
                break;
            }
        }
    }
}
