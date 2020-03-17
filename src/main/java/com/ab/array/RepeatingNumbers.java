package com.ab.array;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any number of times.
 * Find these repeating numbers in O(n) and using only constant memory space.
 * the order in which elements repeat should be maintained. If there is no repeating element present then print -1.
 *
 * Algorithm: Use array elements as index
 */
public class RepeatingNumbers {
    public static void main(String[] args) {
        //int arr[] = {1, 2, 3, 1, 3, 6, 6};//any number of repeating elements
        //int arr[] = {4, 2, 4, 5, 2, 3, 1};//array of n+2 elements. All elements of the array are in range 1 to n (2 elements are duplicate)
        int arr[] = {1, 4, 3, 4, 2};////array of n+1 elements. All elements of the array are in range 1 to n (Find duplicate number)
        System.out.println(Arrays.toString(arr));
        System.out.println("List of repeating elements:");
        printRepeatingNumbers(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void printRepeatingNumbers(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (arr[Math.abs(arr[i])] >= 0){
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            }else {
                System.out.print(Math.abs(arr[i]) + " ");
            }
        }
    }
}
