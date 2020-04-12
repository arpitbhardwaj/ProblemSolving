package com.ab.searching;

/**
 * Worst-case performance	O(log n)
 * Best-case performance	O(1)
 * Average performance	O(log n)
 * Worst-case space complexity	O(1)
 * @author Arpit Bhardwaj
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] ints = new int[]{1,4,5,8,9,10};
        int index = binarySearch(ints, 9);
        if(index == -1){
            System.out.println("Item not found in array");
        }else{
            System.out.println("Item to search is present at position : " + index);
        }
    }

    public static int binarySearch(int[] array, int item) {
        int low,high,mid;
        low = 0;
        high = array.length - 1;
        while (low <= high){
            //mid = low + (high - 1)/2;
            //mid = low + ((high - low)/2);
            //https://ai.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html
            //https://stackoverflow.com/questions/13785210/why-in-java-high-low-2-is-wrong-but-high-low-1-is-not
            mid = (low + high) >>> 1;
            System.out.println(mid);
            if(array[mid] == item){
                return mid;
            }
            if(array[mid] < item){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
