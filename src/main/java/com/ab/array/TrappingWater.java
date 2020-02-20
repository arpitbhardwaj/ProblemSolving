package com.ab.array;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * Given an array arr[] of N non-negative integers representing height of blocks at index i as Ai where the width of each block is 1.
 * Compute how much water can be trapped in between blocks after raining.
 */
public class TrappingWater {
    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(Arrays.toString(arr));
        int maxWater = trappingWater(arr);
        System.out.println("Max Water : " + maxWater);
    }

    private static int trappingWater(int[] arr) {
        int water = 0;
        int length = arr.length;
        int left[] = new int[length];
        int right[] = new int[length];

        //compute highest bar on left of every bar
        left[0] = arr[0];
        for (int i = 1; i < length; i++) {
            left[i] = Math.max(left[i-1],arr[i]);
        }
        System.out.println(Arrays.toString(left));

        //compute highest bar on right of every bar
        right[length-1] = arr[length-1];
        for (int i = length-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1],arr[i]);
        }
        System.out.println(Arrays.toString(right));

        for (int i = 0; i < length; i++) {
            water += Math.min(left[i],right[i]) - arr[i];
        }
        return water;
    }
}
