package com.ab.dp;

import com.ab.utils.Utils;

/**
 * @author Arpit Bhardwaj
 *
 * find maximum sum rectangle in give 2D matrix.Assume there is at least one positive number in the 2D matrix.
 *
 * Uses Kadane's Algo
 */
public class MaxSumSubRectangularMatrix {
    public static void main(String[] args) {
        int input[][] = {   { 2,  1, -3, -4,  5},
                            { 0,  6,  3,  4,  1},
                            { 2, -2, -1,  4, -5},
                            {-3,  3,  1,  0,  3}};

        Utils.printMatrix(input);
        System.out.println(maxSumSubRectangular(input));
    }

    private static int maxSumSubRectangular(int[][] input) {
        return 0;
    }
}
