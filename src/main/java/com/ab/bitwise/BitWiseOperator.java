package com.ab.bitwise;

/**
 * ~ is the 1s complement of binary number but compiler gives 2s complement
 * @author Arpit Bhardwaj
 */
public class BitWiseOperator {
    public static void main(String[] args) {
        int a = 5;//32 bit
        int b = 7;

        System.out.println("a&b = " + (a & b));//both bit is 1 it gives 1 else 0
        System.out.println("a|b = " + (a | b));//either or both of bit is 1 it gives 1 else 0
        System.out.println("a^b = " + (a ^ b));//if bits different it gives 1 else 0

        a = 8;
        // >> Similar effect as of dividing the number with some power of two
        System.out.println(a + " >> 1 = " + (a >> 1)); // >> Signed Right shift operator
        System.out.println(a + " >> 2 = " + (a >> 2)); // >> Signed Right shift operator

        System.out.println(a + " >>> 1 = " + (a >>> 1)); // >> Unsigned Right shift operator
        System.out.println(a + " >>> 2 = " + (a >>> 2)); // >> Unsigned Right shift operator

        // << Similar effect as of multiplying the number with some power of two.
        System.out.println(a + " << 1 = " + (a << 1)); // << Signed left shift operator
        //System.out.println("a <<< 1 = " + (a <<< 1)); // <<< no operator

        a = -16;
        System.out.println(a + " >> 1 = " + (a >> 1)); // >> Signed Right shift operator
        System.out.println(a + " >> 3 = " + (a >> 3)); // >> Signed Right shift operator

        System.out.println(a + " >>> 1 = " + (a >>> 1)); // >> Unsigned Right shift operator
        System.out.println(a + " >>> 2 = " + (a >>> 2)); // >> Unsigned Right shift operator

        System.out.println(a + " << 1 = " + (a << 1)); // << Signed left shift operator
    }
}
