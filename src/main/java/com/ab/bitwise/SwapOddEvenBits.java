package com.ab.bitwise;

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
        //int n = 14;
        int n = 23;
        System.out.println(String.format("Binary of %s is %s",n,Integer.toBinaryString(n)));
        System.out.println(String.format("%s after swapping bits becomes: %s",n
                ,swapBits(n)));
    }

    private static int swapBits(int n) {
        //0xAAAAAAAA is a 32 bit number with all even bits set as 1 and all odd bits as 0.
        int even = n & 0xAAAAAAAA;

        //0x55555555 is a 32 bit number with all odd bits set as 1 and all even bits as 0.
        int odd = n & 0x55555555;

        even >>= 1;
        odd <<= 1;

        return even | odd;
    }
}
