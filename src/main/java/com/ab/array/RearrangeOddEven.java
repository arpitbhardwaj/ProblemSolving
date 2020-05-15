package com.ab.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 *
 *Given an array of integers (both odd and even), the task is to arrange them in such a way
 * that odd and even values come in alternate fashion in non-decreasing order(ascending) respectively.
 *
 * If the smallest value is Even then we have to print Even-Odd pattern.
 * If the smallest value is Odd then we have to print Odd-Even pattern.
 */
public class RearrangeOddEven {
    public static void main(String[] args) {
        int[] arr = { 9, 8, 13, 2, 19, 14 };
        System.out.println(Arrays.toString(arr));
        rearrangeOddEven(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void rearrangeOddEven(int[] arr) {
        Arrays.sort(arr);
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0){
                evenList.add(arr[i]);
            }else{
                oddList.add(arr[i]);
            }
        }

        boolean smallestEven = false;
        if (arr[0] % 2 == 0){
            smallestEven = true;
        }
        int evenPointer = 0;
        int oddPointer = 0;
        for (int i = 0; i < arr.length; i++) {
            if (smallestEven){
                arr[i] = evenList.get(evenPointer++);
            }else{
                arr[i] = oddList.get(oddPointer++);
            }
            smallestEven = !smallestEven;
        }
    }
}
