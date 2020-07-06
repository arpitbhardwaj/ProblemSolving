package com.ab.divideandconquer;

/**
 * @author Arpit Bhardwaj
 *
 * Given two sorted arrays of size m and n respectively,
 * you are tasked with finding the element that would be at the k’th position of the final sorted array.
 */
public class KthElementInSortedArrays {
    public static void main(String[] args) {
        int arr1[] = {1, 12, 15, 26, 38};
        int arr2[] = {2, 13, 17, 30, 45};
        int k = 5;
        int kthElement = getKthElement(arr1,arr2,k);
        System.out.println(String.format("%sth element is : %s",k,kthElement));
    }

    private static int getKthElement(int[] arr1, int[] arr2, int k) {
        return 0;
    }
}
