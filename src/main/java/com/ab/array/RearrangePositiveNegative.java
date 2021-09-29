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
        rearrangePosNegWithoutOrder(arr);
        System.out.println(Arrays.toString(arr));

        int arr1[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        rearrangePosNegWithOrder(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    private static void rearrangePosNegWithOrder(int[] arr1) {

    }

    private static void rearrangePosNegWithoutOrder(int[] arr) {
        int negative = 0;//starting index of negative numbers rally
        int postive = Segregate.segregatePosNegQuick(arr);//starting index for positive numbers rally

        while (postive < arr.length && negative < postive && arr[negative] < 0){
            Utils.swapArrayElements(arr,negative,postive);
            negative += 2;
            postive++;
        }
    }

}
