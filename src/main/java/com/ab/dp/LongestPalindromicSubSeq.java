package com.ab.dp;

import com.ab.utils.Utils;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * * Given a string find the longest palindromic subsequence in this string.
 *  *
 *  * Time complexity - O(n2)
 *  * Space complexity - O(n2)
 */
public class LongestPalindromicSubSeq {

    public static void main(String[] args) {
        String str = "agbdba";
        int lpsLength = longestPalindromicSubSequence(str);
        System.out.println("Longest Palindromic Sub Sequence : " + lpsLength);
    }

    private static int longestPalindromicSubSequence(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        //fill diagonally 1 all
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            //loop for rows indexing (j)
            for (int j = 0; j < (n - (i-1)); j++) {
                int k = j + i - 1;//for column indexing
                if(str.charAt(j) == str.charAt(k)){
                    //if ends of sub string is equal then they contribute 2 to length of palindrome at row +1 and column -1 th element
                    dp[j][k] = dp[j+1][k-1] + 2;
                }else{
                    dp[j][k] = Math.max(dp[j+1][k],dp[j][k-1]);
                }
            }
        }
        Utils.printMatrix(dp);
        return dp[0][n - 1];
    }
}
