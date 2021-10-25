package com.ab.array;

import com.ab.utils.Utils;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * Variation of famous Dutch national flag problem.
 *
 * Solve in single traverse through the array
 *  Counting 0 or 1s will solve in double pass
 *
 * Idea is to sort 0 and 2, 1 will already be sorted in the middle
 */
public class SortZeroOneTwo {
    public static void main(String[] args) {
        int[] arr = {0,1,1,0,0,1,1,0,1,0,0,1,1,1,1,1,0};
        sortZeroOne(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {0,1,1,0,0,2,2,0,1,0,0,2,2,1,1,1,0};
        sortZeroOneTwo(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    private static void sortZeroOne(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left < right){
            //keep searching for 1 from the left by incrementing left index
            while (arr[left] == 0){
                left++;
            }
            //keep searching for 0 from the left by incrementing left index
            while (arr[right] == 1){
                right--;
            }
            //once found swap it
            if(arr[left] > arr[right]){
                arr[left] = 0;
                arr[right] = 1;
            }

            left++;
            right--;
        }
    }

    private static void sortZeroOneTwo(int[] arr) {
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
