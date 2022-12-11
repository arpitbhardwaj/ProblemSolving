package com.ab.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Arpit Bhardwaj
 *
 * Given N, find the number of ways to express N as a sum if 1,3,4
 */
public class NumberFactor {
    public static void main(String[] args) {
        System.out.println(noOfWays(4));
        System.out.println(noOfWays(5));
        System.out.println(noOfWays(6));
        System.out.println(noOfWaysDPTD(6));
        System.out.println(noOfWaysDPBU(6));
    }

    //Divide and Conquer
    private static int noOfWays(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        if (n == 3){
            return 2;
        }
        return  noOfWays(n-1) + noOfWays(n-3) + noOfWays(n-4);
    }

    //DP Top Down
    private static int noOfWaysDPTD(int n) {
        int[] dp = new int[n+1];
        return noOfWaysDPTDUtil(n, dp);
    }

    private static int noOfWaysDPTDUtil(int n, int[] dp) {
        if (n == 0){
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        if (n == 3){
            return 2;
        }
        if(dp[n] == 0){
            dp[n] = noOfWays(n-1) + noOfWays(n-3) + noOfWays(n-4);
        }
        return dp[n];
    }

    //DP Bottom Up
    private static int noOfWaysDPBU(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0; //by default so no need for this line
        dp[1] = dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i-1]  + dp[i-3] + dp[i-4];
        }
        return dp[n];
    }
}
