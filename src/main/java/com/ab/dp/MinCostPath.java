package com.ab.dp;

import com.ab.utils.Utils;

/**
 * @author Arpit Bhardwaj
 */
public class MinCostPath {
    public static void main(String[] args) {
        int cost[][] = {{1,3,5,8},{4,2,1,7},{4,3,2,3}};
        //int cost[][] = {{4,7,8,6,4},{6,7,3,9,2},{3,8,1,2,4},{7,1,7,3,7},{2,9,8,9,3}};
        System.out.println("Given Cost Matrix");
        Utils.printMatrix(cost);
        int minCost = minCostPathDP(cost);
        //int minCost = minCostPath(cost);
        System.out.println("Minimum Cost Path : " + minCost);
    }

    //Divide and Conquer (Recursive)
    private static int minCostPath(int[][] cost) {
        return minCostPathUtil(cost, cost.length-1, cost[0].length-1);
    }

    private static int minCostPathUtil(int[][] cost, int row, int col) {
        if (row == -1 || col == -1){
            return Integer.MAX_VALUE;
        }
        if (row == 0 && col == 0){
            return cost[0][0];
        }
        int goingUp = minCostPathUtil(cost,row-1,col);
        int goingLeft = minCostPathUtil(cost,row,col-1);
        return cost[row][col] + Math.min(goingUp, goingLeft);
    }


    private static int minCostPathDP(int[][] cost) {
        int r = cost.length;
        int c = cost[0].length;
        int sum = 0;
        int[][] temp = new int[r][c];
        // fill first row
        for (int i = 0; i < c; i++) {
            temp[0][i] = sum + cost[0][i];
            sum = temp[0][i];
        }
        sum = 0;
        // fill first column
        for (int i = 0; i < r; i++) {
            temp[i][0] = sum + cost[i][0];
            sum = temp[i][0];
        }
        Utils.printMatrix(temp);

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                temp[i][j] = cost[i][j] + Math.min(temp[i-1][j], temp[i][j-1]);
            }
        }
        Utils.printMatrix(temp);
        return temp[r - 1][c - 1];
    }
}
