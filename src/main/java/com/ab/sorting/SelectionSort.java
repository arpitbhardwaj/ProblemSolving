package com.ab.sorting;

import com.ab.utils.Utils;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 * repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning.
 * Time Complexity : O(n*2)
 * The good thing about it never makes more than O(n) swaps and can be useful when memory write is a costly operation.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {67, 25, 98, 45, 10};
        //int arr[] = {10, 25, 45, 67, 98};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        int arr_length = arr.length;
        for (int i = 0; i < arr_length - 1 /*-1 in order to avoid last element go in loop*/; i++) {
            int minIndex = i;
            System.out.println("Running Loop : " + i);
            //find minimum element in unsorted array
            for (int j = i+1; j < arr_length; j++) {
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            //swap 2 variables (first element of considered window with minimum one)
            Utils.swapArrayElements(arr,minIndex,i);
        }
    }
}
