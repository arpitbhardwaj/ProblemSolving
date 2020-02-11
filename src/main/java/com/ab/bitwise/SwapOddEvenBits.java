package com.ab.bitwise;

import com.ab.utils.BitwiseUtils;

/**
 * @author Arpit Bhardwaj
 *
 *Given an unsigned integer N. The task is to swap all odd bits with even bits.
 * given number is 23 (00010111), it should be converted to 43(00101011)
 * every even position bit is swapped with adjacent bit on right side
 * and every odd position bit is swapped with adjacent on left side.
 */
public class SwapOddEvenBits {
    public static void main(String[] args) {
        //int number = 14;
        int number = 23;
        BitwiseUtils.displayBinary(number);
        System.out.println(String.format("%s after swapping bits becomes: %s",number
                ,swapBits(number)));
    }

    private static int swapBits(int number) {
        //0xAAAAAAAA is a 32 bit number with all even bits set as 1 and all odd bits as 0.
        int evenBits = number & 0xAAAAAAAA;
        BitwiseUtils.displayBinary(evenBits);
        //0x55555555 is a 32 bit number with all odd bits set as 1 and all even bits as 0.
        int oddBits = number & 0x55555555;
        BitwiseUtils.displayBinary(oddBits);

        evenBits >>= 1;
        oddBits <<= 1;

        return evenBits | oddBits;
    }
}
