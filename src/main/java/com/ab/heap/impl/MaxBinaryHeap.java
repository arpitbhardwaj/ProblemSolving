package com.ab.heap.impl;

/**
 * Binary Max Heap: The key at root must be maximum among all keys present in Binary Heap.
 *                  The same property must be recursively true for all nodes in Binary Tree.
 *
 * @author Arpit Bhardwaj
 */
public class MaxBinaryHeap<T> extends BinaryHeap<T> {

    public static void main(String[] args) {
        BinaryHeap<Character> binaryHeap = new MaxBinaryHeap<>();
        binaryHeap = getSampleCharacterBinaryHeap(binaryHeap);
        printCharacterHeap(binaryHeap);

        MaxBinaryHeap<Character> maxBinaryHeap = (MaxBinaryHeap<Character>) binaryHeap;

        System.out.println("Get Max : " + maxBinaryHeap.peek());
        printCharacterHeap(maxBinaryHeap);

        Node maxNode = maxBinaryHeap.extractHead();
        System.out.println("Extract Max Node : " + maxNode.getData() + " " + maxNode.getWeight());
        printCharacterHeap(maxBinaryHeap);
    }

    @Override
    void heapifyBottomToTop(int currentIndex) {
        int parentIndex = calculateParentIndex(currentIndex);
        while (parentIndex >= 0){
            Node<T> currentNode = nodeList.get(currentIndex);
            Node<T> parentNode = nodeList.get(parentIndex);
            if(parentNode.getWeight() < currentNode.getWeight()){
                parentNode.swap(currentNode);
                currentIndex = parentIndex;
                parentIndex = calculateParentIndex(parentIndex);
            }else{
                break;
            }
        }
    }

    void heapifyBottomToTopRecursive(int currentIndex) {
        if (currentIndex <= 1){
            return;
        }
        int parentIndex = calculateParentIndex(currentIndex);

        Node<T> currentNode = nodeList.get(currentIndex);
        Node<T> parentNode = nodeList.get(parentIndex);
        if(parentNode.getWeight() < currentNode.getWeight()){
            parentNode.swap(currentNode);
        }
        heapifyBottomToTopRecursive(parentIndex);
    }

    // A iterative function to max heapify the given subtree. This function assumes that the left and
    // right subtrees are already heapified, we only need to fix the root.
    @Override
    void heapifyTopToBottom(int currentIndex){
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
            int largerIndex = nodeList.get(leftIndex).getWeight() >= nodeList.get(rightIndex).getWeight()
                    ?leftIndex:rightIndex;
            if(nodeList.get(currentIndex).getWeight() < nodeList.get(largerIndex).getWeight()){
                nodeList.get(currentIndex).swap(nodeList.get(largerIndex));
                currentIndex = largerIndex;
            }else{
                break;
            }
        }
    }

    // A recursive function to max heapify the given subtree. This function assumes that the left and
    // right subtrees are already heapified, we only need to fix the root.
    void heapifyTopToBottomRecursive(int currentIndex){
        int size = nodeList.size() - 1;
        int leftIndex = 2*currentIndex + 1;
        int rightIndex = 2*currentIndex + 2;
        if(leftIndex > size){
            return;
        }
        if(rightIndex > size){
            rightIndex = leftIndex;
        }
        int largerIndex = nodeList.get(leftIndex).getWeight() >= nodeList.get(rightIndex).getWeight()
                ?leftIndex:rightIndex;
        if(nodeList.get(currentIndex).getWeight() < nodeList.get(largerIndex).getWeight()){
            nodeList.get(currentIndex).swap(nodeList.get(largerIndex));
            currentIndex = largerIndex;
            heapifyTopToBottomRecursive(currentIndex);
        }else{
            return;
        }
    }
}
