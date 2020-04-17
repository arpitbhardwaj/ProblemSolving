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

    private static int binarySearchMaster(int[] arr, int key) {
        int val = arr[0];
        int lowIndex = 0;
        int highIndex = 1;
        while (val < key){
            // copy high index in low index
            lowIndex = highIndex;
            //double the high index

            if (2*highIndex < arr.length - 1){
                highIndex = highIndex * 2;
            }else{
                highIndex = arr.length - 1;
            }

            val = arr[highIndex];
        }
        return BinarySearch.recursiveBinarySearch(arr,lowIndex,highIndex,key);
    }
}
