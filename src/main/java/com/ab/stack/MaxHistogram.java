package com.ab.stack;

import java.util.Stack;

/**
 * @author Arpit Bhardwaj
 *
 *  * If stack is empty or value at index of stack is less than or equal to value at current
 *  * index, push this into stack.
 *  * Otherwise keep removing values from stack till value at index at top of stack is
 *  * less than value at current index.
 *  * While removing value from stack calculate area
 *  * if stack is empty
 *  * it means that till this point value just removed has to be smallest element
 *  * so area = input[top] * i
 *  * if stack is not empty then this value at index top is less than or equal to
 *  * everything from stack top + 1 till i. So area will
 *  * area = input[top] * (i - stack.peek() - 1);
 *  * Finally maxArea is area if area is greater than maxArea.
 */
public class MaxHistogram {
    public static void main(String[] args) {
        int hist[] = {2,2,2,6,1,5,4,2,2,2,2};
        //int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
        int maxArea = maxHistogram(hist);
        System.out.println(maxArea);
    }

    public static int maxHistogram(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;
        int currIndex=0;

        while (currIndex < arr.length){
            if (stack.isEmpty() || arr[stack.peek()] <= arr[currIndex]){
                stack.push(currIndex++);
            }else{
                maxArea = calculateArea(arr,stack,currIndex,maxArea);
            }
        }

        while (!stack.isEmpty()){
            maxArea = calculateArea(arr,stack,currIndex,maxArea);
        }
        return maxArea;
    }

    private static int calculateArea(int[] arr, Stack<Integer> stack,int currIndex, int maxArea) {
        int top = stack.peek();
        stack.pop();
        int topArea = arr[top] * (stack.empty() ? currIndex : currIndex - stack.peek() - 1);
        if (maxArea < topArea){
            maxArea = topArea;
        }
        return maxArea;
    }
}
