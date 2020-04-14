package com.ab.printpattern;

/**
 * @author Arpit Bhardwaj
 */
public class MatrixWave {
    public static void main(String[] args) {
        int matrix[][] =  { { 1, 2, 3, 4 },
                            { 5, 6, 7, 8 },
                            { 9, 10, 11, 12 },
                            { 13, 14, 15, 16 } };
        printWave(matrix);
        System.out.println();
        printReverseWave(matrix);
    }

    private static void printReverseWave(int[][] matrix) {
        int startRow = 0;
        int startCol = 0;

        int endRow = matrix.length;
        int endCol = matrix[0].length;

        int wave = 1; //direction down

        while (startCol < endCol){
            if (wave == 1){//go down
                // Print the last column from the remaining columns
                for (int i = startRow; i < endRow; i++) {
                    System.out.print(matrix[i][endCol - 1] + " ");
                }
                wave = 0;
            }else{//go up
                // Print the last second column from the remaining columns
                for (int i = endRow - 1; i >= startRow; i--) {
                    System.out.print(matrix[i][endCol - 1] + " ");
                }
                wave = 1;
            }
            endCol--;
        }
    }

    private static void printWave(int[][] matrix) {
        int startRow = 0;
        int startCol = 0;

        int endRow = matrix.length;
        int endCol = matrix[0].length;

        int wave = 1; //direction down

        while (startCol < endCol){
            if (wave == 1){//go down
                // Print the first column from the remaining columns
                for (int i = startRow; i < endRow; i++) {
                    System.out.print(matrix[i][startCol] + " ");
                }
                wave = 0;
            }else{//go up
                // Print the second column from the remaining columns
                for (int i = endRow - 1; i >= startRow; i--) {
                    System.out.print(matrix[i][startCol] + " ");
                }
                wave = 1;
            }
            startCol++;
        }
    }
}
