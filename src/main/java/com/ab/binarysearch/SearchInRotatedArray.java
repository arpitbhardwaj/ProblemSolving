package com.ab.binarysearch;

/**
 * @author Arpit Bhardwaj
 */
public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        //int[] arr = {1, 2, 3, 5, 6, 7, 8, 9, 10};
        //int[] arr = {10, 1, 2, 3, 5, 6, 7, 8, 9};
        System.out.println(recursiveSearch(arr,1,0,arr.length-1));
        System.out.println(search(arr,1));
    }

    private static int search(int[] arr, int target) {
        //find the pivot point at which array is rotated
        int pivot = findPivot(arr,target);
        if (pivot == -1){
            BinarySearch.binarySearch(arr,target);
        }
        return -1;
    }

    private static int findPivot(int[] arr,int target) {
        int start = 0;
        int end = arr.length -1;
        while (start<=end){
            int mid = (start+end)>>>1;

        }
        return -1;
    }


    private static int recursiveSearch(int[] arr, int target, int start, int end) {
        if (start > end){
            return -1;
        }
        int mid = (start+end)>>>1;
        if (arr[mid] == target){
            return mid;
        }
        if (arr[start] <= arr[mid]){
            if (target >= arr[start] && target <= arr[mid]){
                return recursiveSearch(arr,target,start,mid-1);
            }else{
                return recursiveSearch(arr,target,mid+1,end);
            }
        }
        if (target >= arr[mid] && target <= arr[end]){
            return recursiveSearch(arr,target,mid+1,end);
        }
        return recursiveSearch(arr,target,start,mid-1);
    }
}
