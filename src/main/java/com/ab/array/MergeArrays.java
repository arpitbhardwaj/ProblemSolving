package com.ab.array;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * Time Complexity: O(nklogk)
 * Space Complexity: O(nklogk)
 */
public class MergeArrays {
    public static void main(String[] args) {
        int[] arr1 = {2, 6, 12, 34};
        int[] arr2 = {1, 9, 20, 1000};
        int[] result = new int[arr1.length + arr2.length];
        mergeTwoSortedArrays(arr1,arr2,result);
        System.out.println(Arrays.toString(result));
    }

    public static void mergeTwoSortedArrays(int[] arr1,int[] arr2, int[] result) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        int i=0,j=0;//i for arr1 indexing and j for arr2 indexing
        int k = 0;//k for result array indexing

        while (i < n1 && j < n2){
            if(arr1[i] < arr2[j]){
                result[k] = arr1[i];
                i++;
            }else{
                result[k] = arr2[j];
                j++;
            }
            k++;
        }

        //copy remaining elements of temp arrays
        while (i< n1){
            result[k] = arr1[i];
            i++;
            k++;
        }
        while (j < n2){
            result[k] = arr2[j];
            j++;
            k++;
        }
    }
}
