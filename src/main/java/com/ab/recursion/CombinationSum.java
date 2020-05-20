package com.ab.recursion;

import com.ab.array.RemoveDuplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 * Given an array of positive integers arr[] and a sum x
 * find all unique combinations in arr[] where the sum is equal to x.
 * The same repeated number may be chosen from arr[] unlimited number of times.
 */
public class CombinationSum {
    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 8};
        int sum = 8;
        List<List<Integer>> result = combinationSum(arr,sum);
        System.out.println(result);
    }

    private static List<List<Integer>> combinationSum(int[] arr, int sum) {
        //sort the array
        Arrays.sort(arr);

        //remove duplicates
        int newLast = RemoveDuplicates.removeDuplicates(arr);
        int[] newArr = Arrays.copyOfRange(arr, 0, newLast);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSumUtil(newArr,sum,result,list,0);
        return result;
    }

    private static void combinationSumUtil(int[] arr, int sum, List<List<Integer>> result, List<Integer> list, int i) {
        if (sum < 0){
            return;
        }
        if (sum == 0){
            result.add(list);
            return;
        }
        while (i < arr.length && sum - arr[i] >= 0){
            list.add(arr[i]);
            //recursion
            combinationSumUtil(arr,sum - arr[i],result,list,i);
            i++;
            //back track
            list.remove(list.size() - 1);
        }
    }
}
