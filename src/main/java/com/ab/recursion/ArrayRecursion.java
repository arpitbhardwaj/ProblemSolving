package com.ab.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayRecursion {
    public static void main(String[] args) {
        int[] arr = {1,4,6,8,9};
        System.out.println(isSorted(arr,0));

        /*int[] arr2 = {1,4};
        List<List<Integer>> result = allSubSet(arr2);
        for (List<Integer> list:result) {
            System.out.println(list);
        }*/
    }

    //inefficient gives OutOfMemory error
    private static List<List<Integer>> allSubSet(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for (int num:arr) {
            for (int i = 0; i < outer.size(); i++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }

    private static List<List<Integer>> allUniqueSubSet(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for (int num:arr) {
            for (int i = 0; i < outer.size(); i++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }

    private static boolean isSorted(int[] arr, int index) {
        if(index == arr.length-1){
            return true;
        }
        return arr[index] < arr[index+1] && isSorted(arr,index+1);
    }
}
