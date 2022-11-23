package com.ab.array;

/**
 * @author Arpit Bhardwaj
 *
 * You are given a list of n-1 integers and these integers are in the range of 1 to n.
 * There are no duplicates in the list.
 * Find Missing Number
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,9};
        int missingNumber = determineMissingNumber(arr);
        System.out.println(missingNumber);
    }

    private static int determineMissingNumber(int[] arr) {
        int n = arr.length;
        //summation of sequence of n integers n*(n+1)/2
        int sum = (n+1)*(n+2)/2;
        for (int i = 0; i < n; i++) {
            sum -= arr[i];
        }
        return sum;
    }
}
