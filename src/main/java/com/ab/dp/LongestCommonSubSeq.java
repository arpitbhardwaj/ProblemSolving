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

        int lcsLength = longestCommonSubSequence(str2.toCharArray(),str1.toCharArray());
        System.out.println("String 1 : " + str1);
        System.out.println("String 2 : " + str2);
        System.out.println("Length of LCS : " + lcsLength);
    }

    private static int longestCommonSubSequence(char[] strArr1, char[] strArr2) {
        int n1 = strArr1.length;
        int n2 = strArr2.length;
        int[][] temp = new int[n1 + 1][n2 + 1];
        Utils.printMatrix(temp);
        //starting from 1 as the 0th row and column is all zeroes
        for (int i = 1; i < n1+1; i++) {
            for (int j = 1; j < n2+1; j++) {
                if (strArr1[i-1] == strArr2[j-1]){
                    temp[i][j] = temp[i-1][j-1] + 1;
                }
                else{
                    temp[i][j] = Math.max(temp[i][j-1], temp[i-1][j]);
                }
            }
        }
        Utils.printMatrix(temp);
        return temp[n1][n2];
    }
}
