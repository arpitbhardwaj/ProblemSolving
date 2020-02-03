package com.ab.array;

/**
 * @author Arpit Bhardwaj
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
