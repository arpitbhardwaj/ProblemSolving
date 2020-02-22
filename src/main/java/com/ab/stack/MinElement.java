package com.ab.stack;

/**
 * @author Arpit Bhardwaj
 *
 * You are given N elements and your task is to Implement a Stack in which you can get minimum element in O(1) time.
 *
 * Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), peek(), isEmpty(), isFull(), getMin()
 * Two Approaches:
 * 1: An approach that uses O(1) time and O(n) extra space
 * 2: An approach that uses O(1) time and O(1) extra space
 */
public class MinElement {

    public static void main(String[] args) {
        SpecialStack specialStack = new SpecialStack();
        specialStack.push(3);
        specialStack.push(5);
        System.out.println("Minimum Element: " + specialStack.getMin());
        specialStack.push(2);
        specialStack.push(1);
        System.out.println("Minimum Element: " + specialStack.getMin());
        System.out.println("Pop Element: "+ specialStack.pop());
        System.out.println("Minimum Element: " + specialStack.getMin());
    }

}
