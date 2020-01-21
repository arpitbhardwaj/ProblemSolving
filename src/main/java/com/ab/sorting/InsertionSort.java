package com.ab.sorting;

import java.util.Arrays;

/**
 * Space Complexity: O(1)
 * Time Complexity: O(n*2)
 * @author Arpit Bhardwaj
 */
public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {67, 25, 98, 45, 10};
        //int arr[] = {10, 25, 45, 67, 98};//takes minimum time when items are already sorted
        //int arr[] = {98, 67, 45, 25, 10};//takes maximum time when items are sorted in reverse order
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            /*for (;j >= 0 && arr[j] > key;) {
                arr[j + 1] = arr[j];
                j--;
            }*/
            while (j>=0 && arr[j] > key){
                System.out.println("Shifting element " +arr[j]+ " greater than : " + key + " one position ahead");
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
