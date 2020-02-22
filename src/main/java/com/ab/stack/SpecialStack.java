package com.ab.stack;

import java.util.Stack;

/**
 * @author Arpit Bhardwaj
 *
 *  * Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), peek(), isEmpty(), isFull(), getMin()
 *  * Two Approaches:
 *  * 1: An approach that uses O(1) time and O(n) extra space
 *  * 2: An approach that uses O(1) time and O(1) extra space
 */
public class SpecialStack {
    Stack<Integer> s;
    int minElement;

    public SpecialStack() {
        s = new Stack<>();
    }

    public int getMin(){
        if(s.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }else{
            return minElement;
        }
    }

    public void push(int element){
        //If stack is empty, insert x into the stack and make minEle equal to x.
        if (s.isEmpty()){
            minElement = element;
            s.push(element);
        }else{
            //If x is greater than or equal to minEle, simply insert x.
            if(element >= minElement){
                s.push(element);
            }else{
                //If x is less than minEle, insert (2*x – minEle) into the stack and make minEle equal to x.
                minElement = element;
                s.push(2*element - minElement);
            }
        }
    }

    public int pop(){
        if(s.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }else{
            int element = s.pop();
            //If y is greater than or equal to minEle, the minimum element in the stack is still minEle.
            //If y is less than minEle, the minimum element now becomes (2*minEle – y), so update (minEle = 2*minEle – y)
            if (element <= minElement){
                minElement = 2*minElement - element;
            }
            return element;
        }
    }
}
