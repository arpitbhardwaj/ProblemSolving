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
public class AppearOnceInAllTwice {
    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 4, 5, 3, 4};
        int element = getElementAppearOnce(arr);
        System.out.println("Number which occurs once in : " + Arrays.toString(arr) + " is " + element);
    }

    private static int getElementAppearOnce(int[] arr) {
        int element = 0;
        for (int i = 0; i < arr.length; i++) {
            element ^= arr[i];
        }
        return element;
    }
}
