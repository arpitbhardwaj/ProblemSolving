package com.ab.sorting;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 */
public class BubbleSort {
    public static void main(String[] args) {
        //int arr[] = {67, 25, 98, 45, 10};
        int arr[] = {10, 25, 45, 67, 98};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        final int length = arr.length;
        for (int i = 0; i < length - 1/*-1 in order to avoid last element go in loop*/ ; i++) {
            System.out.println("Running Outer Loop : " + i);
            boolean atLeastSingleSwap = false;
            //-i to avoid comparison with last element which is sorted after each cycle
            //-1 as swaps are one less of total elements to be considered for swap
            for (int j = 0; j < length-1-i; j++) {
                System.out.println("Running Inner Loop : " + j);

                if(arr[j] > arr[j+1]){
                    System.out.println("Swap " + arr[j] + " with "+ arr[j+1]);
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    atLeastSingleSwap = true;
                }
            }
            if(!atLeastSingleSwap){
                break;
            }
        }
    }
}
