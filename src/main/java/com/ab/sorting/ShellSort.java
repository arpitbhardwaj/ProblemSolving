package com.ab.sorting;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * A Sorting Algorithm is used to rearrange a given array or list elements according to a comparison operator on the elements.
 */
public class ShellSort {
    public static void main(String[] args) {
        //int arr[] = {67, 25, 98, 45, 10};
        //int arr[] = {10, 25, 45, 67, 98};//takes minimum time when items are already sorted
        int arr[] = {98, 67, 45, 25, 10};//takes maximum time when items are sorted in reverse order
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int[] arr) {
        int length = arr.length;
        for (int gap = length/2; gap > 0 ; gap /= 2) {
            System.out.println("Starting gap : " + gap);
            for (int i = gap; i < length; i++) {
                int key = arr[i];
                int j = i;
                //start comparing jth index with jth - gap index element and keep decreasing j by an interval of gap
                while (j>=gap && arr[j-gap] > key){
                    System.out.println("Shifting element since " +arr[j - gap]+ " greater than " + key + " one position ahead");
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = key;
                System.out.println("During gap : " + gap + " insertions " + Arrays.toString(arr));
            }
        }
    }
}
