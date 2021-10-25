package com.ab.heap;

import com.ab.array.MergeArrays;

import java.util.Arrays;

public class MergeKArrays {
    public static void main(String[] args) {
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
            MergeArrays.mergeTwoSortedArrays(arr[start],arr[end],result);
            return;
        }
        //start divide and merge
        int out1[] = new int[n*(((start+end)/2)-start+1)];
        int out2[] = new int[n*(end-((start+end)/2))];

        //divide the array into halves
        mergeKSortedArrays(arr,start,(start+end)/2,out1);
        mergeKSortedArrays(arr,(start+end)/2+1,end,out2);

        //merge the output array
        MergeArrays.mergeTwoSortedArrays(out1,out2,result);
    }
}
