package com.ab.array;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * Given a sorted array and a number x, find a pair in array whose sum is closest to x.
 * Given a sorted array and a number x, find a pair in array whose product is closest to x.
 */
public class ClosestPairSumAndProduct {
    public static void main(String[] args) {
        int arr[] = {40, 29, 28, 22, 30, 10};
        int sum = 54;
        printClosestPairSum(arr,sum);
    }

    private static void printClosestPairSum(int[] arr, int sum) {
        int n = arr.length;
        int resLeft = 0, resRight = 0;
        int left = 0,right = n - 1;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        while (right > left){
            if (Math.abs(arr[left] + arr[right] - sum) < diff){
                diff = Math.abs(arr[left] + arr[right] - sum);
                resLeft = left;
                resRight = right;
            }else if ((arr[left] + arr[right]) < sum){
                left++;
            }else{
                right--;
            }
        }
        System.out.println("Closest Pair exist with given sum : " + sum + " is (" + arr[resLeft] + "," + arr[resRight] + ")");
    }
}
