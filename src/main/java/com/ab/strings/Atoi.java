package com.ab.strings;

/**
 * @author Arpit Bhardwaj
 *
 * atoi is a function in the C programming language that converts a string into an integer numerical representation.
 * atoi stands for ASCII to integer.
 *
 */
public class Atoi {
    public static void main(String[] args) {
        String str = "8795";
        int i = atoi(str);
        System.out.println(i);
    }

    private static int atoi(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            result = result * 10 + (str.charAt(i) - '0');
        }
        return result;
    }
}
