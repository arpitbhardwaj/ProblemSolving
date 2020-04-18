package com.ab.recursion;

/**
 * @author Arpit Bhardwaj
 *
 * The problem is to count all the possible paths from top left to bottom right of a mXn matrix
 * with the constraints that from each cell you can either move only to right or down
 */
public class NumberOfPaths {
    public static void main(String[] args) {
        System.out.println(numberOfPaths(3,3));
    }

    private static int numberOfPaths(int rows, int columns) {
        if (rows == 1 || columns == 1){
            return 1;
        }
        return numberOfPaths(rows-1,columns) + numberOfPaths(rows,columns-1);
    }
}
