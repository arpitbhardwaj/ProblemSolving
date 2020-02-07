package com.ab.strings;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Remove duplicate characters from string in order
 * Constraint: original order of characters must be kept same.
 *
 * Sorting: takes O(nlogn)
 * Hashing: O(n)
 * @author Arpit Bhardwaj
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println("Given String: " + str);
        String strWithOutDuplicates = removeDuplicates(str);
        System.out.println("Without Duplicates: " + strWithOutDuplicates);
    }

    private static String removeDuplicates(String str) {
        Set<Character> charSet = new LinkedHashSet<>();
        char[] charArr = str.toCharArray();
        String result = "";
        for (char c:
             charArr) {
            charSet.add(c);
        }
        for (char c:
             charSet) {
            result += c;
        }
        return result;
    }
}
