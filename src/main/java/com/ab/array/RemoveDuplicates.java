package com.ab.array;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int arr[] = {10,30,30,40,20,20,50,50};
        System.out.println(isUnique(arr));
        int newLast = removeDuplicates(arr);
        int[] result = Arrays.copyOfRange(arr, 0, newLast);
        System.out.println(Arrays.toString(result));
    }

    public static boolean isUnique(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] == arr[j]){
                    return false;
                }
            }
        }
        return true;
    }
    public static int removeDuplicates(int[] arr) {
        Arrays.sort(arr);

        int n = arr.length;
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
