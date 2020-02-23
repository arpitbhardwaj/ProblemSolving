package com.ab.array;

import com.ab.utils.Utils;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * Given an array of positive and negative numbers,
 * arrange them in an alternate fashion such that every positive number is followed by negative and vice-versa.
 *
 * Order of elements in output doesn’t matter. Extra positive or negative elements should be moved to end.
 */
public class RearrangePositiveNegative {
    public static void main(String[] args) {
        int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        System.out.println(Arrays.toString(arr));
        rearrangePositiveNegative(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void rearrangePositiveNegative(int[] arr) {

        //quick sort logic to partition by considering 0 as pivot
        int pivot = 0;
        int low = 0;
        int high = arr.length - 1;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot){
                i++;
                Utils.swapArrayElements(arr, i, j);
            }
        }
        System.out.println(Arrays.toString(arr));

        int negativeIndex = 0;
        int positiveIndex = i + 1;

        while (positiveIndex < high
        && negativeIndex < positiveIndex
        && arr[negativeIndex] < 0){
            Utils.swapArrayElements(arr,negativeIndex,positiveIndex);
            negativeIndex += 2;
            positiveIndex++;
        }
    }
}
