package com.ab.bitwise;

/**
 * @author Arpit Bhardwaj
 */
public class BinaryToDecimal {
    public static void main(String[] args) {
        String binaryNumber = "111111001";
        int decimalNumber = convertBinaryToDecimal(binaryNumber);
        System.out.println("Decimal representation of : " + binaryNumber + " is " + decimalNumber);
        System.out.println("Decimal representation of : " + binaryNumber + " is " + Integer.parseInt(binaryNumber,2));
    }

    private static int convertBinaryToDecimal(String binaryNumber) {
        int decimalNumber = 0;
        int base_value = 1; //2 pow 0
        for (int i = binaryNumber.length() - 1; i >= 0; i--) {
            if(binaryNumber.charAt(i) == '1'){
                decimalNumber += base_value;
            }
            //base_value *= 2;
            base_value <<= 1;
        }
        return decimalNumber;
    }
}
