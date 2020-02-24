package com.ab.bitwise;

/**
 * @author Arpit Bhardwaj
 */
public class DecimalToBinary {
    public static void main(String[] args) {
        int decimalNumber = 505;
        int binary[] = new int[40];
        int lengthOfBinary = convertDecimalToBinary(decimalNumber,binary);
        System.out.print("Binary representation of : "+ decimalNumber + " is ");
        for (int j = lengthOfBinary - 1; j >=0; j--) {
            System.out.print(binary[j]);
        }
        System.out.print("\nBinary representation of : "+ decimalNumber + " is " + Integer.toBinaryString(decimalNumber));
    }

    private static int convertDecimalToBinary(int num, int[] binary) {
        int index = 0;
        while(num > 0) {
            binary[index++] = num % 2;
            //num = num / 2;
            num >>>= 1;
        }
        return index;
    }


}
