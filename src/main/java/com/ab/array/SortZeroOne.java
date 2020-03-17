package com.ab.array;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * Solve in single traverse through the array
 * Counting 0 or 1s will solve in double pass
 *
 * Variation of famous Dutch national flag problem.
 */
public class SortZeroOne {
    public static void main(String[] args) {
        int[] arr = {0,1,1,0,0,1,1,0,1,0,0,1,1,1,1,1,0};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortArray(int[] arr) {
        int length = arr.length;
        int leftIndex = 0;
        int rightIndex = length - 1;
        while (leftIndex < rightIndex){
            while (arr[leftIndex] == 0){
                leftIndex++;
            }
            while (arr[rightIndex] == 1){
                rightIndex--;
            }
            if(arr[leftIndex] > arr[rightIndex]){
                arr[leftIndex] = 0;
                arr[rightIndex] = 1;
            }

            leftIndex++;
            rightIndex--;
        }
    }
}
