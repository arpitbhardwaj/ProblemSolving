package com.ab.printpattern;

/**
 * @author Arpit Bhardwaj
 */
public class IncreasingNumberRightHalfPyramid {

    public static void main(String[] args) {
        int n = 5;
        printIncreasingNumberRightHalfPyramid(n);
    }

    private static void printIncreasingNumberRightHalfPyramid(int n) {
        int num = 1;
        //to control no of rows
        for (int i = 0; i < n; i++) {
            //num = 1;
            //to control no of columns
            for (int j = 0; j <= i; j++) {
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }
    }
}
