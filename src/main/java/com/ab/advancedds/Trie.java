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
 *      autocomplete feature
 */
public class Trie {

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    /**
     * Case 1: A trie is blank
     * Case 2: New string's prefix is common to another string prefix
     * Case 3: New string's prefix is already present as complete string
     * Case 4: String to be inserted is already present in trie
     */
    public void insert(String word) {
        insertUtil(root,word,0);
    }

    private void insertUtil(TrieNode current, String word, int index) {
        if (index == word.length()){
            current.endOfWord = true;
            return;
        }
        char ch = word.charAt(index);
        TrieNode childNode = current.children.get(ch);
        if (childNode == null){
            childNode = new TrieNode();
            current.children.put(ch,childNode);
        }
        insertUtil(childNode,word,index+1);
    }

    /**
     * Case 1: String does not exist in trie
     * Case 2: String exist in trie
     * Case 3: String is a prefix of another string, but it does not exist in trie
     */
    public boolean search(String word) {
        return searchUtil(root,word,0);
    }

    private boolean searchUtil(TrieNode current, String word, int index) {
        if(index == word.length()){
            return current.endOfWord;
        }
        char ch = word.charAt(index);
        TrieNode childNode = current.children.get(ch);
        if (childNode == null){
            return false;
        }
        return searchUtil(childNode,word,index+1);
    }

    /**
     * Case 1: Another string prefix is the prefix of the string we want to delete
     * Case 2: String to be deleted is the prefix of another string
     * Case 3: Another string is the prefix of the string we want to delete
     * Case 4: Not any node depends on the string to be deleted
     */
    public boolean delete(String word) {
        return deleteUtil(root,word,0);
    }

    private boolean deleteUtil(TrieNode current, String word, int index) {
        boolean cantThisNodeBeDeleted;
        char ch = word.charAt(index);
        TrieNode childNode = current.children.get(ch);
        //case 1
        if (childNode.children.size() > 1){
            deleteUtil(childNode, word, index+1);
            return false;
        }
        //case 2
        if (index == word.length() -1){
            if (childNode.children.size() >= 1){
                childNode.endOfWord = false;
                return false;
            } else {
                current.children.remove(ch);
                return true;
            }
        }
        //case 3
        if (childNode.endOfWord){
            deleteUtil(childNode, word, index+1);
            return false;
        }
        //case 4
        cantThisNodeBeDeleted = deleteUtil(childNode,word,index+1);
        if (cantThisNodeBeDeleted) {
            current.children.remove(ch);
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("API");
        trie.insert("APIS");

        System.out.println(trie.search("API"));
        System.out.println(trie.search("APS"));
        System.out.println(trie.search("AP"));
        System.out.println(trie.search("APIS"));

        trie.delete("APIS");
        System.out.println(trie.search("APIS"));
    }
}
