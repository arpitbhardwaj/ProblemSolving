package com.ab.searching;

/**
 * @author Arpit Bhardwaj
 *
 * Find position of an element in a sorted array of infinite numbers
 */
public class InfiniteArray {
    public static void main(String[] args) {
        int[] ints = new int[]{3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int index = binarySearchMaster(ints, 9);
        System.out.println(index);
    }

    //the crux here is to find the high
    private static int binarySearchMaster(int[] arr, int target) {
        int start = 0;
        int end = 1;
        while (target > arr[end]){
            int newStart = end +1 ;
            //double the box value (basically exponentially increasing the search space)
            //end = previous end + size of bix * 2
            end = end + (end - start + 1)*2;
            start = newStart;
        }
        return BinarySearch.recursiveBinarySearch(arr,start,end,target);
    }
}
