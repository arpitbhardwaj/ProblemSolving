package com.ab.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Arpit Bhardwaj
 *
 * Given two arrays:
 * check whether arr2[] is a subset of arr1[] or not.
 */
public class ArraySubSet {
    public static void main(String[] args) {
        Integer arr1[] = {11, 1, 13, 7, 3, 7};
        Integer arr2[] = {11, 3, 7, 1};
        ArraySubSet subset = new ArraySubSet();
        boolean isSubset = subset.isSubSet(arr1,arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println("Array 2 is the subset of Array 1: " + isSubset);
    }

    //time complexity of below method is O(n) due to hashing
    private <T> boolean isSubSet(T[] arr1, T[] arr2) {
        Set<T> arrayHashSet = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            arrayHashSet.add(arr1[i]);
        }
        System.out.println(arrayHashSet);
        for (int i = 0; i < arr2.length; i++) {
            if (!arrayHashSet.contains(arr2[i])){
                return false;
            }
        }
        return true;
    }
}
