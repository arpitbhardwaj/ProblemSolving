package com.ab.stack;

import com.ab.utils.CharacterUtils;

import java.util.Stack;

/**
 * @author Arpit Bhardwaj
 *
 * Given a string of length n having parentheses in it, your task is to find whether given string has balanced parentheses or not.
 *
 * Implemetation using Stack takes O(n) space or using constant O(1) space
 */
public class ParenthesisChecker {
    public static void main(String[] args) {
        //char exp[] = {'{','(',')','}','[',']'};
        //char exp[] = {'{','(',')',')','[',']'};
        char exp[] = {'{','(','2',')','}','[',']'};
        if (isBalancedParenthesisExp(exp)){
            System.out.println("Balanced");
        }else {
            System.out.println("Not Balanced");
        }
    }

    private static boolean isBalancedParenthesisExp(char[] exp) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length; i++) {
            if (CharacterUtils.isOpeningParenthesis(exp[i])){
                stack.push(exp[i]);
            }
            if (CharacterUtils.isClosingParenthesis(exp[i])){
                if (stack.isEmpty()){
                    return false;
                }else if (!CharacterUtils.isMatchingParenthesis(stack.pop(),exp[i])){
                    return false;
                }
            }
        }
        if (stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }


}
