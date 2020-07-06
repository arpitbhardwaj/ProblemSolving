package com.ab.heap;

/**
 *
 * Every Node can have 2 children, 0 child (last level nodes) or 1 child (there can be at most one such node).
 * If Node has No child then it’s a leaf node and returns true (Base case)
 * If Node has one child (it must be left child because it is a complete tree)
 * then we need to compare this node with its single child only.
 * If the Node has both child then check heap property at Node at recur for both subtrees.
 *
 * @author Arpit Bhardwaj
 */
public class IsBinaryHeap {
}
