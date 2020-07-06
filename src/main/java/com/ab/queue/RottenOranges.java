package com.ab.queue;

/**
 * @author Arpit Bhardwaj
 * Given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
 * 0: Empty cell
 * 1: Cells have fresh oranges
 * 2: Cells have rotten oranges
 * Determine what is the minimum time required so that all the oranges become rotten.
 * A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right).
 * If it is impossible to rot every orange then simply return -1.
 *
 * Crux : BFS which internally uses queue
 */
public class RottenOranges {
    public static void main(String[] args) {
        
    }
}
