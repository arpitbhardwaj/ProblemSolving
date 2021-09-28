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
        int number = 5455;
        System.out.println(String.format("%s is the power of 2 : %s", number,powerOfTwo(number)));
    }

    private static boolean powerOfTwo(int number) {
        return countSetBits(number) == 1?true:false;
    }

    public static int countSetBits(int number) {
        int count = 0;
        while (number > 0){
            count += number & 1;
            number >>= 1;
        }
        System.out.println("No of Set Bits: " + count);
        return count;
    }
}
