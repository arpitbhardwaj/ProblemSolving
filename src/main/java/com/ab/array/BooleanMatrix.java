package com.ab.array;

import com.ab.utils.Utils;

/**
 * @author Arpit Bhardwaj
 *
 * Given a boolean matrix mat[M][N] of size M X N, modify it such that
 * if a matrix cell mat[i][j] is 1 (or true) then make all the cells of ith row and jth column as 1.
 */
public class BooleanMatrix {
    public static void main(String[] args) {
        int mat[][] = { { 1, 0, 0, 1 },
                        { 0, 0, 1, 0 },
                        { 0, 0, 0, 0 } };

        Utils.printMatrix(mat);
        modifyMatrix(mat);
        Utils.printMatrix(mat);
    }

    private static void modifyMatrix(int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;
        boolean firstRowFlag = false,firstColumnFlag= false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                //mark flag true if any cell is 1 in first row
                if (!firstRowFlag && mat[0][j] == 1){
                    firstRowFlag = true;
                }
                //mark flag true if any cell is 1 in first column
                if (!firstColumnFlag && mat[i][0] == 1){
                    firstColumnFlag = true;
                }
                //use first row and column as aux space to store information for other cell
                if (mat[i][j] == 1){
                    mat[0][j] = 1;
                    mat[i][0] = 1;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                //use first row and column to get the info
                if (mat[0][j] == 1 || mat[i][0] == 1){
                    mat[i][j] = 1;
                }
            }
        }

        //re modify the first row
        if (firstRowFlag){
            for (int i = 0; i < columns; i++) {
                mat[0][i] = 1;
            }
        }

        //re modify the first column
        if (firstColumnFlag){
            for (int i = 0; i < rows; i++) {
                mat[i][0] = 1;
            }
        }
    }
}
