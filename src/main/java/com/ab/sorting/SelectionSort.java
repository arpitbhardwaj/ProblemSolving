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
        //selectionSort(arr);
        selectionSortRecursive(arr,arr.length,0,0);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1 /*-1 in order to avoid last element go in loop*/; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            //swap 2 variables (first element of considered window with minimum one)
            Utils.swapArrayElements(arr,minIndex,i);
        }
    }

    private static void selectionSortRecursive(int[] arr, int r, int c, int maxIndex) {
        if(r==0){
            return;
        }
        if (c<r){
            if(arr[maxIndex] < arr[c]){
                maxIndex = c;
            }
            selectionSortRecursive(arr, r,c+1, maxIndex);
        }else{
            Utils.swapArrayElements(arr,maxIndex, r-1);
            selectionSortRecursive(arr, r-1,0,0);
        }
    }
}
