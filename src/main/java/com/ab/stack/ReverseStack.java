package com.ab.stack;

import java.util.Stack;

/**
 * @author Arpit Bhardwaj
 *
 * reverse a stack using recursion
 *
 */
public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(92);
        stack.push(23);
        System.out.println(stack);
        reverseStack(stack);
        System.out.println(stack);
    }

    private static void reverseStack(Stack<Integer> stack) {
        if (!stack.isEmpty()){
            int popEle = stack.pop();
            reverseStack(stack);
            reverseStackInsert(stack,popEle);
        }
    }

    private static void reverseStackInsert(Stack<Integer> stack, int element) {
        if (stack.isEmpty()){
            stack.push(element);
        }else{
            int popEle = stack.pop();
            reverseStackInsert(stack,element);
            stack.push(popEle);
        }
    }
}
