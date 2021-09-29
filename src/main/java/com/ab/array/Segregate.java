package com.ab.array;

import com.ab.utils.Utils;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 * Segregate Negative Postive without maaintaining insertion order
 * Method 1: Using 2 Pointer
 * Method 2: Using Quick Sort Partition Logic
 *
 * Segregate Negative Postive by maaintaining insertion order
 * Method 1: Using 2 Pointer
 *
 * Segregates even and odd numbers.
 * The functions should put all even numbers first, and then odd numbers.
 */
public class Segregate {
    public static void main(String[] args) {
        int[] arr = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };

        segregatePosNegWithoutOrder(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };
        //using quick sort logic
        segregatePosNegQuick(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };
        segregatePosNegWithOrder(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {12, 34, 45, 9, 8, 90, 3};
        segregateEvenOddWithoutOrder(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {12, 34, 45, 9, 8, 90, 3};
        segregateEvenOddWithOrder(arr4);
        System.out.println(Arrays.toString(arr4));
    }

    private static void segregatePosNegWithOrder(int[] arr) {
        int countNeg = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (arr[i] < 0){
                countNeg++;
            }
        }
        int i = 0;
        int j = i+1;
        while (i != countNeg){
            if (arr[i] < 0){
                i++;
                j = i + 1;
            }else if (arr[i] > 0 && j < length){
                Utils.swapArrayElements(arr,i,j);
                j++;
            }
        }
    }

    private static void segregatePosNegWithoutOrder(int[] arr) {
        int length = arr.length;
        int left = 0;
        int right = length - 1;
        while (left < right){
            //skip elements till we get the positive one
            while (arr[left] < 0){
                left++;
            }
            //skip elements till we get the negative one
            while (arr[right] >= 0){
                right--;
            }
            if(left < right){
                Utils.swapArrayElements(arr,left,right);
            }

            left++;
            right--;
        }
    }
    public static int segregatePosNegQuick(int[] arr) {
        //quick sort logic to partition by considering 0 as pivot
        int pivot = 0;
        int low = 0;
        //int high = arr.length - 1;
        int high = arr.length;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot){
                i++;
                Utils.swapArrayElements(arr, i, j);
            }
        }
        return i+1;//starting index for positive numbers rally
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
        int left = 0;
        int right = length - 1;
        while (left < right){
            //skip elements till we get the odd one
            while (arr[left]%2 == 0){
                left++;
            }
            //skip elements till we get the even one
            while (arr[right]%2 == 1){
                right--;
            }
            if(left < right){
                Utils.swapArrayElements(arr,left,right);
            }

            left++;
            right--;
        }
    }
}
