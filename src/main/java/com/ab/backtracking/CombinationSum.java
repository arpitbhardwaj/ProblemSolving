package com.ab.backtracking;

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
    static List<List<Integer>> powerList = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int arr[] = {2, 3, 6, 7};
        int sum = 7;
        System.out.println(combinationSum(arr,sum));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSumUtil(candidates,0,target);
        return powerList;
    }

    public static void combinationSumUtil(int[] candidates,int start, int target){
        if(target < 0){
            return;
        }

        if(target == 0){
            powerList.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            combinationSumUtil(candidates,i, target-candidates[i]);

            //backtrack
            list.remove(list.size()-1);
        }
    }
}
