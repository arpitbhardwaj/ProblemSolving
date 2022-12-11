package com.ab.dp;

import com.ab.utils.Utils;

/**
 * @author Arpit Bhardwaj
 *
 */
public class GivenCostPath {
    public static void main(String[] args) {
        int costMatrix[][] = {{4,7,1,6},{5,7,3,9},{3,2,1,2},{7,1,6,3}};
        int cost = 25;
        System.out.println("Given Cost Matrix");
        Utils.printMatrix(costMatrix);
        //int totalWays = givenCostPathDP(costMatrix, cost);
        int totalWays = givenCostPath(costMatrix, cost);
        System.out.println("Total Ways : " + totalWays);
    }

    //Divide and Conquer (Recursive)
    private static int givenCostPath(int[][] costMatrix,int cost) {
        return givenCostPathUtil(costMatrix, costMatrix.length-1, costMatrix[0].length-1, cost);
    }

    private static int givenCostPathUtil(int[][] costMatrix, int row, int col, int cost) {
        if (cost < 0){
            return 0;
        }
        if (row == 0 && col == 0){
            return costMatrix[0][0] - cost == 0 ? 1 : 0;
        }
        if (row == 0){ //we can go only left
            return givenCostPathUtil(costMatrix,row,col-1, cost - costMatrix[row][col]);
        }
        if (col == 0){ //we can go only up
            return givenCostPathUtil(costMatrix,row-1,col, cost - costMatrix[row][col]);
        }
        int goingUp = givenCostPathUtil(costMatrix,row-1,col, cost - costMatrix[row][col]);
        int goingLeft = givenCostPathUtil(costMatrix,row,col-1, cost - costMatrix[row][col]);
        return goingUp + goingLeft;
    }


    private static int givenCostPathDP(int[][] costMatrix, int cost) {
        return -1;
    }
}
