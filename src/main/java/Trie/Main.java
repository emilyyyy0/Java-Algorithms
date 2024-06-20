package Trie;

public class Main {

    public static void main(String[] args) {
//        TrieNode root = new TrieNode();
//        System.out.println(root.toString());
        Trie trie = new Trie();
        trie.insertKey("hello");
        trie.insertKey("world");

        // Test searchKey method
        System.out.println(trie.searchKey("hello")); // Output: true
        System.out.println(trie.searchKey("world")); // Output: true
        System.out.println(trie.searchKey("helloworld")); // Output: false
        System.out.println(trie.searchKey("hell")); // Output: false


        // New test
        Trie trie2 = new Trie();
        String[] inputStrings = { "and", "ant", "do", "geek", "dad", "ball" };

        // Insert each string into the Trie
        for (String str : inputStrings) {
            trie2.insertKey(str);
        }

        String[] searchQueryStrings = { "do", "geek", "bat" };

        // Search for each string and print whether it is found in the Trie
        for (String query : searchQueryStrings) {
            System.out.println("Query String: " + query);
            if (trie2.searchKey(query)) {
                System.out.println("The query string is present in the Trie");
            } else {
                System.out.println("The query string is not present in the Trie");
            }
        }
    }

}
