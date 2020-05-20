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

        int arr[][] = {     {2, 6, 12, 34},
                            {1, 9, 20, 1000},
                            {23, 24, 90, 2000}
                        };//array of sorted arrays
        int k = arr.length;
        int n = arr[0].length;
        int[] result1 = new int[n*k];
        mergeKSortedArrays(arr,0, 2, result1);
        System.out.println(Arrays.toString(result1));
    }

    private static void mergeTwoSortedArrays(int[] arr1,int[] arr2, int[] result) {
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

    private static void mergeKSortedArrays(int[][] arr,int start, int end, int[] result) {
        //crux is to consider this as the middle of merge sort
        int n = arr[0].length;
        //base condition
        //if one array left in array of array matrix
        if (start == end){
            for (int i = 0; i < n; i++) {
                result[i] = arr[start][i];
            }
            return;
        }
        //if two array left in array of array matrix
        if (end - start == 1){
            mergeTwoSortedArrays(arr[start],arr[end],result);
            return;
        }
        //start divide and merge
        int out1[] = new int[n*(((start+end)/2)-start+1)];
        int out2[] = new int[n*(end-((start+end)/2))];

        //divide the array into halves
        mergeKSortedArrays(arr,start,(start+end)/2,out1);
        mergeKSortedArrays(arr,(start+end)/2+1,end,out2);

        //merge the output array
        mergeTwoSortedArrays(out1,out2,result);
    }
}
