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
}
