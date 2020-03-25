package com.ab.dp;

import com.ab.utils.Utils;

/**
 * @author Arpit Bhardwaj
 *
 * Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
 */
public class MaxSubSquareMatrix {
    public static void main(String[] args) {
        int matrix[][] =   {{0, 1, 1, 0, 1},
                            {1, 1, 0, 1, 0},
                            {0, 1, 1, 1, 0},
                            {1, 1, 1, 1, 0},
                            {1, 1, 1, 1, 1},
                            {0, 0, 0, 0, 0}};
        Utils.printMatrix(matrix);
        int maxSubSquareLength = calculateMaxSubSquare(matrix);
        System.out.println("Legth of Maximum Sub Square Matrix: " + maxSubSquareLength);
    }

    private static int calculateMaxSubSquare(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] temp = new int[rows + 1][columns + 1];
        Utils.printMatrix(temp);
        int max = 0;
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if(matrix[i][j] == 1){
                    temp[i][j] = Utils.min(temp[i-1][j],temp[i][j-1],temp[i-1][j-1]) + 1;
                    if(temp[i][j] > max){
                        max = temp[i][j];
                    }
                }
            }
        }
        Utils.printMatrix(temp);
        return max;
    }
}
