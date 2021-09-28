package com.ab.bitwise;

/**
 * @author Arpit Bhardwaj
 */
public class BitwiseUtils {

    public static void displayBinary(int n){
        System.out.println(String.format("Binary Representation of %s is %s"
                ,n
                ,Integer.toBinaryString(n)));
    }


}
