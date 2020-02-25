package com.ab.sorting;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * Counting sort is a sorting technique based on keys between a specific range.
 * Counting sort is a linear time sorting algorithm that sort in O(n+k) time when elements are in range from 1 to k.
 */
public class CountingSort {
    public static void main(String[] args) {
        int arr[] = {1, 4, 1, 2, 7, 5, 2};
        //int[] arr = {-5, -10, 0, -3, 8, 5, -1, 10};
        System.out.println(Arrays.toString(arr));
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void countingSort(int[] arr) {
        int length = arr.length;
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        int range = max - min + 2;
        int freq[] = new int[range];
        int output[] = new int[length];

        System.out.println(Arrays.toString(freq));

        for (int i = 0; i < length; i++) {
            freq[arr[i]]++;
        }

        System.out.println(Arrays.toString(freq));

        for (int i = 1; i < range; i++) {
            freq[i] += freq[i-1];
        }

        System.out.println(Arrays.toString(freq));

        for (int i = length-1; i >=0 ; i--) {
            output[freq[arr[i]]-- - 1] = arr[i];
        }

        for (int i = 0; i < length; i++) {
            arr[i] = output[i];
        }
    }
}
