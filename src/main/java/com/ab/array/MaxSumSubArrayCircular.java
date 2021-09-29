package com.ab.array;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * Given n numbers (both +ve and -ve), arranged in a circle, fnd the maximum sum of consecutive number.
 *
 * Algo: find sum of non-contributing elements which are non wrapping and subtract this sum from the total sum
 *       which eventually gives us the wrapping sum of contributing elements.
 */
public class MaxSumSubArrayCircular {
    public static void main(String[] args) {
        int arr[] =  {11, 10, -20, 5, -3, -5, 8, -13, 10};
        int largestSum = getLargestCircularSubArraySum(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Largest circular sum of contiguous sub array: " + largestSum);
    }

    private static int getLargestCircularSubArraySum(int[] arr) {
        int length = arr.length;

        int maxKadane = KadaneAlgo.getLargestContiguousSum(arr);

        int maxWrap = 0;//total array sum

        for (int i = 0; i < length; i++) {
            maxWrap += arr[i];
            arr[i] = -arr[i];//invert the array elements
        }

        //find the maximum continuous negative that implies maximum continuous positive in the inverted arrays
        int maxInvertedKadane = KadaneAlgo.getLargestContiguousSum(arr);
        //total sum array - ( - max subarray sum of inverted array)
        maxWrap = maxWrap + maxInvertedKadane;

        return maxWrap > maxKadane ? maxWrap : maxKadane;
    }
}
