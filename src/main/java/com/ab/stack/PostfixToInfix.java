package com.ab.stack;

import com.ab.utils.CharacterUtils;

import java.util.Stack;

/**
 * Infix : The expression of the form a op b. When an operator is in-between every pair of operands.
 * Postfix : The expression of the form a b op. When an operator is followed for every pair of operands.
 * Postfix notation, also known as reverse Polish notation
 *
 *
 * @author Arpit Bhardwaj
 */
public class PostfixToInfix {
    public static void main(String[] args) {
        String postfixExp = "abcd^e-fgh*+^*+i-";
        String infixExp = generateInfixFromPostfix(postfixExp);
        System.out.println("Postfix Expression : " + postfixExp);
        System.out.println("Infix Expression : " + infixExp);
    }

    private static String generateInfixFromPostfix(String postfixExp) {
        String infixExp = "";
        //Stack<Character> characterStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < postfixExp.length(); i++) {
            char character = postfixExp.charAt(i);

            if(CharacterUtils.isOperand(character)){
                stringStack.push(character + "");
            }else{
                String operand1 = stringStack.pop();
                String operand2 = stringStack.pop();

                stringStack.push("(" + operand2 + character + operand1 + ")");
            }
        }
        infixExp = stringStack.pop();
        return infixExp;
    }
}
