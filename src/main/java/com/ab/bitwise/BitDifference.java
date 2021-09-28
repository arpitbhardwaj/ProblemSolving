package com.ab.bitwise;

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
        return countSetBits(a^b);
    }

    public static int countSetBits(int number) {
        int count = 0;
        while (number > 0){
            count += number & 1;
            number >>= 1;
        }
        System.out.println("No of Set Bits: " + count);
        return count;
    }

    public static void displayBinary(int n){
        System.out.println(String.format("Binary Representation of %s is %s"
                ,n
                ,Integer.toBinaryString(n)));
    }
}
