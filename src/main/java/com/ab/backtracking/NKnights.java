package com.ab.backtracking;

public class NKnights {
    public static void main(String[] args) {
        int n = 4;
        boolean board[][] = new boolean[n][n];
        nKnight(board, 0,0,4);
    }

    private static void nKnight(boolean[][] board, int row, int col, int knights) {
        if (knights == 0){
            printMatrix(board);
            System.out.println();
        }

        if (row == board.length-1 && col == board.length){
            return;
        }

        if (col==board.length){
            nKnight(board,row+1,0,knights);
            return;
        }

        if(isSafe(board,row,col)){
            board[row][col] = true;
            nKnight(board,row,col+1,knights-1);
            board[row][col] = false;
        }
        nKnight(board,row,col+1,knights);
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board,row-2,col-1)){
            if (board[row-2][col-1]){
                return false;
            }
        }
        if (isValid(board,row-1,col-2)){
            if (board[row-1][col-2]){
                return false;
            }
        }
        if (isValid(board,row-2,col+1)){
            if (board[row-2][col+1]){
                return false;
            }
        }
        if (isValid(board,row-1,col+2)){
            if (board[row-1][col+2]){
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(boolean[][] board,int r, int c) {
        return r>=0 && c>=0 && r< board.length && c<board.length;
    }

    private static void printMatrix(boolean[][] board) {
        for (boolean[] row:board) {
            for (boolean ele:row) {
                if (ele){
                    System.out.print("K ");
                }else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
