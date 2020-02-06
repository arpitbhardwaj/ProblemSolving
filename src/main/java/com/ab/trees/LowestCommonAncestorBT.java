package com.ab.trees;

/**
 * @author Arpit Bhardwaj
 */
public class LowestCommonAncestorBT {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.getSampleBinaryTree();
        System.out.println(binaryTree.root);
        int n1 = 4;
        int n2 = 3;
        Node node = getLCA(binaryTree.root,n1,n2);
        System.out.print(String.format("Lowest common ancestor of %s and %s is : %s",n1,n2,node.data));
    }

    private static Node getLCA(Node root, int n1, int n2) {
        if(root == null){
            return null;
        }
        if(root.data == n1 || root.data == n2){
            return root;
        }

        Node left = getLCA(root.left,n1,n2);
        Node right = getLCA(root.right,n1,n2);

        if(left != null && right != null){
            return root;
        }
        return left != null ? left:right;
    }
}
