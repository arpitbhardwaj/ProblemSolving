package com.ab.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {
    public static void main(String[] args) {
        int[] ints = new int[]{1,4,8,2,9,9,10};
        System.out.println(search(ints, 9));
        System.out.println(recursiveSearch(ints,9,0));
        searchAllIndex1(ints,9,0);
        System.out.println(list);
        System.out.println(searchAllIndex2(ints,9,0,new ArrayList<>()));
        System.out.println(searchAllIndex3(ints,9,0));
    }

    private static int search(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == target){
                return i;
            }
        }
        return -1;
    }

    private static int recursiveSearch(int[] arr, int target, int index){
        if (arr.length == index){
            return -1;
        }
        if (arr[index] == target){
            return index;
        }

        return recursiveSearch(arr,target,index+1);
    }

    static List<Integer> list = new ArrayList<>();
    private static void searchAllIndex1(int[] arr, int target, int index){
        if (arr.length == index){
            return;
        }
        if (arr[index] == target){
            list.add(index);
        }
        searchAllIndex1(arr,target,index+1);
    }

    private static List<Integer> searchAllIndex2(int[] arr, int target, int index, List<Integer> list){
        if (arr.length == index){
            return list;
        }
        if (arr[index] == target){
            list.add(index);
        }
        return searchAllIndex2(arr,target,index+1,list);
    }

    private static List<Integer> searchAllIndex3(int[] arr, int target, int index){
        List<Integer> list = new ArrayList<>();
        if (arr.length == index){
            return list;
        }
        //this will contain will contains answers from this function call only
        if (arr[index] == target){
            list.add(index);
        }
        List<Integer> answerFromBelowFuncCall = searchAllIndex3(arr, target, index + 1);
        list.addAll(answerFromBelowFuncCall);
        return list;
    }

}
