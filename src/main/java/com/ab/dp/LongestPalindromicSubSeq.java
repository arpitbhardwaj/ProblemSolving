package com.ab.dp;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * * Given a string find longest palindromic subsequence in this string.
 *  *
 *  * Time complexity - O(n2)
 *  * Space complexity - O(n2)
 */
public class LongestPalindromicSubSeq {

    public static void main(String[] args) {
        String str = "agbdba";
        int lpsLength = longestPalindromicSubSequence(str.toCharArray());
        System.out.println("Longest Palindromic Sub Sequence : " + lpsLength);
    }

    private static int longestPalindromicSubSequence(char[] strArr) {
        int strLength = strArr.length;
        int[][] temp = new int[strLength][strLength];

        //fill diagonally 1 all
        for (int i = 0; i < strLength; i++) {
            temp[i][i] = 1;
        }
        printMatrix(temp);

        for (int i = 2; i <= strLength; i++) {
            //loop for rows indexing (j)
            for (int j = 0; j < (strLength - (i-1)); j++) {
                int k = j + i - 1;//for column indexing
                if(strArr[j] == strArr[k]){
                    //if ends of sub string is equal then they contribute 2 to length of palindrome at row +1 and column -1 th element
                    temp[j][k] = temp[j+1][k-1] + 2;
                }else{
                    temp[j][k] = Math.max(temp[j+1][k],temp[j][k-1]);
                }
            }
        }
        printMatrix(temp);

        return temp[0][strLength - 1];
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("Printing Matrix");
        for (int[] row:
                matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
