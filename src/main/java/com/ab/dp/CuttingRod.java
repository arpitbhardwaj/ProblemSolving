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
        System.out.println("Maximum Profit: " + maxProfit);
    }


    private static int calculateMaxProfit(int[] prices, int rodlen) {
        int m = prices.length + 1;
        int n = rodlen + 1;
        int[][] dp = new int[m][n];

        //fill 1 row with increasing number
        for (int i = 0; i < n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(j >= prices[i-1]){
                    //if length to cut is greater than the price
                    dp[i][j] = Math.max(dp[i-1][j], prices[i-1] + dp[i][j-1]);
                }else{
                    //ignore the current price, take the value from previous row
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        Utils.printMatrix(dp);
        return dp[m-1][n-1];
    }
}
