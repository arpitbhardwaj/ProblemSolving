package com.ab.stack;

import java.util.Stack;

/**
 * @author Arpit Bhardwaj
 *
 * Given a stack of integers, sort it in ascending order using another temporary stack.
 * Given a stack of integers, sort it in ascending order using recursion.
 */
public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(92);
        stack.push(23);
        System.out.println(stack);
        //Stack<Integer> tempStack = sortStackUsingTempStack(stack);
        //System.out.println(tempStack);
        sortStack(stack);
        System.out.println(stack);
    }

    private static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()){
            int popEle = stack.pop();
            sortStack(stack);
            sortStackInsert(stack,popEle);
        }
    }

    private static void sortStackInsert(Stack<Integer> stack, int element) {
        //if (stack.isEmpty() || element > stack.peek()){ //Descending Top will be maximum
        if (stack.isEmpty() || element < stack.peek()){ //Ascending Top will be minimum
            stack.push(element);
        }else{
            // If top is greater, remove the top item and recur
            int popEle = stack.pop();
            sortStackInsert(stack,element);
            // Put back the top item removed earlier
            stack.push(popEle);
        }
    }

    private static Stack<Integer> sortStackUsingTempStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()){
            int popEle = stack.pop();
            while (!tempStack.isEmpty() && tempStack.peek() < popEle){
                stack.push(tempStack.pop());
            }
            tempStack.push(popEle);
        }
        return tempStack;
    }
}
