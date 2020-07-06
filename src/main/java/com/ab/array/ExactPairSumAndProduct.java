package com.ab.array;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * Two Pointers Pattern
 *
 * This can be solved by sorting as well as hashing technique
 */
public class ExactPairSumAndProduct {
    public static void main(String[] args) {
        int arr[] = { 8, 4, 45, 6, 10, 8 };
        int sum = 16;

        printExactPairSum(arr,sum);
    }

    private static void printExactPairSum(int[] arr, int sum) {
        int n = arr.length;
        int left = 0,right = n - 1;
        Arrays.sort(arr);
        while (right > left){
            if (arr[left] + arr[right] == sum){
                System.out.println("Pair exist with given sum : " + sum + " is (" + arr[left] + "," + arr[right] + ")");
                left++;
                right--;
            }else if (arr[left] + arr[right] < sum){
                left++;
            }else{
                right--;
            }
        }
    }
}
