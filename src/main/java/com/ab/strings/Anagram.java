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
        char[] charArr1 = string1.toCharArray();
        char[] charArr2 = string2.toCharArray();

        boolean areAnagrams = areAnagrams(charArr1,charArr2);
        if(areAnagrams){
            System.out.println(string1 + " is the anagram of " + string2);
        }else{
            System.out.println(string1 + " is not anagram of " + string2);
        }
    }

    private static boolean areAnagrams(char[] charArr1, char[] charArr2) {

        int length1 = charArr1.length;
        int length2 = charArr2.length;
        if(length1 != length2){
            return false;
        }
        int[] countArray = new int[NO_OF_CHARS];
        Arrays.fill(countArray,0);

        for (int i = 0; i < length1 && i< length2; i++) {
            countArray[charArr1[i]]++;
            countArray[charArr2[i]]--;
        }

        for (int i = 0; i < NO_OF_CHARS; i++) {
            if (countArray[i] != 0){
                return false;
            }
        }
        return true;
    }
}
