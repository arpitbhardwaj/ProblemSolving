package com.ab.sorting;

import com.ab.utils.Utils;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * Worst and Average: O(n*2)
 * Best : O(n) when array is already sorted
 */
public class BubbleSort {
    public static void main(String[] args) {
        //int arr[] = {67, 25, 98, 45, 10};
        //int arr[] = {10, 25, 45, 67, 98};//takes minimum time when items are already sorted
        int arr[] = {98, 67, 45, 25, 10};//takes maximum time when items are sorted in reverse order
        System.out.println(Arrays.toString(arr));
        //bubbleSort(arr);
        bubbleSortRecursive(arr,arr.length-1,0);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        final int n = arr.length;
        for (int i = 0; i < n - 1/*-1 in order to avoid last element go in loop*/ ; i++) {
            boolean atLeastSingleSwap = false;
            //-i to avoid comparison with last element which is sorted after each cycle
            //-1 as swaps are one less of total elements to be considered for swap
            for (int j = 0; j < n-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    //System.out.println("Swap " + arr[j] + " with "+ arr[j+1]);
                    Utils.swapArrayElements(arr,j,j+1);
                    atLeastSingleSwap = true;
                }
            }
            if(!atLeastSingleSwap){
                break;
            }
        }
    }

    private static void bubbleSortRecursive(int[] arr, int r, int c) {
        if(r==0){
            return;
        }
        if (c<r){
            if (arr[c] > arr[c+1]){
                Utils.swapArrayElements(arr,c,c+1);
            }
            bubbleSortRecursive(arr, r,c+1);
        }else{
            bubbleSortRecursive(arr, r-1,0);
        }
    }
}
