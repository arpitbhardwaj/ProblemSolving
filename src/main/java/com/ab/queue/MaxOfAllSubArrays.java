package com.ab.queue;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 *
 * Given an array A and an integer K. Find the maximum for each and every contiguous subarray of size K.
 * This problem is similar to CountDistict in k size window under hashing
 */
public class MaxOfAllSubArrays {
    public static void main(String[] args) {
        //int arr[] =  {12, 1, 78, 90, 57, 89, 56};
        //int arr[] =  {12, 1, 78, 90, 57, 91, 95};
        int[] arr = {1,2,3,1,4,5,2,3,6};
        int k = 3;
        List<Integer> countMax  = countMaxInWindow(arr,3);
        System.out.println(Arrays.toString(arr));
        System.out.println("Count Maximum in window of " + k + " are " + countMax);
    }

    private static List<Integer> countMaxInWindow(int[] arr, int window) {
        List<Integer> results = new ArrayList<>();
        //dequeue will store indexes of array useful elements
        //An element is useful if it is in current window and is greater than all other elements on left side of it in current window
        //Dequeue stores index of max element at front and min element at rear
        Deque<Integer> deque = new LinkedList<>();

        //traverse through the first window
        for (int i = 0; i < window; i++) {
            int currentElement = arr[i];
            // Remove all elements smaller than the currently being added element
            removeUseLessElements(deque, arr, currentElement);
            deque.addLast(i);
        }
        System.out.println(deque);
        // The element at the front of the queue is the largest element of previous window
        results.add(arr[deque.peek()]);

        //traverse through the rest of the elements
        for (int i = window; i < arr.length; i++) {
            int currentElement = arr[i];
            int prevIndex = i-window;
            //Remove the elements which are out of this window
            while (!deque.isEmpty() && (deque.peekFirst() == prevIndex)){
                deque.remove();
            }
            removeUseLessElements(deque,arr, currentElement);
            deque.addLast(i);
            System.out.println(deque);
            results.add(arr[deque.peek()]);
        }

        return results;
    }

    private static void removeUseLessElements(Deque<Integer> deque,int[] arr, int currentElement) {
        while (!deque.isEmpty()
                && currentElement >= arr[deque.peekLast()]) {
            deque.removeLast();
        }
    }
}
