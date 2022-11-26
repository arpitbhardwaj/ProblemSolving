package com.ab.stack.impl;

import java.util.Arrays;

public class StackFromArray {

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(4);
        customStack.push(11);
        customStack.push(20);
        customStack.push(3);
        customStack.printStack();

        System.out.println(customStack.pop());
        customStack.push(23);
        customStack.push(12);
        customStack.printStack();

        System.out.println(customStack.peek());
        customStack.delete();
        customStack.printStack();
    }

    private static class CustomStack {
        int arr[];
        int topOfStack;

        public CustomStack(int size) {
            this.arr = new int[size];
            this.topOfStack = -1;
        }

        public boolean isEmpty(){
            return topOfStack == -1;
        }

        public boolean isFull(){
            return topOfStack == arr.length-1;
        }

        public void push(int data) {
            if (!isFull()){
                arr[topOfStack++ + 1] = data;
            }
        }

        public int pop() {
            if (!isEmpty()){
                return arr[topOfStack--];
            }
            return -1;
        }

        public int peek() {
            if (!isEmpty()){
                return arr[topOfStack];
            }
            return -1;
        }

        public void delete() {
            arr = null;
        }

        public void printStack(){
            System.out.println(Arrays.toString(arr));
        }
    }
}
