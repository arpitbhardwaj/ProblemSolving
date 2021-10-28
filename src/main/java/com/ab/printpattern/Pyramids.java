package com.ab.printpattern;

/**
 * @author Arpit Bhardwaj
 *
 */
public class Pyramids {
    public static void main(String[] args) {
        int n = 5;
        printLeftHalf(n);
        printRightHalf(n);
        printFull(n);
        printRightHalfRecursive(5,0);
    }

    private static void printLeftHalf(int n) {
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

    private static void printRightHalf(int n) {
        //to control no of rows
        for (int i = 0; i < n; i++) {
            //to control no of columns
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printFull(int n) {
        //to control no of rows
        for (int i = 0; i < n; i++) {
            //to control no. of spaces
            for (int j = n-i; j > 1; j--) {
                System.out.print(" ");
            }
            //to control no of columns
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void printRightHalfRecursive(int r, int c) {
        if(r==0){
            return;
        }
        if (c<r){
            printRightHalfRecursive(r,c+1);
            System.out.print("*");
        }else{
            printRightHalfRecursive(r-1,0);
            System.out.println();
        }
    }
}
