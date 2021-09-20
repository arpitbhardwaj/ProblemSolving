package com.ab.bitwise;

/**
 * Given an integer an N.
 * Print the position of first set bit found from right side in the binary representation of the number.
 *
 * Binary representation of the 18 is 010010, the first set bit from the right side is at position 2.
 *
 * @author Arpit Bhardwaj
 */
public class FirstSetBit {
    public static void main(String[] args) {
        int number = 12;//1100
        int index = getFirstRightSetBitIndex(12);
        System.out.println("Index of first set bit from right side of " + number + " : " + index);
    }

    private static int getFirstRightSetBitIndex(int number) {
        //int is 32 bit = 4 Bytes primitive data type for simplicity i am showing only 4 bits
        //Binary of 12: 1100
        //1s Complement = 0011
        //2s complement = 1s Complement + 1 = 0100

        //1's Complement = ~number
        //2's Complement = ~number + 1
        //Bitwise & with original number -> number & (~number + 1)
        //Take the log2 of the no
        //Add 1

        System.out.println(number + " " + Integer.toBinaryString(number));
        System.out.println(~number + " " + Integer.toBinaryString(~number));//1's Complement
        System.out.println((~number + 1) + " " + Integer.toBinaryString(~number + 1));//2's Complement
        System.out.println((number & (~number + 1)) + " "+Integer.toBinaryString(number & (~number + 1)));
        System.out.println(Integer.toBinaryString(logBaseX((number & (~number + 1)), 2)));
        System.out.println(Integer.toBinaryString(logBaseX((number & (~number + 1)), 2) + 1));

        return logBaseX((number & (~number + 1)), 2) + 1;
    }

    private static int logBaseX(int i, int base) {
        return (int) (Math.log10(i) / Math.log10(base));
    }
}
