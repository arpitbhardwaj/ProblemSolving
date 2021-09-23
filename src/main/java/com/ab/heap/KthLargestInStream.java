package com.ab.heap;

import java.util.PriorityQueue;

/**
 * @author Arpit Bhardwaj
 *
 * Given an input stream of n integers, find the kth the largest element for each element in the stream.
 */
public class KthLargestInStream {

    PriorityQueue<Integer> queue;
    int capacity;

    public KthLargestInStream(int k, int[] nums) {
        capacity = k;
        queue = new PriorityQueue<>(k);
        for(int n : nums){
            add(n);
        }
    }

    public int add(int val) {
        if(queue.size() < capacity){
            queue.add(val);
        }else if(val > queue.peek()){
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargestInStream kthLargest = new KthLargestInStream(2,new int[]{4,2,8,5});
        System.out.println(kthLargest.add(3));
    }

}
