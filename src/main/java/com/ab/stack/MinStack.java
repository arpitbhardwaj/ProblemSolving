package com.ab.stack;

import java.util.Stack;

/**
 * @author Arpit Bhardwaj
 *
 *  Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), peek(), getMin()
 *  Two Approaches:
 *      1: An approach that uses O(1) time and O(n) extra space
 *      2: An approach that uses O(1) time and O(1) extra space
 */
public class MinStack {
    Stack<Integer> s;
    int minEle;

    public MinStack() {
        s = new Stack<>();
    }

    public void push(int ele){
        //If stack is empty, insert x into the stack and make minEle equal to x.
        if (s.isEmpty()){
            s.push(ele);
            minEle = ele;
        }else{
            //If x is greater than or equal to minEle, simply insert x.
            if(ele >= minEle){
                s.push(ele);
            }else{
                //If x is less than minEle, insert (2*x – minEle) into the stack and make minEle equal to x.
                s.push(2*ele - minEle);
                minEle = ele;
            }
        }
    }

    public void pop(){
        if(s.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }else{
            int ele = s.pop();
            //If popped element is greater than min element, the min element in the stack is still minEle.
            //If popped element is less than or equal to minEle, the min element now becomes (2*minEle – y), so update (minEle = 2*minEle – y)
            if (ele < minEle){
                minEle = 2* minEle - ele;
            }
        }
    }

    public int top() {
        if(s.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }else{
            int ele = s.peek();
            if(ele < minEle){
                return minEle;
            }
            return ele;
        }
    }

    public int getMin(){
        if(s.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }else{
            return minEle;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(5);
        System.out.println("Minimum Element: " + minStack.getMin());
        minStack.push(2);
        minStack.push(1);
        System.out.println("Minimum Element: " + minStack.getMin());
        minStack.pop();
        System.out.println("Minimum Element: " + minStack.getMin());
        minStack.push(0);
        System.out.println("Minimum Element: " + minStack.getMin());
    }
}
