package com.ab.bitwise;

import com.ab.utils.BitwiseUtils;

/**
 * @author Arpit Bhardwaj
 *
 * A rotation (or circular shift) is an operation similar to shift
 * except that the bits that fall off at one end are put back to the other end.
 *
 */
public class RotateBits {
    static final int BITS = 32;
    public static void main(String[] args) {
        //int number = 16;
        int number = 229;
        int rotate = 2;
        BitwiseUtils.displayBinary(number);
        BitwiseUtils.displayBinary(leftRotation(number,rotate));
        BitwiseUtils.displayBinary(rightRotation(number,rotate));
    }

    private static int rightRotation(int number, int rotate) {
        //BitwiseUtils.displayBinary(number << rotate);
        BitwiseUtils.displayBinary(number << (BITS-rotate));
        System.out.println("Rotating Right");
        return (number >> rotate) | (number << (BITS-rotate));
    }

    private static int leftRotation(int number, int rotate) {
        //BitwiseUtils.displayBinary(number << rotate);
        //BitwiseUtils.displayBinary(number >> (BITS-rotate));
        System.out.println("Rotating Left");
        return (number << rotate) | (number >> (BITS-rotate));
    }
}
