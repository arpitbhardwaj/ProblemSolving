package com.ab.dp;

import com.ab.utils.Utils;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 *  * Given two strings how many minimum edits(update, delete or add) is needed to convert one string to another
 *  *
 *  * Time complexity is O(m*n)
 *  * Space complexity is O(m*n)
 */
public class MinimumEdit {
    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "azced";

        int minEdits = minimumEdits(str2.toCharArray(),str1.toCharArray());
        System.out.println("String 1 : " + str1);
        System.out.println("String 2 : " + str2);
        System.out.println("Minimum edits required to conert str1 to str2 is : " + minEdits);
    }

    private static int minimumEdits(char[] strArr1, char[] strArr2) {
        //strArr1 rows, strArr2 columns
        int n1 = strArr1.length;
        int n2 = strArr2.length;

        int[][] temp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i < n1+1; i++) {
            temp[i][0] = i;
        }

        for (int i = 0; i < n2+1; i++) {
            temp[0][i] = i;
        }

        Utils.printMatrix(temp);
        //starting from 1 as the 0th row and column is all zeroes
        for (int i = 1; i < n1+1; i++) {
            for (int j = 1; j < n2+1; j++) {
                if (strArr1[i-1] == strArr2[j-1]){
                    temp[i][j] = temp[i-1][j-1];
                }
                else{
                    temp[i][j] = Utils.min(temp[i][j-1], temp[i-1][j], temp[i-1][j-1]) + 1;
                }
            }
        }
        Utils.printMatrix(temp);
        return temp[n1][n2];
    }
}
