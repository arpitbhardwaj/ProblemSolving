package com.ab.utils;

/**
 * @author Arpit Bhardwaj
 */
public class StringUtils {

    public static void swapArrElements(String[] arr,int x,int y){
        String temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
