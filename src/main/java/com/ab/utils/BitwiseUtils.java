package com.ab.utils;

/**
 * @author Arpit Bhardwaj
 */
public class BitwiseUtils {

    public static int countSetBits(int number) {
        int count = 0;
        while (number > 0){
            count += number & 1;
            number >>= 1;
        }
        System.out.println("No of Set Bits: " + count);
        return count;
    }

    public static void displayBinary(int n){
        System.out.println(String.format("Binary Representation of %s is %s"
                ,n
                ,Integer.toBinaryString(n)));
    }
}
