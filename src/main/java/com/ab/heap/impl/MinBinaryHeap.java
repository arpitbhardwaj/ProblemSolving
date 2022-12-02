package com.ab.heap.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * Binary Min Heap: The key at root must be minimum among all keys present in Binary Heap.
 *                  The same property must be recursively true for all nodes in Binary Tree.
 *
 * @author Arpit Bhardwaj
 */
public class MinBinaryHeap<T> extends BinaryHeap<T> {

    public static void main(String[] args) {
        BinaryHeap<Character> binaryHeap = new MinBinaryHeap<>();
        binaryHeap = getSampleCharacterBinaryHeap(binaryHeap);
        printCharacterHeap(binaryHeap);

        MinBinaryHeap<Character> minBinaryHeap = (MinBinaryHeap<Character>) binaryHeap;

        System.out.println("Get Min : " + minBinaryHeap.peek());
        printCharacterHeap(minBinaryHeap);

        Node minNode = minBinaryHeap.extractHead();
        System.out.println("Extract Min Node : " + minNode.getData() + " " + minNode.getWeight());
        printCharacterHeap(minBinaryHeap);
    }

    @Override
    void heapifyBottomToTop(int currentIndex) {
        int parentIndex = calculateParentIndex(currentIndex);

        while (parentIndex >= 0){
            Node<T> currentNode = nodeList.get(currentIndex);
            Node<T> parentNode = nodeList.get(parentIndex);
            if(parentNode.getWeight() > currentNode.getWeight()){
                parentNode.swap(currentNode);
                currentIndex = parentIndex;
                parentIndex = calculateParentIndex(parentIndex);
            }else{
                break;
            }
        }
    }

    @Override
    void heapifyTopToBottom(int currentIndex) {
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
                currentIndex = smallerIndex;
            }else{
                break;
            }
        }
    }

}
