package com.ab.bitwise;

/**
 * @author Arpit Bhardwaj
 *
 * Given an array where every element occurs three times, except one element which occurs only once
 *
 * ones: The bits that have appeared 1st time or 4th time or 7th time .. etc.
 * twos: The bits that have appeared 2nd time or 5th time or 8th time .. etc.
 */
public class AppearOnceInAllThrice {
    public static void main(String[] args) {
        int arr[] = {3, 3, 2, 3, 9, 9, 9};
        int element = findSingle(arr);
        System.out.println("single occurred element is : " + element);
    }

    private static int findSingle(int[] arr) {
        int ones = 0;
        int twos = 0;
        int common_bit_mask;

        for (int i = 0; i < arr.length; i++) {
            twos = twos | (ones & arr[i]);
            ones = ones ^ arr[i];
            common_bit_mask = ~(ones & twos);
            ones &= common_bit_mask;
            twos &= common_bit_mask;
        }
        return ones;
    }
}
