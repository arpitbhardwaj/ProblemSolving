package com.ab.bitwise;

import com.ab.utils.BitwiseUtils;

/**
 * @author Arpit Bhardwaj
 *
 * Method 1: Take log base 2
 * Method 2: Divide by 2
 * Method 3: Count set bits
 *
 * All power of two numbers have only one bit set.
 * So count the no. of set bits and if you get 1 then number is a power of 2.
 */
public class PowerOfTwo {
    public static void main(String[] args) {
        //int number = 256;
        int number = 5455;
        System.out.println(String.format("%s is the power of 2 : %s", number,powerOfTwo(number)));
    }

    private static boolean powerOfTwo(int number) {
        return BitwiseUtils.countSetBits(number) == 1?true:false;
    }
}
