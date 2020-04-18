package com.ab.trees;

/**
 * @author Arpit Bhardwaj
 *
 * The diameter of a tree is the number of nodes on the longest path between two leaves in the tree.
 */
public class BinaryTreeDiameter {

    static class Diameter{
        static int diameter = Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.getSampleBinaryTree();
        System.out.println(binaryTree.root);
        int diameter = determineDiameter(binaryTree.root);
        System.out.println("Diameter of Sample Binary Tree is : " + diameter);
    }

    private static int determineDiameter(Node root) {
        if(root == null){
            return 0;
        }
        determineHeight(root);
        return Diameter.diameter;
    }

    private static int determineHeight(Node root) {
        if(root == null){
            return 0;
        }
        int leftSubTreeHeight = determineHeight(root.left);
        int rightSubTreeHeight = determineHeight(root.right);

        Diameter.diameter = Math.max(Diameter.diameter, leftSubTreeHeight+rightSubTreeHeight+1);

        return Math.max(leftSubTreeHeight,rightSubTreeHeight) + 1;
    }


}
