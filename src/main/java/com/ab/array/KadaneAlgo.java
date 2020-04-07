package com.ab.array;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
 */
public class KadaneAlgo {
    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int largestSum = getLargestContiguousSum(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Largest sum of contiguous sub array: " + largestSum);
    }

    public static int getLargestContiguousSum(int[] arr) {
        int maxEndingHere = 0;
        int maxSoFar = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            maxEndingHere += arr[i];
            if (maxEndingHere > maxSoFar){
                maxSoFar = maxEndingHere;
            }
            if (maxEndingHere < 0){
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }
}
