package com.ab.divideandconquer;

/**
 * @author Arpit Bhardwaj
 */
public class SearchInRotatedArray {
    public static void main(String[] args) {
        //int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        //int[] arr = {1, 2, 3, 5, 6, 7, 8, 9, 10};
        int[] arr = {10, 1, 2, 3, 5, 6, 7, 8, 9};
        int index = searchInRotatedArray(arr);
        if(index == -1){
            System.out.println("Item not found in array");
        }else{
            System.out.println("Item to search is present at position : " + index);
        }
    }

    private static int searchInRotatedArray(int[] arr) {
        //find the pivot point at which array is rotated
        int rotatedPoint = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i+1]){
                rotatedPoint = i;
                System.out.println(rotatedPoint);
            }
        }


        return -1;
    }
}
