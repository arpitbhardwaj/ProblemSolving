package com.ab.bitwise;

import com.ab.utils.BitwiseUtils;

/**
 * @author Arpit Bhardwaj
 *
 * You are given two numbers A and B.
 * Count number of bits needed to be flipped to convert A to B.
 */
public class BitDifference {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        BitwiseUtils.displayBinary(a);
        BitwiseUtils.displayBinary(b);
        int count = countBitsToFlip(a,b);
        System.out.println(String.format("Number of Bits to flip to convert %s to %s are %s"
                , a
                , b
                , count));
    }

    private static int countBitsToFlip(int a, int b) {
        return BitwiseUtils.countSetBits(a^b);
    }
}
