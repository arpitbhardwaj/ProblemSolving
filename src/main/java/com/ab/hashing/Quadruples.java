package com.ab.hashing;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 *
 * Given an array A of size N, find all combination of four elements in the array whose sum is equal to a given value K.
 * if the given array is {10, 2, 3, 4, 5, 9, 7, 8} and K = 23, one of the quadruple is “3 5 7 8” (3 + 5 + 7 + 8 = 23).
 *
 */
public class Quadruples {
    static class Pair{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }
    public static void main(String[] args) {
        int arr[] = {10, 2, 3, 4, 5, 9, 7, 8};
        int sum = 23;
        System.out.println(Arrays.toString(arr));
        printQuadruples(arr,sum);
    }

    private static void printQuadruples(int[] arr, int sum) {
        Map<Integer,Pair> sumPairMap = new HashMap<>();
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i+1; j < length; j++) {
                sumPairMap.put(arr[i] + arr[j], new Pair(i,j));
            }
        }
        System.out.println(sumPairMap);
        for (int i = 0; i < length - 1; i++) {
            for (int j = i+1; j < length; j++) {
                int firstPairSum = arr[i] + arr[j];
                int secondPairSum = sum - firstPairSum;
                if (sumPairMap.containsKey(secondPairSum)){
                    Pair secondPair = sumPairMap.get(secondPairSum);
                    if (secondPair.first != i
                    && secondPair.second != j
                    && secondPair.first != j
                    && secondPair.second != i){
                        StringJoiner joiner = new StringJoiner(",");
                        joiner.add(Integer.toString(arr[i]))
                                .add(Integer.toString(arr[j]))
                                .add(Integer.toString(arr[secondPair.first]))
                                .add(Integer.toString(arr[secondPair.second]));
                        System.out.println(joiner.toString());

                    }
                }
            }
        }
    }
}
