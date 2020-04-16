package com.ab.hashing;

import com.ab.utils.Utils;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 *
 * Print the elements of an array in the decreasing frequency
 * if 2 numbers have same frequency then print the one which came first
 *
 * Hashing Technique
 * Time Complexity : O(n) + O(m Log m) where n is total number of elements and m is total number of distinct elements
 *
 */
public class SortByFrequency {

    public static void main(String[] args) {
        //int[] arr = {2,5,2,8,5,6,8,8};
        int[] arr = {2,5,2,6,-1,99999,5,8,8};
        System.out.println(Arrays.toString(arr));
        List<Integer> sortedList = sortByFrequency(arr);
        System.out.println(sortedList);
    }

    private static List<Integer> sortByFrequency(int[] arr) {
        List<Integer> resultList = new ArrayList<>();

        Map<Integer, Integer> countMap = Utils.getCountMap(arr);

        countMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .forEach(entry -> {
                    int key = entry.getKey();
                    int value = entry.getValue();
                    for (int i = 0; i < value; i++) {
                        resultList.add(key);
                    }
                });
        return resultList;
    }

}
