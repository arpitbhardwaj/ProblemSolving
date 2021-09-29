package com.ab.dp;

import com.ab.utils.Utils;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 */
public class CoinChanging {
    public static void main(String[] args) {
        int amount = 11;
        int coins[] = {3,5,6,8};
        int noOfCoins = calculateMinNoOfCoins(amount,coins);
        System.out.println("Minimum no of coins required to make total of " + amount + " is: " + noOfCoins);
    }

    private static int calculateMinNoOfCoins(int amount, int[] coins) {
        int m = coins.length;
        int n = amount + 1;
        int[][] dp = new int[m][n];

        //fill 0th row from 1st column
        for(int i = 1; i < n; i++){
            //if current amount is greater than current coin value and current value - coin value is not maxed
            if(i >= coins[0] && dp[0][i-coins[0]] != n){
                dp[0][i] = dp[0][i-coins[0]]+1;
            }else{
                //assign the max value
                dp[0][i] = n;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(j >= coins[i]){
                    //if amount is greater than the current coin value
                    //the take min of prev row profit or (value-coin value)+1
                    dp[i][j] = Math.min( dp[i][j-coins[i]]+1, dp[i-1][j] );
                }else{
                    //ignore this coin value as the amount is less, take the value from previous row
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        Utils.printMatrix(dp);
        return dp[m-1][n-1];
    }
}
