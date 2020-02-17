package com.ab.utils;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 */
public class Utils {

    public static void printMatrix(int[][] matrix) {
        System.out.println("Printing Matrix");
        for (int[] row:
                matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void printMatrix(boolean[][] matrix) {
        System.out.println("Printing Matrix");
        for (boolean[] row:
                matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int min(int i1, int i2, int i3) {
        int temp = Math.min(i1,i2);
        return Math.min(temp,i3);
    }
}
