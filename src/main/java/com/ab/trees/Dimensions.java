package com.ab.trees;

import com.ab.trees.impl.BinarySearchTreeFromLL;
import com.ab.trees.impl.Node;

/**
 * Size of the tree is number of nodes in the tree
 * Height = Maximum Depth = the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Diameter of a tree is the number of nodes on the longest path between two leaves in the tree.
 *
 * @author Arpit Bhardwaj
 */
public class Dimensions {
    static int diameter = Integer.MIN_VALUE;

    public static void main(String[] args) {
        BinarySearchTreeFromLL.BinarySearchTree tree = BinarySearchTreeFromLL.getBinarySearchTree();
        System.out.println(tree.root);
        int height = determineHeight(tree.root);
        int size = determineSize(tree.root);
        System.out.println("Size is : " + size);
        System.out.println("Height is : " + height);
        System.out.println("Diameter is : " + diameter);
    }

    public static int determineHeight(Node root) {
        if(root == null){
            return 0;
        }
        int leftSubTreeHeight = determineHeight(root.left);
        int rightSubTreeHeight = determineHeight(root.right);
        diameter = Math.max(diameter, leftSubTreeHeight+rightSubTreeHeight+1);
        return Math.max(leftSubTreeHeight,rightSubTreeHeight) + 1;
    }

    public static int determineSize(Node root) {
        if(root == null){
            return 0;
        }
        int leftSubTreeSize = determineSize(root.left);
        int rightSubTreeSize = determineSize(root.right);
        return leftSubTreeSize + rightSubTreeSize + 1;
    }

}
