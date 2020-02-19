package com.ab.trees;

/**
 * @author Arpit Bhardwaj
 */
public class SameBinaryTree {
    public static void main(String[] args) {
        BinaryTree bt1 = BinaryTree.getSampleBinaryTree();
        BinaryTree bt2 = BinaryTree.getSampleBinaryTree();
        System.out.println(bt1.root);
        System.out.println(bt2.root);
        //BinaryTree bt2 = BinaryTree.getAnotherSampleBinaryTree();
        boolean isSame = isSameBinaryTree(bt1.root,bt2.root);
        System.out.println("Are both trees same : " + isSame);
    }

    private static boolean isSameBinaryTree(Node root1, Node root2) {
        if(root1 == null && root2 == null){
            return true;
        }else if(root1 == null || root2 == null){
            return false;
        }else{
            return root1.data == root2.data
                    && isSameBinaryTree(root1.left, root2.left)
                    && isSameBinaryTree(root1.right, root2.right);
        }
    }
}
