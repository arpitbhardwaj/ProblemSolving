package com.ab.array;

import com.ab.utils.Utils;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * Idea is to sort 0 and 2, 1 will already be sorted in the middle
 */
public class SortZeroOneTwo {
    public static void main(String[] args) {
        int[] arr = {0,1,1,0,0,2,2,0,1,0,0,2,2,1,1,1,0};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortArray(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high){
            switch (arr[mid]){
                case 0:
                    Utils.swapArrayElements(arr,low,mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    Utils.swapArrayElements(arr,mid,high);
                    high--;
                    break;
            }
        }
    }
}
