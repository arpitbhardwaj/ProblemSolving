package com.ab.hashing;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Arpit Bhardwaj
 * Given an array where every element occurs a times, except one element which occurs b (a>b) times
 *
 */
public class AppearBsInAllAs {
    public static void main(String[] args) {
        //int arr[] = { 2, 2, 2, 3, 3, 3, 6, 6 };
        int arr[] = { 2, 2, 2, 2 , 3, 3, 3, 3, 7, 7 };
        //int a = 3,b = 2;
        int a = 4,b = 2;
        System.out.println(Arrays.toString(arr));
        int bElement = findBsInAllAs(arr,a,b);
        System.out.println(String.format("element which occurs %s times is %s",b,bElement));
    }

    private static int findBsInAllAs(int[] arr, int a, int b) {
        HashSet<Integer> elementSet = new HashSet<>();
        int aSum = 0;//to store summation of all unique elements
        int totalSum = 0; //to store summation of all elements
        for (int i = 0; i < arr.length; i++) {
            if (!elementSet.contains(arr[i])){
                elementSet.add(arr[i]);
                aSum += arr[i];
            }
            totalSum += arr[i];
        }
        aSum = a * aSum;//repeat all unique element to a times
        System.out.println(totalSum + " " + aSum);
        return (aSum-totalSum) / (a - b);
    }
}
