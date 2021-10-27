package com.ab.hashing;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 *
 * Given an array of words, print all anagrams together.
 * For example, if the given array is {“cat”, “dog”, “tac”, “god”, “act”}, then output may be “cat tac act dog god”.
 */
public class SegregateAnagrams {
    public static void main(String[] args) {
        String arr[] = { "cat", "dog", "tac", "god", "act" };
        Map<String, List<String>> anagramsMap = segregateAnagrams(arr);
        for (List<String> anagramList:
             anagramsMap.values()) {
            System.out.println(anagramList);
        }
    }

    private static Map<String, List<String>> segregateAnagrams(String[] arr) {

        Map<String, List<String>> resultMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            char[] charArr = word.toCharArray();
            Arrays.sort(charArr);
            String sortedWord = new String(charArr);

            if (resultMap.containsKey(sortedWord)){
                resultMap.get(sortedWord).add(word);
            }else{
                List<String> anagramList = new ArrayList<>();
                anagramList.add(word);
                resultMap.put(sortedWord,anagramList);
            }
        }

        return resultMap;
    }
}
