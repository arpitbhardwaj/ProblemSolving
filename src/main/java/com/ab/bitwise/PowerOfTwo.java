package com.ab.bitwise;

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
        int n = 5455;
        System.out.println(String.format("Binary of %s is %s",n,Integer.toBinaryString(n)));
        System.out.println(String.format("%s is the power of 2 : %s", n,isPowerOfTwo(n)));
    }

    private static boolean isPowerOfTwo(int n) {
        return countSetBits(n) == 1?true:false;
    }

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0){
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}
