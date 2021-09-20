package com.ab.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Arpit Bhardwaj
 *
 * Given an array of integers, find the length of the longest subarray with sum equals to 0.
 *
 * Naive: O(n2)
 * Hashing: O(n) the assumption that good hashing function that allows insertion and retrieval operations in O(1) time.
 */
public class ZeroSubArray {
    public static void main(String[] args) {
        //int[] arr = {15,-2,2,-8,1,7,10,23};
        //int[] arr = {15,-2,2,-8,1,7,10,23,-10,-23};
        int[] arr = {0,15,-2,2,-8,1,7,10,23};
        //int[] arr = {1, 2, 3};
        //int[] arr = {1, 0, 3};
        int maxLength = getMaxLengthZeroSubArray(arr);
        System.out.println("Length of the longest sub array with sum equals to 0 in " + Arrays.toString(arr) + " is : " + maxLength);
    }

    private static int getMaxLengthZeroSubArray(int[] arr) {
        Map<Integer, Integer> sumMapIndex = new HashMap<>();
        int maxLength = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sumMapIndex.containsKey(sum)){
                maxLength = i-sumMapIndex.get(sum);
            }else{
                sumMapIndex.put(sum,i);
            }
        }
        return maxLength;
    }
}
