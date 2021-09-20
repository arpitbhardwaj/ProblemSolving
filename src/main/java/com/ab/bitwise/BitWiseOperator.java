package com.ab.bitwise;

/**
 * ~ is the 1s complement of binary number but compiler gives 2s complement
 * @author Arpit Bhardwaj
 *
 * Changing the sign is done by inverting all the bits and adding 1 to it
 *-4      11111111111111111111111111111100
 *-3      11111111111111111111111111111101
 *-2      11111111111111111111111111111110
 *-1      11111111111111111111111111111111
 *0       00000000000000000000000000000000
 *1       00000000000000000000000000000001
 *2       00000000000000000000000000000010
 *3       00000000000000000000000000000011
 *4       00000000000000000000000000000100
 *
 * Signed left shift    : shifts each bit to the left by specified no of positions, fill low order position with 0 bit values
 * Signed right shift   : shifts each bit to the right by specified no of positions, fill high order position with 0 bit values
 * Unsigned right shift : shifts each bit to the right by specified no of positions, fill high order position with 0 bit values
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
