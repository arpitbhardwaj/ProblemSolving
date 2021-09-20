package com.ab.utils;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

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


    public static Map<Integer, Integer> getCountMap(int[] arr) {
        //using LinkedHashMap to maintain the order of inserted elements
        Map<Integer,Integer> countMap = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            countMap.put(element,countMap.getOrDefault(element,0)+1);
            /*if(countMap.containsKey(element)){
                countMap.put(element,countMap.get(element) + 1);
            }else{
                countMap.put(element,1);
            }*/
        }
        return countMap;
    }
}
