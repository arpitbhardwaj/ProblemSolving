package com.ab.strings;

import java.util.Arrays;

/**
 * An anagram of a string is another string that contains same characters
 * only the order of characters can be different.
 *
 * “act” and “tac” are anagram of each other.
 *
 * Naive Approach takes O(n*2)
 * Count Array takes O(n)
 *
 * @author Arpit Bhardwaj
 */
public class Anagram {
    private static final int NO_OF_CHARS = 256;
    public static void main(String[] args) {
        String string1 = "thisisthetime";
        String string2 = "hitssiethimet";
        boolean areAnagrams = isAnagram(string1,string2);
        if(areAnagrams){
            System.out.println(string1 + " is the anagram of " + string2);
        }else{
            System.out.println(string1 + " is not anagram of " + string2);
        }
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] countChar = new int[26];

        for(int i = 0; i < s.length(); i++){
            countChar[s.charAt(i)-'a']++;
            countChar[t.charAt(i)-'a']--;
        }

        for(int count:countChar){
            if(count != 0){
                return false;
            }
        }

        return true;
    }
}
