package com.ab.recursion;

/**
 * @author Arpit Bhardwaj
 *
 * Types of Recursion
 *      Direct Recursion
 *          Tail Recursion - If a recursive function calling itself and that recursive call is the last statement in the function
 *          Head Recursion - If a recursive function calling itself and that recursive call is the first statement in the function
 *          Linear Recursion - If a recursive function calling itself for one time
 *          Tree Recursion - if a recursive function calling itself for more than one time
 *          Nested Recursion - a recursive function will pass the parameter as a recursive call. That means “recursion inside recursion”
 *      Indirect Recursion
 *
 *
 * When to use recursion
 *
 * - When we can easily break down a problem into similar subproblem
 * - When we are fine with extra overhead (both time and space) that comes with it
 * - When we need a quick working solution instead of efficient one
 * - When traverse a tree
 * - When we use memoization in recursion
 *
 *
 * Recursion in 3 Steps
 *
 * Step 1 : Recursive case - the flow
 * Step 2 : Base case - the stopping criterion
 * Step 3 : Unintentional case - the constraint
 *
 */