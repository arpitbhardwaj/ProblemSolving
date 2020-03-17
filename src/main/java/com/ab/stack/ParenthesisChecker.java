package com.ab.stack;

import com.ab.utils.CharacterUtils;

import java.util.Stack;

/**
 * @author Arpit Bhardwaj
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
