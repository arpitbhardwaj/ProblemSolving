package com.ab.dp;

import com.ab.utils.Utils;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative order of the remaining characters.
 */
public class LongestCommonSubSeq {
    public static void main(String[] args) {
        String str1 = "elephant";
        String str2 = "erepat";

        //int lcsLength = longestCommonSubSeqDP(str1,str2);
        int lcsLength = longestCommonSubSeq(str1, str2);
        System.out.println("Length of LCS: " + lcsLength);
    }

    //DP Bottom Up
    private static int longestCommonSubSeqDP(String s1, String s2) {
        int n1 = s1.length()+1;
        int n2 = s2.length()+1;
        int[][] dp = new int[n1][n2];
        //starting from 1 as the 0th row and column is all zeroes
        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        Utils.printMatrix(dp);
        return dp[n1-1][n2-1];
    }

    //Divide and Conquer (Recursive)
    private static int longestCommonSubSeq(String s1, String s2) {
        return longestCommonSubSeqUtil(s1,s2, 0, 0);
    }

    private static int longestCommonSubSeqUtil(String s1, String s2, int i1, int i2) {
        if (i1 == s1.length() || i2 == s2.length()){//found the final solution
            return 0;
        }
        if (s1.charAt(i1) == s2.charAt(i2)){ //go for next character
            return 1 + longestCommonSubSeqUtil(s1,s2,i1+1,i2+1);
        }
        int skipFirstStrChar = longestCommonSubSeqUtil(s1,s2,i1+1,i2);
        int skipSecondStrChar = longestCommonSubSeqUtil(s1,s2,i1,i2+1);

        return Math.max(skipFirstStrChar, skipSecondStrChar);
    }
}
