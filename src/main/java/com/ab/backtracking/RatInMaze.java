package com.ab.backtracking;

import com.ab.utils.Utils;

/**
 * @author Arpit Bhardwaj
 */
public class RatInMaze {
    static int[][] maze;
    static int rows;
    static int columns;
    public static void main(String[] args) {
        maze = new int[][]{ { 1, 0, 0, 0 },
                            { 1, 1, 0, 1 },
                            { 0, 1, 0, 0 },
                            { 1, 1, 1, 1 } };
        rows = maze.length;
        columns = maze[0].length;
        System.out.println("Given Maze: ");
        Utils.printMatrix(maze);
        int solution[][] = solveMaze();
        System.out.println("Solution");
        Utils.printMatrix(solution);
    }

    private static int[][] solveMaze() {
        int sol[][] = new int[rows][columns];
        if (!solveMazeUtil(sol,0,0)){
            throw new IllegalStateException("No Solution Exist");
        }
        return sol;
    }

    private static boolean solveMazeUtil(int[][] sol, int x, int y) {
        //base condition
        if (x == rows - 1 && y == columns - 1){
            sol[x][y] = 1;
            return true;
        }
        if(isSafe(x,y)){
            sol[x][y] = 1;
            //move forward
            if (solveMazeUtil(sol,x,y+1)){
                return true;
            }

            //move downward
            if (solveMazeUtil(sol,x+1,y)){
                return true;
            }

            sol[x][y] = 0;
            return false;
        }
        return false;
    }

    private static boolean isSafe(int x, int y) {
        return x>=0 && y>=0 && x< rows && y<columns && maze[x][y]==1;
    }
}
