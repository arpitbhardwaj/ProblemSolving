package com.ab.sorting;

import com.ab.utils.Utils;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 */
public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {67, 25, 98, 45, 10, 55};
        //int arr[] = {10, 25, 45, 67, 98};//takes minimum time when items are already sorted
        //int arr[] = {98, 67, 45, 25, 10};//takes maximum time when items are sorted in reverse order
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low < high){
            int pi = partition(arr,low,high);//find partition index
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        //pick median as pivot
        //int pivotIndex = (low + high) >> 1;
        //int pivot = arr[pivotIndex];

        //pick last as pivot
        int pivotIndex = high;
        int pivot = arr[pivotIndex];

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot){
                i++;
                Utils.swapArrayElements(arr, i, j);
            }
        }

        Utils.swapArrayElements(arr,i+1,pivotIndex);

        return i+1;
    }
}
