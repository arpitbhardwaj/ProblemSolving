package com.ab.trees;

/**
 * @author Arpit Bhardwaj
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        BinaryTree bt = BinaryTree.getSampleBinaryTree();
        System.out.println(bt.root);
        int n1 = 4;
        int n2 = 3;
        Node node1 = getBTLCA(bt.root,n1,n2);
        System.out.println(String.format("LCA of %s and %s is : %s",n1,n2,node1.data));

        BinaryTree bst = BinaryTree.getSampleBinarySearchTree();
        System.out.println(bst.root);
        int n3 = 14;
        int n4 = 18;
        Node node2 = getBSTLCA(bst.root,n3,n4);
        System.out.println(String.format("LCA of %s and %s is : %s",n3,n4,node2.data));
    }

    private static Node getBTLCA(Node node, int n1, int n2) {
        if(node == null){
            return null;
        }
        if(node.data == n1 || node.data == n2){
            return node;
        }

        Node left = getBTLCA(node.left,n1,n2);
        Node right = getBTLCA(node.right,n1,n2);

        if(left != null && right != null){
            return node;
        }
        return left != null ? left:right;
    }

    private static Node getBSTLCA(Node node, int n1, int n2) {
        if(node == null){
            return null;
        }
        if(node.data > n1 && node.data > n2){
            return getBSTLCA(node.left,n1,n2);
        }else if (node.data < n1 && node.data < n2){
            return getBSTLCA(node.right,n1,n2);
        }else{
            return node;
        }
    }
}
