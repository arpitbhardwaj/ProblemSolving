package com.ab.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 */
public class LeftView {
    static int maxLevel = 0;
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.getSampleBinaryTree();
        System.out.println(binaryTree.root);
        List<Integer> leftViewNodes = leftView(binaryTree.root);
        System.out.println(leftViewNodes.toString());
    }

    private static List<Integer> leftView(Node root) {
        List<Integer> result = new ArrayList<>();
        leftViewUtil(root,1,result);
        return result;
    }
    private static void leftViewUtil(Node root,int level,List<Integer> result) {
        //base case
        if (root == null){
            return;
        }
        if(level > maxLevel){
            result.add(root.data);
            maxLevel = level;
        }
        leftViewUtil(root.left, level + 1, result);
        leftViewUtil(root.right, level + 1, result);
    }
}
