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
    public void insertNode(Node<T> node) {
        nodeList.add(node);
        int size = nodeList.size();
        int currentIndex = size - 1;
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

    Node<T> extractHead(){
        if(nodeList.isEmpty()){
            throw new IllegalStateException("Heap Underflow");
        }

        int size = nodeList.size() - 1;

        T maxData = nodeList.get(0).getData();
        int maxWeight = nodeList.get(0).getWeight();
        Node<T> maxNode = new Node<>(maxData,maxWeight);

        nodeList.get(0).data = nodeList.get(size).getData();
        nodeList.get(0).weight = nodeList.get(size).getWeight();

        nodeList.remove(size);
        //maxHeapify(0);
        maxHeapifyRecursive(0);
        return maxNode;
    }

    // A recursive function to max heapify the given subtree. This function assumes that the left and
    // right subtrees are already heapified, we only need to fix the root.
    void maxHeapifyRecursive(int currentIndex){
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
            maxHeapifyRecursive(currentIndex);
        }else{
            return;
        }
    }

    // A iterative function to max heapify the given subtree. This function assumes that the left and
    // right subtrees are already heapified, we only need to fix the root.
    void maxHeapify(int currentIndex){
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
}
