package com.ab.advancedds;

/**
 * @author Arpit Bhardwaj
 *
 * a trie, also called digital tree or prefix tree
 * space-optimized presentation of trie is calles redix tree or patricia tree.
 *
 * A trie is a tree-like data structure whose nodes store the letters of an alphabet.
 * By structuring the nodes in a particular way,
 * words and strings can be retrieved from the structure by traversing down a branch path of the tree.
 *
 * Use Case:
 *      Spelling Checker
 *      To design autocomplete feature in search bars
 */
public class Trie {

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        insertUtil(root,word,0);
    }

    private void insertUtil(TrieNode current, String word, int index) {
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
        insertUtil(node,word,index+1);
    }

    public boolean search(String word) {
        return searchUtil(root,word,0);
    }

    private boolean searchUtil(TrieNode current, String word, int index) {
        if(index == word.length()){
            return current.endOfWord;
        }
        char c = word.charAt(index);
        TrieNode node = current.children.get(c);
        if (node == null){
            return false;
        }
        return searchUtil(node,word,index+1);
    }

    public void delete(String word) {
        deleteUtil(root,word,0);
    }

    private void deleteUtil(TrieNode current, String word, int index) {
        //TODO
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("banana");
        trie.insert("apple");
        trie.insert("appium");
        trie.insert("mango");
        trie.insert("egg");

        System.out.println(trie.search("apple"));
        System.out.println(trie.search("mango"));
        System.out.println(trie.search("beetroot"));

        trie.delete("apple");
    }
}
