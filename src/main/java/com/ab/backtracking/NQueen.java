package com.ab.backtracking;

import com.ab.utils.Utils;

/**
 * @author Arpit Bhardwaj
 */
public class NQueen {
    public final int N;

    public NQueen(int n) {
        N = n;
    }

    public static void main(String[] args) {
        int board[][] = {   { 0, 0, 0, 0 },
                            { 0, 0, 0, 0 },
                            { 0, 0, 0, 0 },
                            { 0, 0, 0, 0 } };
        solveNQ(board);
    }

    private static void solveNQ(int[][] board) {
        NQueen nQueen = new NQueen(board.length);
        if (!nQueen.solveNQUtil(board,0)){
            System.out.println("Solution doesn't exist");
            return;
        }
        Utils.printMatrix(board);
    }

    private boolean solveNQUtil(int[][] board, int column) {
        //base case
        if (column >= this.N){
            return true;
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(board,i,column)){
                //place the queen then check safety
                board[i][column] = 1;
                if (solveNQUtil(board,column+1)){
                    return true;
                }

                //backtrack step
                board[i][column] = 0;
            }
        }
        return false;
    }

    private boolean isSafe(int[][] board, int row, int column) {
        //check this row left side
        for (int i = 0; i < column; i++) {
            if (board[row][i] == 1){
                return false;
            }
        }
        //check upper diagonal on left side
        for (int i = row,j = column; i >= 0 && j >= 0; i--,j--) {
            if (board[i][j] == 1){
                return false;
            }
        }
        //check lower diagonal on left side
        for (int i = row,j = column; i < this.N && j >= 0; i++,j--) {
            if (board[i][j] == 1){
                return false;
            }
        }
        return true;
    }
}
