package com.ab.dp;

import com.ab.utils.Utils;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 *  Given two strings how many minimum edits(update, delete or add) is needed to convert one string to another
 *
 *  Time complexity is O(m*n)
 *  Space complexity is O(m*n)
 */
public class MinimumEdit {
    public static void main(String[] args) {
        String s1 = "tbres";
        String s2 = "table";
        int minEdits = minimumEdits(s2.toCharArray(),s1.toCharArray());
        //int minEdits = minimumEditsDPBU(s2.toCharArray(),s1.toCharArray());
        //int minEdits = minimumEditsDPTD(s2.toCharArray(),s1.toCharArray());
        System.out.println("Minimum edits required to convert s1 to s2 is : " + minEdits);
    }

    //Divide and Conquer (Recursive)
    private static int minimumEdits(char[] strArr1, char[] strArr2) {
        return minimumEditsUtil(strArr1,strArr2, 0, 0);
    }

    private static int minimumEditsUtil(char[] strArr1, char[] strArr2, int i1, int i2) {
        int n1 = strArr1.length;
        int n2 = strArr2.length;
        if (i1 == n1){//rest all characters from string 2 need to be inserted
            return n2 - i2;
        }
        if (i2 == n2){//rest all characters from string 1 need to be deleted
            return n1 - i1;
        }
        if (strArr1[i1] == strArr2[i2]){ //go for next character
            return minimumEditsUtil(strArr1,strArr2,i1+1,i2+1);
        }
        int insertOp = 1 + minimumEditsUtil(strArr1,strArr2,i1,i2+1);
        int deleteOp = 1 + minimumEditsUtil(strArr1,strArr2,i1+1,i2);
        int replaceOp = 1 + minimumEditsUtil(strArr1,strArr2,i1+1,i2+1);
        return Math.min(insertOp, Math.min(deleteOp, replaceOp));
    }

    //DP Bottom Up
    private static int minimumEditsDPBU(char[] strArr1, char[] strArr2) {
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
