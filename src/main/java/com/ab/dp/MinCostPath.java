package com.ab.dp;

import com.ab.utils.Utils;

/**
 * @author Arpit Bhardwaj
 */
public class MinCostPath {
    public static void main(String[] args) {
        int cost[][] = {{1,3,5,8},{4,2,1,7},{4,3,2,3}};
        System.out.println("Given Cost Matrix");
        Utils.printMatrix(cost);
        int minCost = determineMinCostPath(cost);
        System.out.println("Minimum Cost Path : " + minCost);
    }

    private static int determineMinCostPath(int[][] cost) {
        int rowLength = cost.length;
        int columnLength = cost[0].length;
        int sum = 0;
        int[][] temp = new int[rowLength][columnLength];
        // fill first row
        for (int i = 0; i < columnLength; i++) {
            temp[0][i] = sum + cost[0][i];
            sum = temp[0][i];
        }
        sum = 0;
        // fill first column
        for (int i = 0; i < rowLength; i++) {
            temp[i][0] = sum + cost[i][0];
            sum = temp[i][0];
        }
        Utils.printMatrix(temp);

        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < columnLength; j++) {
                temp[i][j] = cost[i][j] + Math.min(temp[i-1][j], temp[i][j-1]);
            }
        }
        Utils.printMatrix(temp);
        return temp[rowLength - 1][columnLength - 1];
    }
}
