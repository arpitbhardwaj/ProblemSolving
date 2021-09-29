package com.ab.bitwise;

/**
 * @author Arpit Bhardwaj
 *
 * A number is Sparse if there are no two adjacent 1s in its binary representation
 *
 */
public class SparseNumber {
    public static void main(String[] args) {
        int n = 5;
        //int n = 6; // not a sparse number
        System.out.println(String.format("Binary of %s is %s",n,Integer.toBinaryString(n)));
        System.out.println(String.format("%s is the Sparse Number: %s",n,isSparseNumber(n)));
    }

    private static boolean isSparseNumber(int n) {
        return (n & (n >> 1)) == 0;
    }
}
