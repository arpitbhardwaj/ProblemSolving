package com.ab.array;

import com.ab.binarysearch.BinarySearch;

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

        int arr2[] = { 8, 4, 45, 6, 10, 8 };
        int product = 24;
        printExactPairProduct(arr2,product);
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

    private static void printExactPairProduct(int[] arr, int product) {
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int y = product/x;
            int j = BinarySearch.recursiveBinarySearch(arr,i+1,n-1,y);
            System.out.println("Pair exist with given product : " + product + " is (" + arr[i] + "," + arr[j] + ")");
        }
    }
}
