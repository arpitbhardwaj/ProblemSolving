package com.ab.advancedds;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arpit Bhardwaj
 *
 * a trie, also called digital tree or prefix tree
 * space-optimized presentation of trie is calles redix tree or patricia tree.
 *
 * A trie is a tree-like data structure whose nodes store the letters of an alphabet.
 * By structuring the nodes in a particular way, words and strings can be retrieved from the structure by traversing down a branch path of the tree.
 */
public class Trie {

    private class TrieNode{
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insertRecursive(String word) {
        insertRecursiveUtil(root,word,0);
    }

    private void insertRecursiveUtil(TrieNode root, String word, int index) {

    }

    public boolean searchRecursive(String word) {
        return searchRecursiveUtil(root,word,0);
    }

    private boolean searchRecursiveUtil(TrieNode root, String word, int index) {
        return false;
    }

    public void deleteRecursive(String word) {
        deleteRecursiveUtil(root,word,0);
    }

    private void deleteRecursiveUtil(TrieNode root, String word, int index) {

    }
}
