package com.ab.sorting;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 *  Radix Sort is to do digit by digit sort starting from least significant digit to most significant digit.
 *  Radix sort uses counting sort as a subroutine to sort.
 */
public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        for (int exp = 1; max/exp >0 ; exp *= 10) {
            countingSortUtil(arr,exp);
        }
    }


    public static void countingSortUtil(int[] arr,int exp) {
        int length = arr.length;
        //int max = Arrays.stream(arr).max().getAsInt();
        //int min = Arrays.stream(arr).min().getAsInt();
        //int range = max - min + 2;
        int range = 10;
        int freq[] = new int[range];
        int output[] = new int[length];

        System.out.println(Arrays.toString(freq));

        for (int i = 0; i < length; i++) {
            freq[(arr[i]/exp) % 10]++;
        }

        System.out.println(Arrays.toString(freq));

        for (int i = 1; i < range; i++) {
            freq[i] += freq[i-1];
        }

        System.out.println(Arrays.toString(freq));

        for (int i = length-1; i >=0 ; i--) {
            output[freq[(arr[i]/exp) % 10]-- - 1] = arr[i];
        }

        for (int i = 0; i < length; i++) {
            arr[i] = output[i];
        }
    }
}
