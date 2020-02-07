package com.ab.strings;

/**
 * @author Arpit Bhardwaj
 *
 * Input: getting good at coding needs a lot of practice
 * Output: practice of lot a needs coding at good getting
 */
public class ReverseWords {

    private static final String SPACE = " ";
    private static final String EMPTY = "";

    public static void main(String[] args) {
        String input = "getting good at coding needs a lot of practice";
        System.out.println("Input String : " + input);
        String reverseOfInput = reverseWords(input);
        System.out.println("Reverse of Input : " + reverseOfInput);
    }

    private static String reverseWords(String input) {
        String reverse = EMPTY;
        String[] strArr = input.split(SPACE);
        int strLength = strArr.length;
        for (int i = strLength - 1; i >= 0; i--) {
            reverse += strArr[i] + SPACE;
        }
        return reverse;
    }
}
