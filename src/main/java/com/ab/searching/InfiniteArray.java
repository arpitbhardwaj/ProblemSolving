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
        if(index == -1){
            System.out.println("Item not found in array");
        }else{
            System.out.println("Item to search is present at position : " + index);
        }
    }

    //the crux here is to find the high
    private static int binarySearchMaster(int[] arr, int key) {
        int val = arr[0];
        int n = arr.length;
        int low = 0;
        int high = 1;
        while (val < key){
            // copy high index in low index
            low = high;
            //double the high index
            if (2*high < n - 1){
                high = high * 2;
            }else{
                high = n - 1;
            }
            val = arr[high];
        }
        return BinarySearch.recursiveBinarySearch(arr,low,high,key);
    }
}
