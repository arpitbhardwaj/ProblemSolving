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
public class SegregateEvenOdd {
    public static void main(String[] args) {
        int[] arr = {12, 34, 45, 9, 8, 90, 3};
        System.out.println(Arrays.toString(arr));
        segregateEvenOddWithoutOrder(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {12, 34, 45, 9, 8, 90, 3};
        segregateEvenOddWithOrder(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    private static void segregateEvenOddWithOrder(int[] arr) {
        int countEven = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (arr[i]%2 == 0){
                countEven++;
            }
        }
        int i = 0;
        int j = i+1;
        while (i != countEven){
            if (arr[i]%2 == 0){
                i++;
                j = i + 1;
            }else if (arr[i]%2 == 1 && j < length){
                Utils.swapArrayElements(arr,i,j);
                j++;
            }
        }
    }

    private static void segregateEvenOddWithoutOrder(int[] arr) {
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
