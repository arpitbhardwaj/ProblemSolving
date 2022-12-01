package com.ab.heap.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * Heap: A Heap is a special Tree-based data structure in which the tree is a complete tree
 *      that satisfies the heap property.
 *
 * Heap properties: 1:It should be a complete tree
 *                  2: either a max heap or min heap
 *
 * Binary Heap: A common implementation of a heap is the binary heap, in which the tree is a binary tree
 *
 * Binary Min Heap: The key at root must be minimum among all keys present in Binary Heap.
 *                  The same property must be recursively true for all nodes in Binary Tree.
 *
 * Binary Max Heap: The key at root must be maximum among all keys present in Binary Heap.
 *                   The same property must be recursively true for all nodes in Binary Tree.
 *
 * A Binary Heap is a Complete Binary Tree. A binary heap is typically represented as an array.
 * For ith node
 * Arr[(i-1)/2]	Returns the parent node
 * Arr[(2*i)+1]	Returns the left child node
 * Arr[(2*i)+2]	Returns the right child node
 *
 * @author Arpit Bhardwaj
 */
public abstract class BinaryHeap<T> {

    List<Node<T>> nodeList = new ArrayList<>();

    public static void printStringHeap(BinaryHeap<String> binaryHeap) {
        for (Node<String> node:
                binaryHeap.nodeList) {
            System.out.println(node.getWeight() + " : " + node.getData());
        }
    }

    public static void printCharacterHeap(BinaryHeap<Character> binaryHeap) {
        for (Node<Character> node:
                binaryHeap.nodeList) {
            System.out.println(node.getWeight() + " : " + node.getData());
        }
    }

    int calculateParentIndex(int index){
        return (index - 1)/2;
    }

    public static BinaryHeap<String> getSampleStringBinaryHeap(BinaryHeap<String> binaryHeap) {
        binaryHeap.insertNode(new Node<>("ram",2));
        binaryHeap.insertNode(new Node<>("shyam",6));
        binaryHeap.insertNode(new Node<>("rita",9));
        binaryHeap.insertNode(new Node<>("gita",3));
        binaryHeap.insertNode(new Node<>("sita",10));
        binaryHeap.insertNode(new Node<>("boom",19));
        return binaryHeap;
    }

    public static BinaryHeap<Character> getSampleCharacterBinaryHeap(BinaryHeap<Character> binaryHeap) {
        binaryHeap.insertNode(new Node<>('A',2));
        binaryHeap.insertNode(new Node<>('B',6));
        binaryHeap.insertNode(new Node<>('C',9));
        binaryHeap.insertNode(new Node<>('D',3));
        binaryHeap.insertNode(new Node<>('E',10));
        binaryHeap.insertNode(new Node<>('F',19));
        return binaryHeap;
    }

    abstract void insertNode(Node<T> node);

    T peek(){
        return nodeList.get(0).data;
    }

    abstract Node<T> extractHead();

    boolean empty(){
        return nodeList.size() == 0;
    }
}
