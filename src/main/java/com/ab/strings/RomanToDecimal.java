package com.ab.strings;

/**
 * @author Arpit Bhardwaj
 *
 * Given an string in roman no format (s)  your task is to convert it to integer.
 *
 * Roman works on Subtractive Notation
 * I placed before V or X indicates one less, so four is IV (one less than 5) and 9 is IX (one less than 10).
 * X placed before L or C indicates ten less, so forty is XL (10 less than 50) and 90 is XC (ten less than a hundred).
 * C placed before D or M indicates a hundred less, so four hundred is CD (a hundred less than five hundred) and nine hundred is CM (a hundred less than a thousand).
 */
public class RomanToDecimal {
    public static void main(String[] args) {
        //String romanNum = "XL";
        String romanNum = "MCMIV";
        System.out.println("Roman Number: " + romanNum);
        int decimalNum = convertRomanToDecimal(romanNum);
        System.out.println("Decimal Number: " + decimalNum);
    }

    private static int convertRomanToDecimal(String romanNum) {
        int decimal = 0;

        for (int i = 0; i < romanNum.length(); i++) {
            char currentChar = romanNum.charAt(i);
            int nextIndex = i + 1;
            if(nextIndex < romanNum.length()){
                char nextChar = romanNum.charAt(nextIndex);
                if(romanCharValue(currentChar) >= romanCharValue(nextChar)){
                    decimal += romanCharValue(currentChar);
                }else{
                    decimal += romanCharValue(nextChar) - romanCharValue(currentChar);
                    i++;
                }
            }
        }
        return decimal;
    }

    public static int romanCharValue(char romanChar){
        switch (romanChar){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return -1;
    }
}
