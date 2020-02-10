package com.ab.bitwise;

/**
 * @author Arpit Bhardwaj
 */
public class SetKthBit {
    public static void main(String[] args) {
        int number = 10;
        int k = 2;
        System.out.println(String.format("Given Number %s Binary Representation %s",number
                ,Integer.toBinaryString(number)));
        int numberAfter = setKthBit(number,k);
        System.out.println(String.format("Number After %snd Bit Set is %s Binary Representation %s",k
                ,numberAfter
                ,Integer.toBinaryString(numberAfter)));
    }

    private static int setKthBit(int number, int k) {
        return (number | ( 1 << k));
    }
}
