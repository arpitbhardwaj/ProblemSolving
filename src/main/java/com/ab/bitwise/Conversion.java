package com.ab.bitwise;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Arpit Bhardwaj
 */
public class Conversion {
    public static void main(String[] args) {
        int decimal = 505;
        List<Integer> binaryList = convertDecimalToBinary(decimal);
        Collections.reverse(binaryList);
        String binary = binaryList.stream()
                            .map(i-> i.toString())
                            .collect(Collectors.joining());
        System.out.println("Binary of "+ decimal + " : " + binary);
        System.out.println("Decimal of "+ binary + " : " + convertBinaryToDecimal(binary));

    }

    private static List<Integer> convertDecimalToBinary(int num) {
        List<Integer> binary = new ArrayList<>();
        while(num > 0) {
            binary.add(num % 2);
            num /= 2;
        }
        return binary;
    }

    private static int convertBinaryToDecimal(String binaryNumber) {
        int decimalNumber = 0;
        int base_value = 1; //2 pow 0
        for (int i = binaryNumber.length() - 1; i >= 0; i--) {
            if(binaryNumber.charAt(i) == '1'){
                decimalNumber += base_value;
            }
            base_value *= 2;
        }
        return decimalNumber;
    }

}
