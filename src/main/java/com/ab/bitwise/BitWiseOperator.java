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
 *
 * Bitwise complement
 *
 * 1's Complement or ~ operator
 *      invert all the bits of a number
 *      Result of ~a  would be mirrored binary value -(a+1)
 *      For ex 1's complement of 12 is -13
 * 2's Complement
 *      1's complement + 1
 *      basically the negative signed value of the number
 *      For ex 2's complement of 12 is -12
 */
public class BitWiseOperator {
    public static void main(String[] args) {
        int a = 5;//32 bit
        int b = 7;

        //any number & with that many 1s is the number itself
        //any number & with single 1 gives the last bit of the number
        System.out.println("a&b = " + (a & b));//both bit is 1 it gives 1 else 0

        System.out.println("a|b = " + (a | b));//either or both of bit is 1 it gives 1 else 0

        //any number ^ with that many 1s is the complement of that number
        System.out.println("a^b = " + (a ^ b));//if bits different it gives 1 else 0

        a = 8;

        // >> Similar effect as of dividing the number with some power of two
        // a >> b = a / 2 pow b
        System.out.println(a + " >> 1 = " + (a >> 1)); // >> Signed Right shift operator
        System.out.println(a + " >> 2 = " + (a >> 2)); // >> Signed Right shift operator

        System.out.println(a + " >>> 1 = " + (a >>> 1)); // >> Unsigned Right shift operator
        System.out.println(a + " >>> 2 = " + (a >>> 2)); // >> Unsigned Right shift operator

        // << Similar effect as of multiplying the number with some power of two.
        // 10 in base 10 = 1010 in base 2
        // 10 in base 10 << 1 = 10100 in base 2 = 20
        // a << b = a * 2 pow b
        System.out.println(a + " << 1 = " + (a << 1)); // << Signed left shift operator

        a = -16;
        System.out.println(a + " >> 1 = " + (a >> 1)); // >> Signed Right shift operator
        System.out.println(a + " >> 3 = " + (a >> 3)); // >> Signed Right shift operator

        System.out.println(a + " >>> 1 = " + (a >>> 1)); // >> Unsigned Right shift operator
        System.out.println(a + " >>> 2 = " + (a >>> 2)); // >> Unsigned Right shift operator

        System.out.println(a + " << 1 = " + (a << 1)); // << Signed left shift operator


        a = 5;

        System.out.printf("1's Complement of %d = %d \n",a, ~a);//prints -6
        System.out.printf("2's Complement of %d = %d",a, (~a + 1));//prints -5
    }
}
