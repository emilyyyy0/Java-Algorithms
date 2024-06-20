package Trie;

import java.util.*;

// also known as a prefix tree

public class TrieNode {

    // Array for child nodes of each node
    public TrieNode[] childNode;

    // Used for indicating the end of a string
    public boolean wordEnd;

    // Constructor
    public TrieNode() {
        // Initialize the wordEnd variable with false
        wordEnd = false;

        // Initialize every index of the childNode array with null
        childNode = new TrieNode[26];
        for (int i = 0; i < 26; i++) {
            childNode[i] = null;
        }
    }

    @Override
    public String toString() {
        return "This is a trie node";
    }
}