package com.ab.recursion;

import com.ab.utils.Utils;

/**
 * @author Arpit Bhardwaj
 *
 * DFS which uses stack
 */
public class FloodFill {
    public static void main(String[] args) {
        int screen[][] =   {{1, 1, 1, 1, 1, 1, 1, 1},
                            {1, 1, 1, 1, 1, 1, 0, 0},
                            {1, 0, 0, 1, 1, 0, 1, 1},
                            {1, 2, 2, 2, 2, 0, 1, 0},
                            {1, 1, 1, 2, 2, 0, 1, 0},
                            {1, 1, 1, 2, 2, 2, 2, 0},
                            {1, 1, 1, 1, 1, 2, 1, 1},
                            {1, 1, 1, 1, 1, 2, 2, 1},
                            };

        int x = 4, y = 4, newColour = 3;
        int oldColour = screen[4][4];
        Utils.printMatrix(screen);
        floodFill(screen,x,y,oldColour,newColour);
        Utils.printMatrix(screen);
    }

    private static void floodFill(int[][] screen, int x, int y, int oldColour, int newColour) {
        int rows = screen.length;
        int columns = screen[0].length;

        //base case
        if (x<0 || y<0 || x >= rows || y>= columns || screen[x][y] != oldColour){
            return;
        }
        //fill the colour
        screen[x][y] = newColour;
        floodFill(screen,x+1,y,oldColour,newColour);//up
        floodFill(screen,x-1,y,oldColour,newColour);//down
        floodFill(screen,x,y+1,oldColour,newColour);//right
        floodFill(screen,x,y-1,oldColour,newColour);//left
    }
}
