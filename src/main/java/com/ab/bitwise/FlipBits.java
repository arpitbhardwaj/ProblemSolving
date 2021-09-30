package com.ab.bitwise;

/**
 * @author Arpit Bhardwaj
 *
 * You are given two numbers A and B.
 * Count number of bits needed to be flipped to convert A to B.
 */
public class FlipBits {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(String.format("Binary of %s is %s",a,Integer.toBinaryString(a)));
        System.out.println(String.format("Binary of %s is %s",b,Integer.toBinaryString(b)));
        int count = countBitsToFlip(a,b);
        System.out.println(String.format("Number of Bits to flip to convert %s to %s are %s"
                , a
                , b
                , count));
    }

    private static int countBitsToFlip(int a, int b) {
        return countSetBits(a^b);
    }

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0){
            count ++;
            n = n & (n-1);
        }
        /*while (n > 0){
            count += n & 1;
            n >>= 1;
        }*/
        System.out.println("No of Set Bits: " + count);
        return count;
    }
}
