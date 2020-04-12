package com.ab.array;

/**
 * @author Arpit Bhardwaj
 *
 * Given an unsorted array of nonnegative integers, find a continuous subarray which adds to a given number.
 */
public class GivenSumSubArray {
    public static void main(String[] args) {
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int sum = 23;
        givenSumSubArray(arr,sum);
    }

    private static void givenSumSubArray(int[] arr, int sum) {
        int currSum = arr[0];
        int startIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            int prevIndex = i-1;
            //remove trailing elements till sum is smaller
            while (currSum > sum && startIndex < prevIndex){
                currSum -= arr[startIndex++];
            }

            if (currSum == sum){
                System.out.println(String.format("Sum found between indices %s,%s",startIndex,prevIndex));
                return;
            }
            //add element to the curr sum
            currSum += arr[i];
        }

        System.out.println("No Given Sum sub array found");
        return;
    }
}
