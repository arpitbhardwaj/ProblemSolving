package com.ab.searching;

/**
 * @author Arpit Bhardwaj
 *
 * Worst-case performance	O(log n)
 * Best-case performance	O(1)
 * Average performance	O(log n)
 * Worst-case space complexity	O(1)
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] ints = new int[]{1,4,5,8,9,10};
        int key = 8;
        int index = binarySearch(ints, key);
        //int index = recursiveBinarySearch(ints, 0,ints.length - 1,key);
        System.out.println(index);
    }

    //if target not found return -1;
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = (start + end) >>> 1; //int mid = low + (high - 1)/2; or //int mid = low + ((high - low)/2);
            if(arr[mid] < target){
                start = mid + 1;            //when no answer found this would be the last condition ran which breaks the while condition start>end
            } else if (arr[mid] > target){
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
        //return start;     //in case you need inserted position or the ceiling of the target
        //return end;       //in case you need floor of the target
    }

    public static int recursiveBinarySearch(int[] arr, int start, int end, int target) {
        if((start <= end)){
            int mid = (start + end) >>> 1;
            if(arr[mid] < target){
                return recursiveBinarySearch(arr,mid+1,end,target);
            } else if (arr[mid] > target){
                return recursiveBinarySearch(arr,start,mid-1,target);
            } else {
                return mid;
            }
        }
        return -1;
    }
}
