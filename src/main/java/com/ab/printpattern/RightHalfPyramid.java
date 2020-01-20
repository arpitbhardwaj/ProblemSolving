package com.ab.printpattern;

/**
 * @author Arpit Bhardwaj
 */
public class RightHalfPyramid {

    public static void main(String[] args) {
        int n = 5;
        printRightHalfPyramid(n);
    }

    private static void printRightHalfPyramid(int n) {
        //to control no of rows
        for (int i = 0; i < n; i++) {

            //to control no of columns
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
