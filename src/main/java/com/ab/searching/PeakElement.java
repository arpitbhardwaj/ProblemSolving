package com.ab.searching;

/**
 * @author Arpit Bhardwaj
 *
 * Given an array of integers. Find a peak element in it. An array element is peak if it is NOT smaller than its neighbors.
 * Note that we need to return anyone peak element.
 */
public class PeakElement {
    public static void main(String[] args) {
        int arr[] = {1, 3, 20, 4, 1, 0};
        int peakIndex = findPeakElementIndex(arr);
        System.out.println("Peak index : " + peakIndex);
    }

    private static int findPeakElementIndex(int[] arr) {
        return peakElementUtil(arr,0,arr.length-1);
    }

    public static int peakElementUtil(int[] arr, int low, int high) {
        int mid = (low + high) >>> 1;

        if ((mid == 0 || arr[mid -1] <= arr[mid])
                && (mid == arr.length-1 || arr[mid + 1] <= arr[mid])){
            return mid;
        }
        else if (mid > 0 && arr[mid-1] > arr[mid]){
            return peakElementUtil(arr,low,mid - 1);
        }
        else return peakElementUtil(arr,mid + 1,high);
    }

}
