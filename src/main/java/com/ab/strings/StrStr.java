package com.ab.strings;

/**
 * @author Arpit Bhardwaj
 *
 * Write an efficient algorithm to implement strstr function in Java
 * which returns the index of first occurrence of a string in another string.
 *
 * Efficinet Method is to use KMP Algorithm
 */
public class StrStr {
    public static void main(String[] args) {
        String text = "techie - coding make easy";
        String pattern = "coding";
        int index = strStr(text,pattern);
        if (index == -1){
            System.out.println("Pattern not found");
        }else{
            System.out.println("Pattern found at index : " + index);
        }
    }

    //iterative approach
    private static int strStr(String text, String pattern) {
        int textLen = text.length();
        int patternLen = pattern.length();

        if (text == null || textLen < patternLen){
            return -1;
        }
        if (pattern == null || pattern.length() == 0){
            throw new IllegalStateException("Pattern is empty");
        }

        for (int i = 0; i <= textLen - patternLen; i++) {

            for (int j = 0; j < patternLen; j++) {
                if (text.charAt(i+j) != pattern.charAt(j)){
                    break;
                }
                if (j == patternLen - 1){
                    return i;
                }
            }
        }
        return -1;
    }

    //recursive approach

}
