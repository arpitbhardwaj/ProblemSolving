package com.ab.advancedds;

/**
 * @author Arpit Bhardwaj
 *
 * Segment tree is also called range tree
 * Segment tree is a data structure similar to heap.
 * Segment Tree is a full binary tree (every node has 0 or 2 children)
 * leaf nodes and represent the single element from the given array for which Segment tree would be built.
 * Each node except the leaf of the tree will hold information about a range from the given array.
 * The closer the node to root, the more range it covers.
 *
 * The root node will hold the information for the interval [A, B]
 * For A < B,
 * the left child will hold the information for interval [A, (A+B)/2]
 * right child will hold the information for the interval [((A+B)/2)+1, B]
 *
 * Segment Tree for array contains n elements
 * Space Complexity: O(4n)
 * Worst Case Time Complexity for range queries: O(4logn)
 */
public class SegmentTree {
}
