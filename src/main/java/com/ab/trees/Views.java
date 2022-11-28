package com.ab.trees;

import com.ab.trees.impl.BinaryTree;
import com.ab.trees.impl.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Arpit Bhardwaj
 *
 * Bottom View: A node x is there in output if x is the bottommost node at its horizontal distance.
 */
public class Views {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.getSampleBinaryTree();
        System.out.println(binaryTree.root);

        List<Integer> leftViewNodes = leftView(binaryTree.root);
        System.out.println(leftViewNodes);

        List<Integer> rightViewNodes = rightView(binaryTree.root);
        System.out.println(rightViewNodes);

        List<Integer> bottomViewNodes = bottomView(binaryTree.root);
        System.out.println(bottomViewNodes);
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


    private static List<Integer> bottomView(Node root) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        int hd = 0;
        verticalOrderUtil(root,hd,map);
        for (List<Integer> verticalList: map.values()) {
            result.add(verticalList.get(verticalList.size()-1));
        }
        return result;
    }

    private static void verticalOrderUtil(Node root, int hd, Map<Integer, List<Integer>> map) {
        if(root == null){
            return;
        }
        List<Integer> verticalList = map.get(hd);
        if (verticalList == null){
            verticalList = new ArrayList<>();
            verticalList.add(root.data);
        }else {
            verticalList.add(root.data);
        }
        map.put(hd,verticalList);
        verticalOrderUtil(root.left,hd-1,map);
        verticalOrderUtil(root.right,hd+1,map);
    }
}
