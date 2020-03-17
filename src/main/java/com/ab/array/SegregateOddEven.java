package com.ab.array;

import com.ab.utils.Utils;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * Segregation: Given an array A[], write a function that segregates even and odd numbers.
 * The functions should put all even numbers first, and then odd numbers.
 *
 * Variation of famous Dutch national flag problem.
 */
public class SegregateOddEven {
    public static void main(String[] args) {
        int[] arr = {12, 34, 45, 9, 8, 90, 3};
        System.out.println(Arrays.toString(arr));
        segregateEvenOdd(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void segregateEvenOdd(int[] arr) {
        int length = arr.length;
        int leftIndex = 0;
        int rightIndex = length - 1;
        while (leftIndex < rightIndex){
            //skip elements till we get the odd one
            while (arr[leftIndex]%2 == 0){
                leftIndex++;
            }
            //skip elements till we get the even one
            while (arr[rightIndex]%2 == 1){
                rightIndex--;
            }
            if(leftIndex < rightIndex){
                Utils.swapArrayElements(arr,leftIndex,rightIndex);
            }

            leftIndex++;
            rightIndex--;
        }
    }
}
