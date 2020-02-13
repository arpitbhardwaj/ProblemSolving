package com.ab.dp;

import com.ab.utils.Utils;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 */
public class CoinChanging {
    public static void main(String[] args) {
        int total = 11;
        int coins[] = {1,5,6,8};
        int noOfCoins = calculateMinNoOfCoins(total,coins);
        System.out.println("Minimum no of coins required to make total of " + total + " is: " + noOfCoins);
    }

    private static int calculateMinNoOfCoins(int total, int[] coins) {
        int[][] temp = new int[coins.length + 1][total + 1];

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
                if (coins[i-1] > j){
                    temp[i][j] = temp[i-1][j];
                }
                else{
                    temp[i][j] = Math.min(temp[i-1][j], 1 + temp[i][j-coins[i - 1]]);
                }
            }
        }
        Utils.printMatrix(temp);
        return temp[coins.length][total];
    }
}
