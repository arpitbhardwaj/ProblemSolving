package com.ab.hashing;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 *
 * Given two unsorted arrays that represent two sets (elements in every array are distinct),
 * find union and intersection of two arrays.
 *
 *  Sorted ones can be done via pointers explained in array package
 */
public class IntersectionOfTwoUnsorted {
    public static void main(String[] args) {
        int arr1[] = {7, 1, 5, 2, 3, 6};
        int arr2[] = {3, 8, 6, 20, 7};
        System.out.println("Array 1 : " + Arrays.toString(arr1));
        System.out.println("Array 2 : " + Arrays.toString(arr2));
        List<Integer> intersection = getIntersection(arr1,arr2);
        System.out.println("Intersection : " + intersection);
        Set<Integer> union = getUnion(arr1,arr2);
        System.out.println("Union : " + union);
    }

    //time complexity of below method is O(n) due to hashing
    private static Set<Integer> getUnion(int[] arr1, int[] arr2) {
        Set<Integer> resultSet = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            resultSet.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            resultSet.add(arr2[i]);
        }

        return resultSet;
    }

    //time complexity of below method is O(n) due to hashing
    private static List<Integer> getIntersection(int[] arr1, int[] arr2) {
        Set<Integer> tempSet = new HashSet<>();
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            tempSet.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (tempSet.contains(arr2[i])){
                resultList.add(arr2[i]);
            }
        }
        return resultList;
    }
}
