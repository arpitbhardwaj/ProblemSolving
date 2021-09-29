package com.ab.dp;

import com.ab.utils.Utils;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 */
public class SubsetSum {
    public static void main(String[] args) {
        int arr[] = {2, 3, 7, 8, 10};
        int sum1 = 11, sum2 = 24;
        boolean isSubsetSum1 = isSubsetSum(arr,sum1);
        System.out.println(String.format("is Subset present whose sume is %s : %s",sum1,isSubsetSum1));

        boolean isSubsetSum2 = isSubsetSum(arr,sum2);
        System.out.println(String.format("is Subset present whose sume is %s : %s",sum2,isSubsetSum2));

    }

    private static boolean isSubsetSum(int[] arr, int sum) {
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];
        //filling 0th column all true
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (j < arr[i - 1]){
                    //take the above row cell value
                    dp[i][j] = dp[i-1][j];
                }else{
                    //take either above row cell value or the
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - arr[i - 1]];
                }
            }
        }
        Utils.printMatrix(dp);
        return dp[arr.length][sum];
    }
}
