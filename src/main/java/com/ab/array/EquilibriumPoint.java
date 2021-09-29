package com.ab.array;

import java.util.Arrays;

/**
 * Equilibrium position in an array is a position such that
 * the sum of elements before it is equal to the sum of elements after it.
 *
 * Naive Approach : O(n*n)
 * Solve in O(n)
 * @author Arpit Bhardwaj
 */
public class EquilibriumPoint {
    public static void main(String[] args) {
        int[] arr = { -7, 1, 5, 2, -4, 3, 0 };
        //int[] arr = {1, 2, 3};
        int equilibriumIndex = getEquilibriumPoint(arr);
        if(equilibriumIndex == -1){
            System.out.println("Equilibrium index not present in " + Arrays.toString(arr));
        }else{
            System.out.println("Equilibrium index in " + Arrays.toString(arr) + " is " + equilibriumIndex);
        }
    }

    private static int getEquilibriumPoint(int[] arr) {
        //Take sum of whole array
        int totalSum = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            totalSum += arr[i];
        }
        //keep to pointers one to point left elements sum and other to right elements sum
        int leftSum=0;

        for (int i = 0; i < length; i++) {
            totalSum -= arr[i];
            if(leftSum == totalSum){
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }
}
