package com.ab.heap.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * Binary Min Heap: The key at root must be minimum among all keys present in Binary Heap.
 *                  The same property must be recursively true for all nodes in Binary Tree.
 *
 * Data structure to support following operations
 *      extracHead - O(logn) (Extract and returns the min node value of the heap)
 *      peek() - Get the heap min value without extracting
 *      addToHeap - O(logn) Add key and its weight to the heap
 *      containsData - O(1) Checks where the key exists in heap or not
 *      decreaseWeight - O(logn) Decreases the weight of given key to newWeight
 *      getWeight - O(1) Get the weight of given key
 *
 * It is a combination of binary heap and hash map
 *
 * @author Arpit Bhardwaj
 */
public class MinBinaryHeap<T> extends BinaryHeap<T> {

    private Map<T,Integer> nodePosition = new HashMap<>();

    public static void main(String[] args) {
        BinaryHeap<Character> binaryHeap = new MinBinaryHeap<>();
        binaryHeap = getSampleCharacterBinaryHeap(binaryHeap);
        printCharacterHeap(binaryHeap);

        MinBinaryHeap<Character> minBinaryHeap = (MinBinaryHeap<Character>) binaryHeap;

        System.out.println("Get Min : " + minBinaryHeap.peek());
        printCharacterHeap(minBinaryHeap);
        System.out.println(minBinaryHeap.nodePosition);

        Node minNode = minBinaryHeap.extractHead();

        System.out.println("Extract Min Node : " + minNode.getData() + " " + minNode.getWeight());
        System.out.println(minBinaryHeap.nodePosition);
        printCharacterHeap(minBinaryHeap);
    }

    public void insertNode(Node<T> node) {
        nodeList.add(node);
        int size = nodeList.size();
        int currentIndex = size - 1;
        int parentIndex = calculateParentIndex(currentIndex);

        nodePosition.put(node.data,currentIndex);

        while (parentIndex >= 0){
            Node<T> currentNode = nodeList.get(currentIndex);
            Node<T> parentNode = nodeList.get(parentIndex);
            if(parentNode.getWeight() > currentNode.getWeight()){
                parentNode.swap(currentNode);
                currentIndex = parentIndex;
                updatePositionMap(parentNode.data, currentNode.data, parentIndex,currentIndex);
                parentIndex = calculateParentIndex(parentIndex);
            }else{
                break;
            }
        }
    }

    private void updatePositionMap(T data1, T data2, int parentIndex, int currentIndex) {
        nodePosition.remove(data1);
        nodePosition.remove(data2);
        nodePosition.put(data1,parentIndex);
        nodePosition.put(data2,currentIndex);
    }

    Node<T> extractHead(){
        if(nodeList.isEmpty()){
            throw new IllegalStateException("Heap Underflow");
        }

        int size = nodeList.size() - 1;

        T minData = nodeList.get(0).getData();
        int minWeight = nodeList.get(0).getWeight();
        Node<T> minNode = new Node<>(minData,minWeight);

        nodeList.get(0).data = nodeList.get(size).getData();
        nodeList.get(0).weight = nodeList.get(size).getWeight();

        nodePosition.remove(minData);
        nodePosition.remove(nodeList.get(0).data);
        nodePosition.put(nodeList.get(0).data,0);

        nodeList.remove(size);

        minHeapify(0);
        return minNode;
    }

    void minHeapify(int currentIndex) {
        int size = nodeList.size() - 1;
        while (true){
            int leftIndex = 2*currentIndex + 1;
            int rightIndex = 2*currentIndex + 2;
            if(leftIndex > size){
                break;
            }
            if(rightIndex > size){
                rightIndex = leftIndex;
            }
            int smallerIndex = nodeList.get(leftIndex).getWeight() <= nodeList.get(rightIndex).getWeight()
                    ?leftIndex:rightIndex;
            if(nodeList.get(currentIndex).getWeight() > nodeList.get(smallerIndex).getWeight()){
                nodeList.get(currentIndex).swap(nodeList.get(smallerIndex));
                updatePositionMap(nodeList.get(currentIndex).getData(), nodeList.get(smallerIndex).getData(), currentIndex,smallerIndex);
                currentIndex = smallerIndex;
            }else{
                break;
            }
        }
    }

    public boolean containsData(T data){
        return nodePosition.containsKey(data);
    }

    public Integer getWeight(T data){
        Integer position = nodePosition.get(data);
        if(position != null){
            return nodeList.get(position).getWeight();
        }
        else{
            return null;
        }
    }

    public void decreaseWeight(T data, int newWeight){
        Integer position = nodePosition.get(data);
        nodeList.get(position).weight = newWeight;

        //perform heapification bottom up starting from current position parent
        int parent = calculateParentIndex(position);
        while (parent >= 0){
            if (nodeList.get(parent).getWeight() > nodeList.get(position).getWeight()){
                nodeList.get(parent).swap(nodeList.get(position));
                updatePositionMap(nodeList.get(parent).getData(),nodeList.get(position).getData(),parent,position);
                position = parent;
                parent = calculateParentIndex(parent);
            }else{
                break;
            }
        }
    }
}
