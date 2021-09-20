package com.ab.bitwise;

/**
 * @author Arpit Bhardwaj
 *
 * Changing the sign is done by inverting all the bits and adding 1 to it
 *-4      11111111111111111111111111111100
 *-3      11111111111111111111111111111101
 *-2      11111111111111111111111111111110
 *-1      11111111111111111111111111111111
 *0       00000000000000000000000000000000
 *1       00000000000000000000000000000001
 *2       00000000000000000000000000000010
 *3       00000000000000000000000000000011
 *4       00000000000000000000000000000100
 *
 * Bitwise complement
 *
 * 1's Complement or ~ operator
 *      invert all the bits of a number
 *      Result of ~a  would be mirrored binary value -(a+1)
 *      For ex 1's complement of 12 is -13
 * 2's Complement
 *      1's complement + 1
 *      basically the negative signed value of the number
 *      For ex 2's complement of 12 is -12
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
 */
public class OnesAndTwosComplement {

    public static void main(String[] args) {
        int a = 5;

        System.out.printf("1's Complement of %d = %d \n",a, ~a);//prints -6
        System.out.printf("2's Complement of %d = %d",a, (~a + 1));//prints -5
    }
}
