package com.ab.hashing;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * Given an array A[] and positive integer K,
 * the task is to count total number of pairs in the array whose sum is divisible by K.
 */
public class PairSumDivisibility {
    public static void main(String[] args) {
        int arr[] = { 2, 2, 1, 7, 5, 3 };
        int sum = 4;
        int count = pairSumDivisibleCount(arr,sum);
        System.out.println(Arrays.toString(arr));
        System.out.println(String.format("No of Pairs divisible by %s are %s",sum,count));
    }

    private static int pairSumDivisibleCount(int[] arr, int sum) {

        return 0;
    }
}
