package com.ab.bitwise;

/**
 * Java int primitive type is
 *
 * BIGGEST MISCONCEPTION
 * the very first (left-to-right) bit is for the number sign
 * which DOESN'T mean other bits following would be the same for positives and negatives.
 * 15 -> 00001111
 * -15 -> 10001111 //Big NO NO
 *
 *  Computer talks in bits, hence all mathematical operation also happen in bits
 *
 *  The idea behind this is to find the counterpart of number which while adding gives 0
 *  in humans way -> 15 + (-15) = 0
 *  in computers way -> 00001111 + (?) = 00000000
 *
 *  ? called as 2’s complement in computer terms
 *  which is basically the 1's complement + 1
 *
 *  The Task is the find the 1's complement then add one which results 2's complement
 *
 *  Example 2's complement of 15 -> 1's complement (11110000) + 1 -> 11110001 which is 241 in decimal which is not at all -15
 *  if computer adds 15 + (-15) which internally happened in bit representation
 *  00001111 + 11110001 -> 100000000 -> computer ignore the last 1 as there is a space for 8 bits only hence -> 00000000
 *
 *  We can drive the formula from above ->
 *  00001111 + 11110001 = 100000000 (this is 2 the power no. of bits i.e 8 in decimal)
 *  00001111 + 11110001 = 2 ^ 8
 *  2 ^ 8 - 00001111 = 11110001
 *
 *  2 ^ nBits - decimalValue = decimalTwosComplement
 *  Human can use above formula to calculate decimal Twos complement
 *
 * @author Arpit Bhardwaj
 */
public class OnesAndTwosComplement {

    public static void main(String[] args) {
        int a = 5;
        //1's complement of 5
        // 5 -> 0101
        // 1's Complement -> 1010 which is the 2's complement of 6
        // 2's Complement -> 1011 -> 2^4 - 5 -> 16 - 5 -> 11

        //6 -> 0110
        //1's Complement -> 1001
        //2's Complement -> 1010
        System.out.println("~a = " + ~a);//prints -6
        //2's complement of 5
        System.out.println("~a = " + (~a + 1));//prints -5
    }
}
