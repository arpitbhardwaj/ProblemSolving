package com.ab.printpattern;

/**
 * @author Arpit Bhardwaj
 */
public class LeftHalfPyramid {
    public static void main(String[] args) {
        int n = 5;
        printLeftHalfPyramid(n);
    }

    private static void printLeftHalfPyramid(int n) {
        //to control no of rows
        for (int i = 0; i < n; i++) {
            //to control no. of spaces
            for (int j = n-i; j > 1; j--) {
                System.out.print(" ");
            }
            //to control no of columns
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
