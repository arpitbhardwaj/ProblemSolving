package com.ab.sorting;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * TimSort is a sorting algorithm based on Insertion Sort and Merge Sort.
 * First sort small pieces using Insertion Sort, then merges the pieces using merge of merge sort.
 *
 * We divide the Array into blocks known as Run.
 * We sort those runs using insertion sort one by one and then merge those runs using combine function used in merge sort.
 * If the size of Array is less than run, then Array get sorted just by using Insertion Sort.
 * The size of run may vary from 32 to 64 depending upon the size of the array.
 * Note that merge function performs well when sizes subarrays are powers of 2.
 * The idea is based on the fact that insertion sort performs well for small arrays.
 */
public class TimSort {
    static int run = 8;//ideally should be starting from 32
    public static void main(String[] args) {
        int arr[] = {67, 25, 98, 45, 10, 2, 90, 55, 11, 21};
        //int arr[] = {10, 25, 45, 67, 98};//takes minimum time when items are already sorted
        //int arr[] = {98, 67, 45, 25, 10};//takes maximum time when items are sorted in reverse order
        System.out.println(Arrays.toString(arr));
        timSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void timSort(int[] arr) {
        int length = arr.length;
        //sort arrays using insertion sort of size run
        for (int i = 0; i < length; i += run) {
            int startIndex = i;
            int endIndex = Math.min((i+(run - 1)),length - 1);
            InsertionSort.insertionSortUtil(arr, startIndex, endIndex);
        }

        //start merging chunks of size run
        for (int size = run; size < length; size *= 2) {

            for (int leftIndex = 0; leftIndex < length; leftIndex += 2*size) {

                int midIndex = leftIndex + size - 1;
                int rightIndex = Math.min((leftIndex + 2*size - 1), length - 1);
                System.out.println(String.format("Merge Started StartIndex %s midIndex %s endIndex %s",leftIndex,midIndex,rightIndex));
                MergeSort.merge(arr,leftIndex,midIndex,rightIndex);
            }
        }
    }

}
