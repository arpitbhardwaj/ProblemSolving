package com.ab.hashing;

import java.util.HashSet;

/**
 * @author Arpit Bhardwaj
 *
 *  given an array A[] of n numbers and another number x,
 *  1. determines whether there exist two elements in S whose sum is exactly x.
 *
 *  2. find the number of pairs of integers in the array whose sum is equal to ‘sum’.
 */
public class ExactPairSum {
    public static void main(String[] args) {
        int arr[] = { 8, 4, 45, 6, 10, 8 };
        int sum = 16;

        printExactPairSum(arr,sum);
    }

    private static void printExactPairSum(int[] arr, int sum) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int currElement = arr[i];
            int temp = sum - currElement;
            if (hashSet.contains(temp)){
                System.out.println("Pair exist with given sum : " + sum + " is (" + currElement + "," + temp + ")");
            }
            hashSet.add(currElement);
        }
    }
}
