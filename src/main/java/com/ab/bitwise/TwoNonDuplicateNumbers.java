package com.ab.bitwise;

/**
 * @author Arpit Bhardwaj
 *
 * Given an array in which all numbers except two are repeated once.
 * (i.e. we have 2n+2 numbers and n numbers are occurring twice and remaining two have occurred once).
 */
public class TwoNonDuplicateNumbers {
    public static void main(String[] args) {
        int arr[] = {2, 3, 7, 9, 11, 2, 3, 11};
        printTwoNonDuplicates(arr);
    }

    private static void printTwoNonDuplicates(int[] arr) {
        int length = arr.length;
        int x=0,y=0;
        //find first x^y
        int xxory = 0;

        for (int i = 0; i < length; i++) {
            xxory ^= arr[i];
        }

        //get the rightmost set bit of xor
        int setBit = xxory & ~(xxory - 1);

        /* Now divide elements in two sets by comparing rightmost set
           bit of xor with bit at same position in each element. */
        for (int i = 0; i < length; i++) {
            if ((arr[i] & setBit) != 0){
                x ^= arr[i];
            }else{
                y ^= arr[i];
            }
        }

        System.out.println(String.format("The two non duplicate numbers are %s and %s",x,y));
    }
}
