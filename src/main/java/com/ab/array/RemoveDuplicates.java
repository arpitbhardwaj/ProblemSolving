package com.ab.array;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int arr[] = {10,20,20,30,30,40,50,50};
        int newLast = removeDuplicates(arr);
        int[] result = Arrays.copyOfRange(arr, 0, newLast);
        System.out.println(Arrays.toString(result));
    }

    public static int removeDuplicates(int[] arr) {
        //sort the array
        Arrays.sort(arr);
        int n = arr.length;
        if (n <= 1){
            return n;
        }
        int next = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i+1]){
                arr[next++] = arr[i];
            }
        }
        //put last element
        arr[next++] = arr[n-1];
        return next;
    }
}
