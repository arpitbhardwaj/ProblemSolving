package com.ab.stack;

import java.util.Stack;

/**
 * Infix : The expression of the form a op b. When an operator is in-between every pair of operands.
 * Postfix : The expression of the form a b op. When an operator is followed for every pair of operands.
 * Postfix notation, also known as reverse Polish notation
 *
 * @author Arpit Bhardwaj
 */
public class InfixToPostfix {
    public static void main(String[] args) {
        String infixExp = "a+b*(c^d-e)^(f+g*h)-i";
        String postfixExp = generatePostfixFromInfix(infixExp);
        System.out.println("Infix Expression : " + infixExp);
        System.out.println("Postfix Expression : " + postfixExp);
    }

    private static String generatePostfixFromInfix(String infixExp) {
        String postfixExp = "";
        Stack<Character> characterStack = new Stack<>();

        for (int i = 0; i < infixExp.length(); i++) {
            char character = infixExp.charAt(i);

            if(Character.isLetterOrDigit(character)){
                postfixExp += character;
            }else if(character == '('){
                characterStack.push(character);
            }else if (character == ')'){
                while (!characterStack.isEmpty() && characterStack.peek() != '('){
                    postfixExp += characterStack.pop();
                }
                if (!characterStack.isEmpty() && characterStack.peek() != '('){
                    throw new IllegalArgumentException("Invalid Infix Expression");
                }else{
                    characterStack.pop();
                }
            }else{
                while (!characterStack.isEmpty() && calculatePrecedence(character) <= calculatePrecedence(characterStack.peek())){
                    if(characterStack.peek() == '('){
                        throw new IllegalArgumentException("Invalid Infix Expression");
                    }
                    postfixExp += characterStack.pop();
                }
                characterStack.push(character);
            }
        }
        while (!characterStack.isEmpty()){
            if(characterStack.peek() == '('){
                throw new IllegalArgumentException("Invalid Infix Expression");
            }
            postfixExp += characterStack.pop();
        }
        return postfixExp;
    }

    private static int calculatePrecedence(char character) {
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
}
