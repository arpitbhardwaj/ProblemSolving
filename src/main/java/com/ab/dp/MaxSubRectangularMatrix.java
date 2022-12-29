package com.ab.dp;

import com.ab.stack.MaxHistogram;
import com.ab.utils.Utils;

/**
 * @author Arpit Bhardwaj
 *
 * Given a 2D matrix of 0s and 1s. Find size of largest rectangle sub matrix of all 1s in this matrix.
 *
 * Uses max histogram area algorithm
 */
public class MaxSubRectangularMatrix {
    public static void main(String[] args) {
        int matrix[][] =   {{1,1,1,0},
                            {1,1,1,1},
                            {0,1,1,0},
                            {0,1,1,1},
                            {1,0,0,1},
                            {1,1,1,1}};
        Utils.printMatrix(matrix);
        int maxSubRectangleLength = calculateMaxSubRectangle(matrix);
        System.out.println("Legth of Maximum Sub Rectangle Matrix: " + maxSubRectangleLength);
    }

    //DP Bottom Up
    private static int calculateMaxSubRectangle(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] temp = new int[columns];
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0){
                    temp[j] = 0;
                }else{
                    temp[j] += matrix[i][j];
                }
            }
            int area = MaxHistogram.maxHistogram(temp);
            if (maxArea < area){
                maxArea = area;
            }
        }

        return maxArea;
    }
}
