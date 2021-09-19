package com.ab.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 */
public class LeftRightView {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.getSampleBinaryTree();
        System.out.println(binaryTree.root);

        List<Integer> leftViewNodes = leftView(binaryTree.root);
        System.out.println(leftViewNodes);

        List<Integer> rightViewNodes = rightView(binaryTree.root);
        System.out.println(rightViewNodes);
    }

    private static List<Integer> leftView(Node root) {
        List<Integer> result = new ArrayList<>();
        leftViewUtil(root,0,result);
        return result;
    }

    private static List<Integer> rightView(Node root) {
        List<Integer> result = new ArrayList<>();
        rightViewUtil(root,0,result);
        return result;
    }

    private static void leftViewUtil(Node root,int level,List<Integer> result) {
        //base case
        if (root == null){
            return;
        }
        if(level == result.size()){
            result.add(root.data);
        }
        leftViewUtil(root.left, level + 1, result);
        leftViewUtil(root.right, level + 1, result);
    }

    private static void rightViewUtil(Node root,int level,List<Integer> result) {
        //base case
        if (root == null){
            return;
        }
        if(level == result.size()){
            result.add(root.data);
        }
        rightViewUtil(root.right, level + 1, result);
        rightViewUtil(root.left, level + 1, result);
    }
}
