package com.ab.searching;

/**
 * Worst-case performance	O(n)
 * Best-case performance	O(1)
 * Average performance	O(n)
 * Worst-case space complexity
 * @author Arpit Bhardwaj
 */
public class LinearSearch {
    public static void main(String[] args) {
        int[] ints = new int[]{1,4,8,2,9,10};
        int index = linearSearch(ints, 11);
        if(index == -1){
            System.out.println("Item not found in array");
        }else{
            System.out.println("Item to search is present at position : " + index);
        }
    }

    private static int linearSearch(int[] array, int item) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == item){
                return i;
            }
        }
        return -1;
    }
}
