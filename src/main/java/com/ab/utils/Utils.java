package com.ab.utils;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 */
public class Utils {

    public static void printMatrix(int[][] matrix) {
        System.out.println("Printing Matrix");
        for (int[] row:
                matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void printMatrix(boolean[][] matrix) {
        System.out.println("Printing Matrix");
        for (boolean[] row:
                matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int min(int i1, int i2, int i3) {
        int temp = Math.min(i1,i2);
        return Math.min(temp,i3);
    }

    public static void swapArrayElements(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static int[] convertToIntArray(int num){
        String numStr = Integer.toString(num);
        int[] intArray = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            intArray[i] = numStr.charAt(i) - '0';
        }
        return intArray;
    }


    public static int convertToInt(int[] numArr){
        int numInt = 0;
        for (int i = 0; i < numArr.length; i++) {
            numInt *= 10;
            numInt += numArr[i];
        }
        return numInt;
    }

    public static int getLSD(int num){
        return num % 10;
    }

    public static int getWithoutLSD(int num){
        return num / 10;
    }

    public static int getMSD(int num){
        while (num < -9 || num > 9){
            num /= 10;
        }
        return Math.abs(num);
    }

    public static boolean isEven(int num){
        if (num % 2 == 0){
            return true;
        }
        return false;
    }

    public static int medianOfSortedArray(int[] arr, int startIndex, int endIndex) {
        int length = endIndex - startIndex + 1;
        if (Utils.isEven(length)){
            return (arr[startIndex + (length / 2)] + arr[startIndex + (length / 2 - 1)]) / 2;
        }
        return arr[startIndex + (length / 2)];
    }

    public static int medianIndex(int startIndex, int endIndex){
        return (startIndex + endIndex + 1) / 2;
    }
}
