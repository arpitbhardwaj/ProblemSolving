package com.ab.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arpit Bhardwaj
 *
 * Given N number of houses along the street with some amount of money
 * Adjacent houses cannot be stolen
 * Find the maximum amount that can be stolen
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] housesNetWorth = {6,7,1,30,8,2,4};
        System.out.println(maxMoneyStolen(housesNetWorth, 0));
        System.out.println(maxMoneyStolenDPTD(housesNetWorth));
        System.out.println(maxMoneyStolenDPBU(housesNetWorth));
    }

    //Divide and Conquer (Recursive)
    private static int maxMoneyStolen(int[] housesNetWorth, int currentHouseIndex) {
        if (currentHouseIndex >= housesNetWorth.length){
            return 0;
        }
        int stealCurrentHouse = housesNetWorth[currentHouseIndex] + maxMoneyStolen(housesNetWorth, currentHouseIndex+2);
        int skipCurrentHouse = maxMoneyStolen(housesNetWorth, currentHouseIndex+1);
        return Math.max(stealCurrentHouse, skipCurrentHouse);
    }

    //DP Top Down
    private static int maxMoneyStolenDPTD(int[] housesNetWorth) {
        int n = housesNetWorth.length;
        int[] dp = new int[n];
        return maxMoneyStolenDPTDUtil(housesNetWorth,0, dp);
    }

    private static int maxMoneyStolenDPTDUtil(int[] housesNetWorth,int currentHouseIndex, int[] dp) {
        if (currentHouseIndex >= housesNetWorth.length){
            return 0;
        }
        if(dp[currentHouseIndex] == 0){
            int stealCurrentHouse  = housesNetWorth[currentHouseIndex] + maxMoneyStolen(housesNetWorth, currentHouseIndex+2);
            int skipCurrentHouse = maxMoneyStolen(housesNetWorth, currentHouseIndex+1);
            dp[currentHouseIndex] = Math.max(stealCurrentHouse, skipCurrentHouse);
        }

        return dp[currentHouseIndex];
    }

    //DP Bottom Up
    private static int maxMoneyStolenDPBU(int[] housesNetWorth) {
        int n = housesNetWorth.length;
        int[] dp = new int[n+2];
        for (int i = n-1; i >= 0; i--) {
            dp[i] = Math.max(housesNetWorth[i] + dp[i+2], dp[i+1]);
        }
        return dp[0];
    }
}
