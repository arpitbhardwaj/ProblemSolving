package com.ab.array;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * A majority element in an array A[] of size n is an element that appears more than n/2 times
 *
 * Naive Approach: O(n*n) O(1)
 * Binary Tree: O(n*n)
 * self-balancing-binary-search tree: O(nlogn)
 * Moore’s Voting Algorithm : O(n), O(1)
 * Hashing: O(n), O(n)
 */
public class MajorityElement {
    public static void main(String[] args) {
        //int[] arr = {2, 2, 3, 5, 2, 2, 6};
        int[] arr = {2, 8, 3, 5, 2, 2, 6};
        int majorityElement = getMajorityElement(arr);
        if(majorityElement == -1){
            System.out.println("Majority element not present in " + Arrays.toString(arr));
        }else{
            System.out.println("Majority element in " + Arrays.toString(arr) + " is " + majorityElement);
        }
    }

    private static int getMajorityElement(int[] arr) {
        int candidate = findCandidate(arr);
        if(isMajority(arr,candidate)){
            return candidate;
        }
        return -1;
    }

    private static boolean isMajority(int[] arr, int candidate) {
        int count = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if(arr[i] == candidate){
                count++;
            }
        }
        if(count > (length / 2)){
            return true;
        }
        return false;
    }

    private static int findCandidate(int[] arr) {
        int majIndex = 0;
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if(arr[majIndex] == arr[i]){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                count = 1;
                majIndex = i;
            }
        }
        return arr[majIndex];
    }
}
