package com.ab.sorting;

import com.ab.utils.Utils;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * Time complexity : O(nLogn)
 */
public class HeapSort {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int arr[] = {67, 25, 98, 45, 10,9,5};
        //int arr[] = {10, 25, 45, 67, 98};//takes minimum time when items are already sorted
        //int arr[] = {98, 67, 45, 25, 10};//takes maximum time when items are sorted in reverse order
        System.out.println(Arrays.toString(arr));
        heapSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void heapSort(int[] arr) {
        int length = arr.length;
        int startIndex = (length / 2) - 1;
        //build heap from bottom up ignoring leaf nodes as they are already heapified.
        for (int i = startIndex; i >= 0 ; i--) {
            maxHeapifyRecursive(arr,length-1,i);
            //maxHeapifyIterative(arr,length,i);
        }

        /*for (int i = 1; i < length ; i++) {
            heapAdd(arr, i);
        }*/

        //replace array last element with first element, then do heapify at first one
        for (int i = length - 1; i >= 0; i--) {
            Utils.swapArrayElements(arr, i,0);
            maxHeapifyRecursive(arr,i-1,0);
            //maxHeapifyIterative(arr,i-1,0);
        }
    }

    // A recursive function to max heapify the given subtree. This function assumes that the left and
    // right subtrees are already heapified, we only need to fix the root.
    public void maxHeapifyRecursive(int[] arr, int length,int currentIndex){
        //int size = arr.length - 1;
        int leftIndex = 2*currentIndex + 1;
        int rightIndex = 2*currentIndex + 2;

        if(leftIndex > length){
            return;
        }

        if(rightIndex > length){
            rightIndex = leftIndex;
        }

        int largerIndex = arr[leftIndex] >= arr[rightIndex]
                ?leftIndex:rightIndex;
        if(arr[currentIndex] < arr[largerIndex]){
            Utils.swapArrayElements(arr, currentIndex,largerIndex);
            maxHeapifyRecursive(arr,length,largerIndex);
        }
    }

    private void maxHeapifyIterative(int arr[], int end,int currentIndex){
        int i = currentIndex;
        int leftIndex;
        int rightIndex;
        while(i <= end){
            leftIndex = 2*i + 1;
            if(leftIndex > end){
                break;
            }
            rightIndex = 2*i + 2;
            if(rightIndex > end){
                rightIndex = leftIndex;
            }
            if(arr[i]  >= Math.max(arr[leftIndex], arr[rightIndex])){
                break;
            }
            if(arr[leftIndex] >= arr[rightIndex]){
                Utils.swapArrayElements(arr, i, leftIndex);
                i = leftIndex;
            }else{
                Utils.swapArrayElements(arr, i, rightIndex);
                i = rightIndex;
            }
        }
    }

    private void heapAdd(int arr[], int end){
        int i = end;
        while(i > 0){
            if(arr[i] > arr[(i-1)/2]){
                Utils.swapArrayElements(arr, i, (i-1)/2);
                i = (i - 1)/2;
            }else{
                break;
            }
        }
    }
}
