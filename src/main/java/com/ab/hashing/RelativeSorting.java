package com.ab.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Arpit Bhardwaj
 *
 * Given two arrays A1[] and A2[],
 * sort A1 in such a way that the relative order among the elements will be same as those are in A2
 * For the elements not present in A2, append them at last in sorted order.
 *
 */
public class RelativeSorting {
    public static void main(String[] args) {
        int[] arr1 = { 2, 1, 2, 5, 5, 7, 7, 1, 9, 3, 6, 8, 8 };
        int[] arr2 = { 2, 1, 8, 3 };
        System.out.println("Sorting of " + Arrays.toString(arr1));
        System.out.println("relative to " + Arrays.toString(arr2));
        List<Integer> sortedList = relativeSort(arr1,arr2);
        System.out.println("is " + sortedList);
    }

    private static List<Integer> relativeSort(int[] arr1, int[] arr2) {
        List<Integer> resultList = new ArrayList<>();
        Map<Integer, Integer> countMap = SortByFrequency.geCountMap(arr1);
        for (int i = 0; i < arr2.length; i++) {
            int key = arr2[i];
            if(countMap.containsKey(key)){
                for (int j = 0; j < countMap.get(key); j++) {
                    resultList.add(key);
                }
                countMap.remove(key);
            }
        }
        //Append the remaining elements in sorted manner
        if(!countMap.isEmpty()){
            countMap.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry -> {
                        int key = entry.getKey();
                        int value = entry.getValue();
                        for (int i = 0; i < value; i++) {
                            resultList.add(key);
                        }
                    });
        }
        return resultList;
    }


}
