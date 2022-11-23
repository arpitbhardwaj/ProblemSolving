package com.ab.matrix;

/**
 * @author Arpit Bhardwaj
 */
public class MatrixReverseSpriral {
    public static void main(String[] args) {
        int matrix[][] =    { { 1, 2, 3, 4, 5, 6 },
                            { 7, 8, 9, 10, 11, 12 },
                            { 13, 14, 15, 16, 17, 18 } };
        printReverseSpiral(matrix);
    }

    private static void printReverseSpiral(int[][] matrix) {
        int startRowIndex = 0;
        int startColIndex = 0;

        int endRowIndex = matrix.length;
        int endColIndex = matrix[0].length;


    }
}
