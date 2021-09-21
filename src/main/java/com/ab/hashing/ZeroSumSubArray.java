package com.ab.hashing;

//import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Arpit Bhardwaj
 *
 * You are given an array A of size N. You need to print the total count of sub-arrays having their sum equal to 0
 */
public class ZeroSumSubArray {
    public static void main(String[] args) {
        /*int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        ArrayList<Pair> subArrayPair = findSubArraySumZero(arr);
        if (subArrayPair.size() == 0){
            System.out.println("No Sub array exist with sum 0");
        }else{
            printPair(subArrayPair);
        }*/
    }

/*    private static void printPair(ArrayList<Pair> subArrayPair) {
        for (int i = 0; i < subArrayPair.size(); i++) {
            Pair pair = subArrayPair.get(i);
            System.out.println("Subarray found from index "
                    + pair.getKey()
                    + " to "
                    + pair.getValue());
        }
    }

    private static ArrayList<Pair> findSubArraySumZero(int[] arr) {
        ArrayList<Pair> subArrayPair = new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>> sumToEndIndexMap = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0){
                subArrayPair.add(new Pair(0,i));
            }
            ArrayList<Integer> endIndexList = new ArrayList<>();
            if (sumToEndIndexMap.containsKey(sum)){
                System.out.println("contains sum " + sum);
                endIndexList = sumToEndIndexMap.get(sum);
                for (int j = 0; j < endIndexList.size(); j++) {
                    System.out.println("adding to the result");
                    subArrayPair.add(new Pair(endIndexList.get(j)+1,i));
                }
            }
            endIndexList.add(i);
            System.out.println("End Index List " + endIndexList.toString());
            sumToEndIndexMap.put(sum,endIndexList);
        }
        return subArrayPair;
    }*/
}
