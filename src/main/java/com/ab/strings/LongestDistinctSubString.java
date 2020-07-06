package com.ab.strings;

/**
 *  Given a string S, find length of the longest substring with all distinct characters
 *  "abca", the output is 3 as "abc" is the longest substring with all distinct characters
 *
 *  Sliding Window Pattern
 *
 * @author Arpit Bhardwaj
 */
public class LongestDistinctSubString {
    public static void main(String[] args) {
        String str = "ABDEFGABEF";
        System.out.println(str);
        int length = longestDistinctSubstring(str);
        System.out.println("Length of longest distinct sub string");
    }

    private static int longestDistinctSubstring(String str) {
        return 0;
    }
}
