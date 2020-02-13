package com.ab.hashing;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 *
 * Given an array of size n and an integer k, return the of count of distinct numbers in all windows of size k.
 */
public class CountDistinct {
    public static void main(String[] args) {
        int arr[] =  {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        List<Integer> countDistinct  = countDistinctInWindow(arr,4);
        System.out.println(Arrays.toString(arr));
        System.out.println("Count Distinct in window of " + k + " are " + countDistinct);
    }

    private static List<Integer> countDistinctInWindow(int[] arr, int window) {
        List<Integer> results = new ArrayList<>();
        Map<Integer,Integer> elementToCount = new HashMap<>();
        int distCount = 0;
        //traverse through the first window
        for (int i = 0; i < window; i++) {
            if(!elementToCount.containsKey(arr[i])){
                elementToCount.put(arr[i],1);
                distCount++;
            }else{
                int elementCount = elementToCount.get(arr[i]);
                elementToCount.put(arr[i],elementCount + 1);
            }
        }
        results.add(distCount);

        for (int i = window; i < arr.length; i++) {
            //remove first element from window
            int firstElement = arr[i - window];
            if (elementToCount.get(firstElement) == 1){
                elementToCount.remove(firstElement);
                distCount--;
            }else{
                int elementCount = elementToCount.get(firstElement);
                elementToCount.put(firstElement,elementCount - 1);
            }

            //add element in window
            int addElement = arr[i];
            if(!elementToCount.containsKey(addElement)){
                elementToCount.put(addElement,1);
                distCount++;
            }else{
                int elementCount = elementToCount.get(addElement);
                elementToCount.put(arr[addElement],elementCount + 1);
            }
            results.add(distCount);
        }

        return results;
    }
}
