package com.ab.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Arpit Bhardwaj
 * Do preorder traversal of the given Binary Tree.
 * While traversing the tree, recursively calculate Horizantal Distances(HDs)
 *
 * Horizantal Distance:
 * HD for root is 0, a right edge (edge connecting to right subtree) is considered as +1 horizontal distance and
 * a left edge is considered as -1 horizontal distance.
 *
 * Crux : If two nodes have the same Horizontal Distance (HD), then they are on the same vertical line.
 */
public class VerticalOrderTraversal {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.getSampleBinaryTree();
        System.out.println(binaryTree.root);
        System.out.println("Vertical order Traversal : ");
        printVerticalOrder(binaryTree.root);
    }

    private static void printVerticalOrder(Node root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        int hd = 0;
        verticalOrderUtil(root,hd,map);
        for (List<Integer> verticalList:
             map.values()) {
            System.out.println(verticalList);
        }
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
