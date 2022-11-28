package com.ab.trees.impl;

/**
 * @author Arpit Bhardwaj
 */
public class GenericNode<T> {
    public T data;
    public GenericNode left;
    public GenericNode right;

    public GenericNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
        if(right!=null) {
            right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(String.valueOf(data)).append("\n");
        if(left!=null) {
            left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }
        return sb;
    }

    @Override
    public String toString() {
        return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
    }
}
