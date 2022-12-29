package com.ab.dp;

import com.ab.utils.Utils;

/**
 * @author Arpit Bhardwaj
 */
public class LongestCommonSubString {
    public static void main(String[] args) {
        String str1 = "abcdaf";
        String str2 = "zbcdf";

        int lcsLength = longestCommonSubString(str1,str2);
        System.out.println("String 1 : " + str1);
        System.out.println("String 2 : " + str2);
        System.out.println("Length of Longest Common Substring : " + lcsLength);
    }

    //DP Bottom Up
    private static int longestCommonSubString(String str1, String str2) {
        int n1 = str1.length()+1;
        int n2 = str2.length()+1;
        int[][] dp = new int[n1][n2];
        int max = 0;
        //starting from 1 as the 0th row and column is all zeroes
        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if(dp[i][j] > max){
                        max = dp[i][j];
                    }
                }

            }
        }
        Utils.printMatrix(dp);
        return max;
    }
}
