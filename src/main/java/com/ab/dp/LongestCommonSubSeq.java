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
        String str1 = "abcdaf";
        String str2 = "acbcf";

        int lcsLength = longestCommonSubSequence(str1,str2);
        System.out.println("String 1 : " + str1);
        System.out.println("String 2 : " + str2);
        System.out.println("Length of LCS : " + lcsLength);
    }

    private static int longestCommonSubSequence(String str1, String str2) {
        int n1 = str1.length()+1;
        int n2 = str2.length()+1;
        int[][] dp = new int[n1][n2];
        //starting from 1 as the 0th row and column is all zeroes
        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)){
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
}
