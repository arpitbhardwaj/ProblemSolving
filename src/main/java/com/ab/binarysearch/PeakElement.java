package com.ab.binarysearch;

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
        int start = 0;
        int end = arr.length-1;
        while (start < end){
            int mid = (start + end) >>> 1;
            if (arr[mid] > arr[mid+1]){
                //you are in dec part of array
                //this may be the ans but look at left
                //that is why end != mid -1
                end = mid;
            }else{
                //you are in asc part of array
                //because we know that mid+1 element is greater than mid
                //hence ignoring mid
                start = mid + 1;
            }
        }

        //in the end, start and end will point to the largest number because of 2 checks above, hence both will be equal
        //start and end will always trying to find max element in above 2 checks
        //
        return start; // or return end;
    }
}
