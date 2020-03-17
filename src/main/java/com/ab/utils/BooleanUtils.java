package com.ab.utils;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 */
public class BooleanUtils {

    public static void printMatrix(boolean[][] matrix) {
        System.out.println("Printing Matrix");
        for (boolean[] row:
                matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
