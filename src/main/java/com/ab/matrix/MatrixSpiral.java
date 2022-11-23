package com.ab.matrix;

/**
 * @author Arpit Bhardwaj
 */
public class MatrixSpiral {
    public static void main(String[] args) {
        int matrix[][] =    { { 1, 2, 3, 4, 5, 6 },
                            { 7, 8, 9, 10, 11, 12 },
                            { 13, 14, 15, 16, 17, 18 } };
        printSpiralClockWise(matrix);
        System.out.println();
        printSpiralAntiClockWise(matrix);
    }

    private static void printSpiralAntiClockWise(int[][] matrix) {
        int startRow = 0;
        int startCol = 0;

        int endRow = matrix.length;
        int endCol = matrix[0].length;

        while (startRow < endRow
                && startCol < endCol){
            // Print the first column from the remaining columns
            for (int i = startRow; i < endRow; i++) {
                System.out.print(matrix[i][startCol] + " ");
            }
            startCol++;

            // Print the last row from the remaining rows
            for (int i = startCol; i < endCol; i++) {
                System.out.print(matrix[endRow - 1][i] + " ");
            }
            endRow--;

            // Print the last column from the remaining columns
            if (startCol < endCol){
                for (int i = endRow - 1; i >= startRow; i--) {
                    System.out.print(matrix[i][endCol - 1] + " ");
                }
                endCol--;
            }

            // Print the first row from the remaining rows
            if (startRow < endRow){
                for (int i = endCol - 1; i >= startCol; i--) {
                    System.out.print(matrix[startRow][i] + " ");
                }
                startRow++;
            }
        }
    }

    private static void printSpiralClockWise(int[][] matrix) {
        int startRow = 0;
        int startCol = 0;

        int endRow = matrix.length;
        int endCol = matrix[0].length;

        while (startRow < endRow
        && startCol < endCol){
            // Print the first row from the remaining rows
            for (int i = startCol; i < endCol; i++) {
                System.out.print(matrix[startRow][i] + " ");
            }
            startRow++;
            // Print the last column from the remaining columns
            for (int i = startRow; i < endRow; i++) {
                System.out.print(matrix[i][endCol - 1] + " ");
            }
            endCol--;
            // Print the last row from the remaining rows
            if (startRow < endRow){
                for (int i = endCol - 1; i >= startCol; i--) {
                    System.out.print(matrix[endRow - 1][i] + " ");
                }
                endRow--;
            }

            // Print the first column from the remaining columns
            if (startCol < endCol){
                for (int i = endRow - 1; i >= startRow; i--) {
                    System.out.print(matrix[i][startCol] + " ");
                }
                startCol++;
            }
        }
    }
}
