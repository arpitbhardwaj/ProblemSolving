package com.ab.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Arpit Bhardwaj
 * Given two arrays of integers
 * check if a pair of values (one value from each array) exists
 * such that swapping the elements of the pair will make the sum of two arrays equal.
 *
 * sum1 - a + b = sum2 - b + a
 * sum1 - sum2 = 2a - 2b
 * (sum1 - sum2) / 2 = a - b
 */
public class SwappingPair {
    public static void main(String[] args) {
        int arr1[] = { 4, 1, 2, 1, 1, 2 };
        int arr2[] = { 3, 6, 3, 3 };
        if (!checkPairExists(arr1,arr2)){
            System.out.println("Pair doesn't Exist");
        }
    }

    private static boolean checkPairExists(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int sum1 = 0,sum2 =0;

        for (int i = 0; i < n1; i++) {
            sum1 += arr1[i];
        }
        for (int i = 0; i < n2; i++) {
            sum2 += arr2[i];
        }
        int diff = Math.abs(sum1 - sum2) >>> 1;

        if (n1<n2){
            return findPair(arr1,arr2,diff);
        }else{
            return findPair(arr2,arr1,diff);
        }
    }

    private static boolean findPair(int[] arr1, int[] arr2, int diff) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            hashSet.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            int second = arr2[i] + diff;
            if (hashSet.contains(second)){
                System.out.println("Pair is : " + second +" " + arr2[i]);
                return true;
            }
        }
        return false;
    }
}
