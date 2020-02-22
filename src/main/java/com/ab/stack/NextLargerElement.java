package com.ab.stack;

import java.util.Stack;

/**
 * @author Arpit Bhardwaj
 *
 * Given an array A of size N having distinct elements,
 * the task is to find the next greater element for each element of the array in order of their appearance in the array.
 * If no such element exists, output -1
 *
 *  {13, 7, 6, 12}
 *    Element        NGE
 *    13      -->    -1
 *    7       -->     12
 *    6       -->     12
 *    12      -->     -1
 */
public class NextLargerElement {
    public static void main(String[] args) {
        //int[] arr =  {13, 7, 6, 12};
        int[] arr = { 11, 13, 21, 3 };
        printNextLargerElement(arr);
    }

    private static void printNextLargerElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int currElement = arr[i];
            int next = currElement;

            if (!stack.isEmpty()){
                /*int poppedElement = stack.pop();
                while (next > poppedElement){
                    //next will be the Next Greater Element of popped one
                    System.out.println(poppedElement + "-->" + next);
                    if (stack.isEmpty()){
                        break;
                    }else{
                        poppedElement = stack.pop();
                    }
                }
                if (next <= poppedElement){
                    stack.push(poppedElement);
                }*/
                while (next > stack.peek()){
                    int poppedElement = stack.pop();
                    //next will be the Next Greater Element of popped one
                    System.out.println(poppedElement + "-->" + next);
                    if (stack.isEmpty()){
                        break;
                    }
                }
            }
            stack.push(next);
        }

        while (!stack.isEmpty()){
            int poppedElement = stack.pop();
            int next = -1;
            System.out.println(poppedElement + "-->" + next);
        }
    }
}
