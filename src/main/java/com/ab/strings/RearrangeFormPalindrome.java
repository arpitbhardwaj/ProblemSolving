package com.ab.strings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Arpit Bhardwaj
 *
 * Given a string, Check if characters of the given string can be rearranged to form a palindrome.
 */
public class RearrangeFormPalindrome {
    public static void main(String[] args) {
        String str = "madam";
        //String str = "arpit";
        System.out.println(getPalindrome(str));
    }

    private static String getPalindrome(String str) {
        Map<Character, Integer> charCountMap = getCharCountMap(str);

        System.out.println(charCountMap);

        int oddCount = 0;
        char oddChar = '\0';

        for (Map.Entry<Character, Integer> entry:
             charCountMap.entrySet()) {
            if (entry.getValue() % 2 != 0){
                oddCount++;
                oddChar = entry.getKey();
            }
        }

        if (oddCount > 1 || (oddCount == 1 && str.length() % 2 == 0)){
            return "No Palindrome can be formed";
        }

        String firstHalf = "";
        String secondHalf = "";

        for (Map.Entry<Character, Integer> entry:
        charCountMap.entrySet()) {
            String s = String.valueOf(entry.getKey());
            String result = String.join("", Collections.nCopies(entry.getValue()/2, s));
            firstHalf = firstHalf + result;
            secondHalf = result + secondHalf;
        }

        return oddCount == 1 ? firstHalf + oddChar + secondHalf : firstHalf + secondHalf;
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
