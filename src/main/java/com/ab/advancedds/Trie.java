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
 *
 * Use Case:
 *      To design autocomplete feature in search bars
 */
public class Trie {

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insertRecursive(String word) {
        insertRecursiveUtil(root,word,0);
    }

    private void insertRecursiveUtil(TrieNode current, String word, int index) {
        if (index == word.length()){
            current.endOfWord = true;
            return;
        }
        char c = word.charAt(index);
        TrieNode node = current.children.get(c);
        if (node == null){
            node = new TrieNode();
            current.children.put(c,node);
        }
        insertRecursiveUtil(node,word,index+1);
    }

    public boolean searchRecursive(String word) {
        return searchRecursiveUtil(root,word,0);
    }

    private boolean searchRecursiveUtil(TrieNode current, String word, int index) {
        if(index == word.length()){
            return current.endOfWord;
        }
        char c = word.charAt(index);
        TrieNode node = current.children.get(c);
        if (node == null){
            return false;
        }
        return searchRecursiveUtil(node,word,index+1);
    }

    public void deleteRecursive(String word) {
        deleteRecursiveUtil(root,word,0);
    }

    private void deleteRecursiveUtil(TrieNode current, String word, int index) {

    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertRecursive("banana");
        trie.insertRecursive("apple");
        trie.insertRecursive("appium");
    }
}
