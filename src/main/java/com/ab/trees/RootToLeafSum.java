package com.ab.trees;

import com.ab.trees.impl.BinaryTreeFromLL;
import com.ab.trees.impl.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 *
 * Given a binary tree and a number,
 *  Return true if the tree has a root-to-leaf path such that adding up all the values along the path equals the given number.
 *  Return false if no such path can be found.
 */
public class RootToLeafSum {
    public static void main(String[] args) {
        BinaryTreeFromLL.BinaryTree binaryTree = BinaryTreeFromLL.getBinaryTree();
        System.out.println(binaryTree.root);
        int sum = 8;
        List<Node> rootToLeafNodeList = new ArrayList<>();
        boolean sumExists = rootToLeafSum(binaryTree.root, sum, rootToLeafNodeList);
        if (sumExists){
            System.out.println("Root to Leaf Path");
            rootToLeafNodeList.forEach(node -> System.out.println(node.data + ""));
        }else{
            System.out.println("Not Exists");
        }
    }

    private static boolean rootToLeafSum(Node root, int sum, List<Node> resultList) {
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            if (root.data == sum){
                resultList.add(root);
                return true;
            }else{
                return false;
            }
        }
        if (rootToLeafSum(root.left, sum-root.data, resultList)
        || rootToLeafSum(root.right, sum- root.data,resultList)){
            resultList.add(root);
            return true;
        }
        return false;
    }


}
