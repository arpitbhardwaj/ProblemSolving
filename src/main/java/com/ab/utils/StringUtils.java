package com.ab.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Arpit Bhardwaj
 */
public class StringUtils {

    public static void swapArrElements(String[] arr,int x,int y){
        String temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static Map<Character, Integer> getCharCountMap(String str) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            if (charCountMap.containsKey(currChar)){
                charCountMap.put(currChar,charCountMap.get(currChar) + 1);
            }else {
                charCountMap.put(currChar,1);
            }
        }
        return charCountMap;
    }

}
