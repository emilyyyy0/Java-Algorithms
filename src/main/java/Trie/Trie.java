package Trie;

public class Trie {

    // Root node of the Trie
    private TrieNode root;

    // Constructor
    public Trie() {
        root = new TrieNode();
    }

    // Method to insert a key into the Trie
    public void insertKey(String key) {
        // Initialise the currentNode pointer with the root node
        TrieNode currentNode = root;

        // Iterate across the length of the string
        for (char c : key.toCharArray()) {
            // check if the node exists for the current character in the Trie
            if (currentNode.childNode[c - 'a'] == null) {
                // If node for current character does not exist, create a new node
                TrieNode newNode = new TrieNode();
                // keep the reference for the newly created node
                currentNode.childNode[c - 'a'] = newNode;
            }
            // move the currentNode pointer to the newly created node
            currentNode = currentNode.childNode[c - 'a'];
        }
        // set the wordEnd to true for the last currentNode pointer
        // this implies that there is a string ending at currentNode
        currentNode.wordEnd = true;
    }

    // Method to search for a key in the Trie
    public boolean searchKey(String key) {
        // Initialise the currentNode pointer with the root node
        TrieNode currentNode = root;

        // Iterate across the lenght of the key string.
        for (char c: key.toCharArray()) {
            // check if the node exists for the current character in the Trie
            if (currentNode.childNode[c - 'a'] == null) {
                // Given word does not exist in Trie
                return false;
            }
            // Move the currentNode pointer to the already existing node for the current character
            currentNode = currentNode.childNode[c - 'a'];
        }
        // return true if the currentNode's wordEnd is true, else false
        return currentNode.wordEnd;
    }

}
