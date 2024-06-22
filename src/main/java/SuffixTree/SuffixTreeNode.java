package SuffixTree;

public class SuffixTreeNode {
    SuffixTreeNode[] children;
    SuffixTreeNode suffixLink; // Link to another node used in the Ukkonen's algorithm
    int start;
    int[] end;
    int suffixIndex;

    public SuffixTreeNode() {
        this.children = new SuffixTreeNode[256]; // 256 is the number of possible characters in the extended ASCII character set.
        this.suffixLink = null; // pointer to another node in the suffix tree used to speed up construction of the tree.
        this.start = 0;
        this.end = null;
        this.suffixIndex = -1;

    }

}
