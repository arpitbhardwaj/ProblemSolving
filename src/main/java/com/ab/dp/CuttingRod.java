package com.ab.dp;

import com.ab.utils.Utils;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 *
 */
public class CuttingRod {
    public static void main(String[] args) {
        int priceArr[] = {2,5,7,8};
        //price of length 1 = 2
        //price of length 2 = 5
        //price of length 3 = 7
        //price of length 4 = 8
        int rodLength = 5;
        int maxProfit = calculateMaxProfit(priceArr,rodLength);
        //int noOfCuts = calculateCutsForMaxProfitSingleArray(priceArr,rodLength);
        System.out.println("Maximum Profit: " + maxProfit);
    }


    private static int calculateMaxProfit(int[] priceArr, int rodLength) {
        int[][] temp = new int[priceArr.length + 1][rodLength + 1];

        //fill 1st column all zero
        for (int i = 0; i < temp.length; i++) {
            temp[i][0] = 0;
        }
        //fill 1 row with increasing number
        for (int i = 0; i < temp[0].length; i++) {
            temp[0][i] = i;
        }
        Utils.printMatrix(temp);

        //starting from 1 as the 0th row and column are all set as per previous loop
        for (int i = 1; i < temp.length; i++) {
            for (int j = 1; j < temp[i].length; j++) {
                if (priceArr[i-1] > j){
                    temp[i][j] = temp[i-1][j];
                }
                else{
                    temp[i][j] = Math.max(temp[i-1][j], priceArr[i-1] + temp[i][j-1]);
                }
            }
        }

        Utils.printMatrix(temp);
        return temp[priceArr.length - 1][rodLength];
    }
}
