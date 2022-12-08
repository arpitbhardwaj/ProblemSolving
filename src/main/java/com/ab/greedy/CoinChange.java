package com.ab.greedy;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int coins[] = {3,5,6,8};
        //int coins[] = {1,2,5,10,20,50,10,1000};
        int amount = 11;
        //int amount = 2035;
        int noOfCoins = minNoOfCoins(amount,coins);
        System.out.println("Minimum no of coins required to make total of " + amount + " is: " + noOfCoins);
    }

    private static int minNoOfCoins(int amount, int[] coins) {
        Arrays.sort(coins);
        int index = coins.length - 1;
        int count = 0;
        while (true){
            int coin = coins[index--];
            int noOfCoin = amount / coin;
            int maxAmount = noOfCoin * coin;
            if (maxAmount > 0){
                System.out.println("Coin Value: " + coin + " Count: " + noOfCoin);
                count += noOfCoin;
                amount -= maxAmount;
            }
            if (amount == 0) break;
        }
        return count;
    }
}
