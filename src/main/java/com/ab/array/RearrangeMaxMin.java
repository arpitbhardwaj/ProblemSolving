package com.ab.array;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * Given a sorted array of positive integers, rearrange the array alternately
 * i.e first element should be the maximum value, second minimum value, third-second max, fourth-second min and so on.
 */
public class RearrangeMaxMin {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
        //int arr[] = {10, 25, 45, 67, 98};
        System.out.println(Arrays.toString(arr));
        rearrangeMaxMin(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void rearrangeMaxMin(int[] arr) {
        int length = arr.length;
        int minIndex = 0;
        int maxIndex = length - 1;
        int maxElement = arr[maxIndex] + 1;

        for (int i = 0; i < length; i++) {
            //at even index put max element
            if (i%2 == 0){
                arr[i] += (arr[maxIndex--] % maxElement) * maxElement;
                //arr[max_index] is stored as multiplier and “arr[i]” is stored as remainder
            }else{
                arr[i] += (arr[minIndex++] % maxElement) * maxElement;
            }
        }

        System.out.println(Arrays.toString(arr));

        //to fetch multipliers
        for (int i = 0; i < length; i++) {
            arr[i] /= maxElement;
        }

        //to fetch remainders
        /*for (int i = 0; i < length; i++) {
            arr[i] %= maxElement;
        }*/
    }
}
