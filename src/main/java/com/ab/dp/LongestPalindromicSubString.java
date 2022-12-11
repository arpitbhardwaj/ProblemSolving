package com.ab.dp;

import com.ab.utils.Utils;

/**
 * @author Arpit Bhardwaj
 *
 */
public class LongestPalindromicSubString {

    public static void main(String[] args) {
        String str = "agbdba";
        //int lpsLength = longestPalindromicSubStringDP(str);
        int lpsLength = longestPalindromicSubString(str);
        System.out.println("Longest Palindromic Sub String: " + lpsLength);
    }

    private static int longestPalindromicSubStringDP(String str) {
        return -1;
    }

    private static int longestPalindromicSubString(String str) {
        return longestPalindromicSubStringUtil(str, 0, str.length()-1);
    }

    private static int longestPalindromicSubStringUtil(String str, int start, int end) {
        return -1;
    }
}
