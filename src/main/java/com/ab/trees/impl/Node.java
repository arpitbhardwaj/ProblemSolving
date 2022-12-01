package com.ab.trees.impl;

/**
 * @author Arpit Bhardwaj
 */
public class Node {
    public int data;
    public Node left;
    public Node right;
    int height;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 0;
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
