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
        int key = 7;
        //int index = iterativeBinarySearch(ints, key);
        //int index = recursiveBinarySearch(ints, 0,ints.length - 1,key);
        int index = bsTemplate(ints,key);
        if(index == -1){
            System.out.println("Item not found in array");
        }else{
            System.out.println("Item to search is present at position : " + index);
        }
    }

    public static int iterativeBinarySearch(int[] array, int item) {
        int low,high,mid;
        low = 0;
        high = array.length - 1;
        while (low <= high){
            //mid = low + (high - 1)/2;
            //mid = low + ((high - low)/2);
            //https://ai.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html
            //https://stackoverflow.com/questions/13785210/why-in-java-high-low-2-is-wrong-but-high-low-1-is-not
            mid = (low + high) >>> 1;
            if(array[mid] == item){
                return mid;
            }
            if(array[mid] > item){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;//return start in case you need inserted position
    }

    public static int recursiveBinarySearch(int[] array, int low, int high, int item) {
        if((low <= high)){
            int mid = (low + high) >>> 1;
            if(array[mid] == item){
                return mid;
            }
            if(array[mid] > item){
                return recursiveBinarySearch(array,low,mid-1,item);
            }
            else {
                return recursiveBinarySearch(array,mid+1,high,item);
            }
        }
        return -1;
    }

    //if we are sure element is present in array, then we can use below template
    //if the element not found this gives you the last index (array.length - 1)
    public static int bsTemplate(int[] array, int target){
        int start = 0;
        int end = array.length - 1;
        while(start < end){
            int mid = (start + end) >>> 1;
            if(array[mid] == target){ //this if condition can be replaced by any generic condition
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        return start;
    }
}
