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
 */
public class SegregateNegativePositive {
    public static void main(String[] args) {
        int[] arr = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };
        System.out.println(Arrays.toString(arr));

        segregatePosNegWithoutOrder1(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };
        segregatePosNegQuick(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };
        segregatePosNegWithOrder(arr2);
        System.out.println(Arrays.toString(arr2));
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

    private static void segregatePosNegWithoutOrder1(int[] arr) {
        int length = arr.length;
        int leftIndex = 0;
        int rightIndex = length - 1;
        while (leftIndex < rightIndex){
            //skip elements till we get the odd one
            while (arr[leftIndex] < 0){
                leftIndex++;
            }
            //skip elements till we get the even one
            while (arr[rightIndex] >= 0){
                rightIndex--;
            }
            if(leftIndex < rightIndex){
                Utils.swapArrayElements(arr,leftIndex,rightIndex);
            }

            leftIndex++;
            rightIndex--;
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
}
