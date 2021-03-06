package com.ab.bitwise;

import com.ab.utils.BitwiseUtils;

/**
 * @author Arpit Bhardwaj
 *
 * A number is said to be a sparse number
 * if in binary representation of the number no two or more consecutive bits are set.
 */
public class SparseNumber {
    public static void main(String[] args) {
        //int number = 72;
        int number = 12;
        BitwiseUtils.displayBinary(number);
        System.out.println(String.format("%s is the Sparse Number: %s",number,isSparseNumber(number)));
    }

    private static boolean isSparseNumber(int number) {
        System.out.println("Right Shift: " + Integer.toBinaryString(number >> 1));
        System.out.println("& with Right Shift: " + Integer.toBinaryString(number & (number >> 1)));

        if((number & (number >> 1)) == 0){
            return true;
        }
        return false;
    }
}
