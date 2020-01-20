package com.ab.printpattern;

/**
 * @author Arpit Bhardwaj
 */
public class NumberRightHalfPyramid {

    public static void main(String[] args) {
        int n = 5;
        printNumberRightHalfPyramid(n);
    }

    private static void printNumberRightHalfPyramid(int n) {
        int num;
        //to control no of rows
        for (int i = 0; i < n; i++) {
            num = 1;
            //to control no of columns
            for (int j = 0; j <= i; j++) {
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }
    }
}
