package com.ab.bitwise;

import java.util.Arrays;

/**
 * This Problem is also called "Alone in couple"
 * Given an array of integers. All numbers occur twice except one number which occurs once.
 * Find the number in O(n) time & constant extra space.
 *
 *  * The best solution is to use XOR. XOR of all array elements gives us the number with single occurrence. The idea is based on following two facts.
 *  * a) XOR of a number with itself is 0.
 *  * b) XOR of a number with 0 is number itself.
 *
 * @author Arpit Bhardwaj
 */
public class FindUnique {
    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 4, 5, 3, 4};
        System.out.println("Unique element in : " + Arrays.toString(arr) + " is " + findUniqueInAllTwice(arr));

        int arr2[] = {3, 3, 2, 3, 2, 2, 9};
        System.out.println("Unique element in : " + Arrays.toString(arr2) + " is " + findUniqueInAllThrice(arr2));
    }

    //if every number appear even times follow this approach
    private static int findUniqueInAllTwice(int[] arr) {
        int element = 0;
        for (int i = 0; i < arr.length; i++) {
            element ^= arr[i];
        }
        return element;
    }

    //if every number appear odd times follow this approach
    //sum the bits in the same positions for all the numbers and take modulo with 3.
    // The bits for which sum is not multiple of 3, are the bits of number with single occurrence.
    private static int findUniqueInAllThrice(int[] arr) {
        final int SIZE = 32;

        int result = 0;

        for (int i = 0; i < SIZE; i++) {
            int sum = 0;
            //get the masked bit
            int x = 1<<i;
            for (int j = 0; j < arr.length; j++) {
                if((arr[j] & x) != 0){
                    sum++;
                }
            }
            if (sum%3 != 0){//taking modulo with 3 as all appears thrice in case all appears 7 times take modulo with 7
                result |= x;//attached that bit with the result
            }
        }
        return result;
    }
}
