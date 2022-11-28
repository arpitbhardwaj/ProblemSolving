package com.ab.trees;

import com.ab.trees.impl.GenericNode;

/**
 * @author Arpit Bhardwaj
 *
 * From Inorder and PreOrder
 * From Inorder and LevelOrder
 * From Inorder and PostOrder
 *
 * In a Preorder sequence, leftmost element is the root of the tree.
 * In a Levelorder sequence, leftmost element is the root of the tree.
 * In a Postorder sequence, rightmost element is the root of the tree.
 */
public class ConstructTree {

    static int preIndex = 0;//for indexing preOrder array
    //static int postIndex = 0;//for indexing postOrder array

    public static void main(String[] args) {
        /*Character[] preOrder = {'A', 'B', 'D', 'E', 'C', 'F'};
        Character[] inOrder = {'D', 'B', 'E', 'A', 'F', 'C'};
        Character[] postOrder = {'D', 'B', 'E', 'A', 'F', 'C'};*/

        //Integer[] preOrder = {1, 2, 4, 5, 3, 6};
        Integer[] inOrder = {4, 2, 5, 1, 6, 3};
        Integer[] postOrder = {4, 5, 2, 6, 3, 1};

        /*Integer[] inOrder = {4, 8, 2, 5, 1, 6, 3, 7};
        Integer[] postOrder = {8, 4, 5, 2, 6, 7, 3, 1};*/

        //postIndex = postOrder.length - 1;
        ConstructTree constructTree = new ConstructTree();

        //GenericNode<Character> root = constructTree.constructTreeFromInOrderPreOrder(inOrder, preOrder, 0, inOrder.length - 1);
        //GenericNode<Integer> root = constructTree.constructTreeFromInOrderPreOrder(inOrder,preOrder,0,inOrder.length - 1);
        Index pIndex = new Index();
        pIndex.index = postOrder.length - 1;

        GenericNode<Integer> root = constructTree.constructTreeFromInOrderPostOrder(inOrder, postOrder, 0, inOrder.length - 1, pIndex);
        System.out.println(root);
    }

    private <T> GenericNode<T> constructTreeFromInOrderPreOrder(T[] inOrder, T[] preOrder, int start, int end) {
        if(start > end){
            return null;
        }

        //take the node one by one from preOrder
        GenericNode<T> root = new GenericNode(preOrder[preIndex++]);

        //base condition for leaf nodes
        if(start == end){
            return root;
        }

        int inIndex = this.getInorderIndex(inOrder, start, end, root.data);//for indexing inOrder array

        root.left = constructTreeFromInOrderPreOrder(inOrder,preOrder,start,inIndex-1);
        root.right = constructTreeFromInOrderPreOrder(inOrder,preOrder,inIndex+1,end);

        return root;
    }

    private <T> GenericNode<T> constructTreeFromInOrderPostOrder(T[] inOrder, T[] postOrder, int start, int end,Index pIndex) {
        if(start > end){
            return null;
        }

        //take the node one by one from preOrder
        GenericNode<T> root = new GenericNode(postOrder[pIndex.index]);
        (pIndex.index)--;
        //base condition for leaf nodes
        if(start == end){
            return root;
        }

        int inIndex = this.getInorderIndex(inOrder, start, end, root.data);//for indexing inOrder array

        root.right = constructTreeFromInOrderPostOrder(inOrder,postOrder,inIndex+1,end,pIndex);
        root.left = constructTreeFromInOrderPostOrder(inOrder,postOrder,start,inIndex-1,pIndex);

        return root;
    }

    private <T> int getInorderIndex(T[] arr, int start, int end, T value) {
        //search the node in inOrder array
        int inIndex = 0;
        for (int i = start; i <= end; i++) {
            if(value == arr[i]){
                inIndex = i;
            }
        }
        return inIndex;
    }

    // Class Index created to implement pass by reference of Index
    static class Index {
        int index;
    }
}
