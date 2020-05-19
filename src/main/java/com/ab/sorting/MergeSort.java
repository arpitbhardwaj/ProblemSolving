package com.ab.sorting;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * worst, average and best: O(nLogn) always divides the array into two halves and take linear time to merge two halves.
 * Auxiliary Space: O(n)
 *
 * MergeSort is preferred over QuickSort for sorting Linked Lists
 * Merge sort accesses data sequentially and the need of random access is low.
 */
public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {67, 25, 98, 45, 10,9,5};
        //int arr[] = {10, 25, 45, 67, 98};//takes minimum time when items are already sorted
        //int arr[] = {98, 67, 45, 25, 10};//takes maximum time when items are sorted in reverse order
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if(low < high) {
           int mid = (low + high) >>> 1;
           mergeSort(arr,low,mid);
           mergeSort(arr,mid+1,high);
           merge(arr,low,mid,high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        //create two temp arrays
        int n1 = mid - low + 1;//+1 for 0 based indexing
        int n2 = high - mid;

        //copy data to temp arrays
        int[] tempArr1 = new int[n1];
        int[] tempArr2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            tempArr1[i] = arr[low + i];
        }
        for (int i = 0; i < n2; i++) {
            tempArr2[i] = arr[mid + 1 + i];
        }

        //copyOfRange has from inclusive and to exclusive
        /*int[] tempArr1 = Arrays.copyOfRange(arr, low, mid +1);
        int[] tempArr2 = Arrays.copyOfRange(arr, mid+1, high+1);*/

        //merge temp arrays back into arr[low, high]
        int i=0,j=0;//i for tempArr1 indexing and j for tempArr2 indexing
        int k =low;//k for original array indexing

        while (i < n1 && j < n2){
            if(tempArr1[i] < tempArr2[j]){
                arr[k] = tempArr1[i];
                i++;
            }else{
                arr[k] = tempArr2[j];
                j++;
            }
            k++;
        }

        //copy remaining elements of temp arrays
        while (i< n1){
            arr[k] = tempArr1[i];
            i++;
            k++;
        }
        while (j < n2){
            arr[k] = tempArr2[j];
            j++;
            k++;
        }
    }
}
