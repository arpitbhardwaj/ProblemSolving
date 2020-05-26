package com.ab.advancedds;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arpit Bhardwaj
 */
public class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode() {
        children = new HashMap<>();
        endOfWord = false;
    }
}
