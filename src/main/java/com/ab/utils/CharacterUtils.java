package com.ab.utils;

/**
 * @author Arpit Bhardwaj
 */
public class CharacterUtils {
    public static boolean isMatchingParenthesis(char char1, char char2) {
        if (char1 == '{' && char2 == '}'){
            return true;
        }else if (char1 == '(' && char2 == ')'){
            return true;
        }else if (char1 == '[' && char2 == ']'){
            return true;
        }else {
            return false;
        }
    }

    public static boolean isOpeningParenthesis(char character) {
        return (character == '{' || character == '[' || character == '(');
    }

    public static boolean isClosingParenthesis(char character) {
        return (character == '}' || character == ']' || character == ')');
    }

    public static int calculatePrecedence(char character) {
        switch (character){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                //return 4;
        }
        return -1;
    }

    public static boolean isOperand(char character) {
        return (character >= 'A' && character <= 'Z')
                ||(character >= 'a' && character <= 'z');
    }
}
