package com.ab.array;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * Given a sorted array of positive integers, rearrange the array alternately
 * i.e first element should be the maximum value, second minimum value, third-second max, fourth-second min and so on.
 *
 * Input : [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * Output : [9, 1, 8, 2, 7, 3, 6, 4, 5]
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
        int n = arr.length;
        int min = 0;
        int max = n - 1;
        int maxEle = arr[max] + 1;

        for (int i = 0; i < n; i++) {
            //at even index put max element
            if (i%2 == 0){
                //arr[max_index] is stored as multiplier and “arr[i]” is stored as remainder
                arr[i] += (arr[max--] % maxEle) * maxEle;
            }else{
                arr[i] += (arr[min++] % maxEle) * maxEle;
            }
        }

        System.out.println(Arrays.toString(arr));

        //to fetch remainders in which the actual element stored
        for (int i = 0; i < n; i++) {
            arr[i] /= maxEle;
        }
    }
}
