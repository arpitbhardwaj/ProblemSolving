package com.ab.bitwise;

/**
 * @author Arpit Bhardwaj
 *
 * You are given an array of n+2 elements. All elements of the array are in range 1 to n.
 * And all elements occur once except two numbers which occur twice. Find the two repeating numbers.
 */
public class TwoDuplicateNumbers {
    public static void main(String[] args) {
        int arr[] = {4, 2, 4, 5, 2, 3, 1};
        printTwoDuplicates(arr);
    }

    private static void printTwoDuplicates(int[] arr) {
        int length = arr.length;
        int n = length - 2;

        //suppose 2 duplicate numbers are x and y
        int x = 0,y=0;

        //find first x^y
        int xxory = 0;

        for (int i = 0; i < length; i++) {
            xxory ^= arr[i];
        }

        for (int i = 1; i <= n; i++) {
            xxory ^= i;
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

        for (int i = 1; i <= n; i++) {
            if ((i & setBit) != 0){
                x ^= i;
            }else{
                y ^= i;
            }
        }

        System.out.println(String.format("The two duplicate numbers are %s and %s",x,y));
    }
}
