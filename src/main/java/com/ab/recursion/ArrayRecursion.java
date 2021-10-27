package com.ab.recursion;

public class ArrayRecursion {
    public static void main(String[] args) {
        int[] arr = {1,4,6,8,9};
        System.out.println(isSorted(arr,0));
    }

    private static boolean isSorted(int[] arr, int index) {
        if(index == arr.length-1){
            return true;
        }
        return arr[index] < arr[index+1] && isSorted(arr,index+1);
    }
}
