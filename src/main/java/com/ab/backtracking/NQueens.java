package com.ab.backtracking;

/**
 * @author Arpit Bhardwaj
 */
public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean board[][] = new boolean[n][n];
        System.out.println("No of solutions: "+nQueen(board, 0));
    }

    private static int nQueen(boolean[][] board, int row) {
        //base case
        if (row == board.length){
            printMatrix(board);
            System.out.println();
            return 1;
        }

        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board,row,col)){
                board[row][col] = true;
                count += nQueen(board,row+1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        //check vertical
        for (int i = 0; i < row; i++) {
            if (board[i][col]){
                return false;
            }
        }
        //check diagonal on left side
        int maxLeft = Math.min(row,col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row-i][col-i]){
                return false;
            }
        }
        //check diagonal on right side
        int maxRight = Math.min(row,board.length-col-1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }

    private static void printMatrix(boolean[][] board) {
        for (boolean[] row:board) {
            for (boolean ele:row) {
                if (ele){
                    System.out.print("Q ");
                }else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
