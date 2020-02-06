package com.ab.trees;

/**
 * @author Arpit Bhardwaj
 */
public class LowestCommonAncestorBST {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.getSampleBinarySearchTree();
        int n1 = 14;
        int n2 = 18;
        Node node = getLCA(binaryTree.root,n1,n2);
        System.out.print(String.format("Lowest common ancestor of %s and %s is : %s",n1,n2,node.data));
    }

    private static Node getLCA(Node root, int n1, int n2) {
        System.out.println(root.data + " " + n1 +" "+ n2);

        if(root == null){
            return null;
        }
        if(root.data > n1 && root.data > n2){
            return getLCA(root.left,n1,n2);
        }else if (root.data < n1 && root.data < n2){
            return getLCA(root.right,n1,n2);
        }else{
            return root;
        }
    }
}
