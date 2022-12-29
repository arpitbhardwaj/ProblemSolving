package com.ab.advancedds;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arpit Bhardwaj
 *
 * Any Node can store non-repetitive multiple characters
 * Every node stores link for next character of the string
 * Every node keeps track of end of word.
 */
public class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode() {
        children = new HashMap<>();
        endOfWord = false;
    }
}
