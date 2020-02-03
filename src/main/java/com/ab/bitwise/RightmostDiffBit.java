package com.ab.bitwise;

/**
 * Given two numbers M and N.
 * Print the position of rightmost different bit in binary representation of numbers.
 *
 * Binary representation of the 11,9 are: 1011 and 1001, 2nd bit from right is different.
 *
 * @author Arpit Bhardwaj
 */
public class RightmostDiffBit {
    public static void main(String[] args) {
        int m = 52,n = 4;
        int index = getRightmostDiffBitIndex(m,n);
        System.out.println("Position of the rightmost different bit in " + m + " & "+ n + " is : " + index);

    }

    private static int getRightmostDiffBitIndex(int m, int n) {
        return getFirstRightSetBitIndex(m ^ n);
    }

    private static int getFirstRightSetBitIndex(int number) {
        return logBaseX((number & (~number + 1)), 2) + 1;
    }

    private static int logBaseX(int i, int base) {
        return (int) (Math.log10(i) / Math.log10(base));
    }
}
