package com.ab.array;

import java.util.ArrayList;
import java.util.List;

/**
 * An element is leader if it is greater than all the elements to its right side
 * the rightmost element is always a leader
 *
 * Naive Solution O(n*2)
 * Track of maximum one from right takes O(n)
 * @author Arpit Bhardwaj
 */
public class FindLeaders {

    public static void main(String[] args) {
        int[] arr = {16,17,10,4,9,3,5,2};
        List<Integer> leaders = getLeaders(arr);
        System.out.println(leaders.toString());
    }

    private static List<Integer> getLeaders(int[] arr) {
        List<Integer> leadersList = new ArrayList<>();
        int length = arr.length;
        int maxItem = arr[length-1];
        leadersList.add(maxItem);
        for (int i = length - 2; i >=0 ; i--) {
            if(arr[i] > maxItem){
                maxItem = arr[i];
                leadersList.add(maxItem);
            }
        }
        return leadersList;
    }
}
