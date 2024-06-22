package SuffixTree;

public class SuffixTree {
    static final int MAX_CHAR = 256;
    static String text = "";
    static SuffixTreeNode root = null;
    static SuffixTreeNode lastNewNode = null;
    static SuffixTreeNode activeNode = null;
    static int activeEdge = -1;
    static int activeLength = 0;
    static int remainingSuffixCount = 0;
    static int leafEnd = -1;
    static int[] rootEnd = null;
    static int[] splitEnd = null;
    static int size = -1;

    public static SuffixTreeNode newNode(int start,
                                         int[] end) {
        SuffixTreeNode node = new SuffixTreeNode();
        node.start = start;
        node.end = end;
        node.suffixLink = root;
        node.suffixIndex = -1;
        return node;
    }

    public static int edgeLength(SuffixTreeNode n) {
        return (n == root) ? 0 : n.end[0] - n.start + 1;
    }

    public static boolean walkDown(SuffixTreeNode currNode) {
        if (activeLength >= edgeLength(currNode)) {
            activeEdge += edgeLength(currNode);
            activeLength -= edgeLength(currNode);
            activeNode = currNode;
            return true;
        }
        return false;
    }

    public static void extendSuffixTree(int pos) {
        leafEnd = pos;
        remainingSuffixCount++;
        lastNewNode = null;

        while (remainingSuffixCount > 0) {
            if (activeLength == 0) {
                activeEdge = pos;
            }

            if (activeNode.children[text.charAt(activeEdge)]
                    == null) {
                activeNode.children[text.charAt(activeEdge)]
                        = newNode(pos, new int[]{leafEnd});

                if (lastNewNode != null) {
                    lastNewNode.suffixLink = activeNode;
                    lastNewNode = null;
                }
            } else {
                SuffixTreeNode next
                        = activeNode.children[text.charAt(
                        activeEdge)];
                if (walkDown(next)) {
                    continue;
                }

                int start = next.start;
                int end = next.end[0];

                if (text.charAt(start + activeLength)
                        == text.charAt(pos)) {
                    if (lastNewNode != null
                            && activeNode != root) {
                        lastNewNode.suffixLink = activeNode;
                        lastNewNode = null;
                    }

                    activeLength++;
                    break;
                }

                splitEnd = new int[]{start + activeLength
                        - 1};

                SuffixTreeNode split
                        = newNode(next.start, splitEnd);
                activeNode.children[text.charAt(activeEdge)]
                        = split;

                split.children[text.charAt(pos)]
                        = newNode(pos, new int[]{leafEnd});
                next.start += activeLength;
                split.children[text.charAt(next.start)]
                        = next;

                if (lastNewNode != null) {
                    lastNewNode.suffixLink = split;
                }

                lastNewNode = split;
            }

            remainingSuffixCount--;

            if (activeNode == root && activeLength > 0) {
                activeLength--;
                activeEdge = pos - remainingSuffixCount + 1;
            } else if (activeNode != root) {
                activeNode = activeNode.suffixLink;
            }
        }
    }

    public static void setSuffixIndexByDFS(SuffixTreeNode n,
                                           int labelHeight) {
        if (n == null)
            return;

        if (n.start != -1) {
            // Uncomment the following line to print suffix
            // tree print(n.start, n.end[0]);
        }

        int leaf = 1;
        for (int i = 0; i < MAX_CHAR; i++) {
            if (n.children[i] != null) {
                // Uncomment the following two lines to
                // print suffix index if (leaf == 1 &&
                // n.start != -1)
                //     System.out.print(" [" + n.suffixIndex
                //     + "]");

                leaf = 0;
                setSuffixIndexByDFS(
                        n.children[i],
                        labelHeight
                                + edgeLength(n.children[i]));
            }
        }

        if (leaf == 1) {
            n.suffixIndex = size - labelHeight;
            // Uncomment the following line to print suffix
            // index System.out.print(" [" + n.suffixIndex +
            // "]");
        }
    }

    public static void freeSuffixTreeByPostOrder(SuffixTreeNode n) {
        if (n == null)
            return;

        for (int i = 0; i < MAX_CHAR; i++) {
            if (n.children[i] != null) {
                freeSuffixTreeByPostOrder(n.children[i]);
            }
        }

        if (n.suffixIndex == -1) {
            n.end = null;
        }
    }

    public static void buildSuffixTree() {
        size = text.length();
        rootEnd = new int[]{-1};
        root = newNode(-1, rootEnd);
        activeNode = root;

        for (int i = 0; i < size; i++) {
            extendSuffixTree(i);
        }

        int labelHeight = 0;
        setSuffixIndexByDFS(root, labelHeight);
    }

    public static int traverseEdge(String str, int idx, int start, int end) {
        int k = 0;
        for (k = start; k <= end && idx < str.length();
             k++, idx++) {
            if (text.charAt(k) != str.charAt(idx)) {
                return -1;
            }
        }

        return (idx == str.length()) ? 1 : 0;
    }

    public static int doTraversal(SuffixTreeNode n, String str, int idx) {
        if (n == null) {
            return -1;
        }

        int res = -1;

        if (n.start != -1) {
            res = traverseEdge(str, idx, n.start, n.end[0]);
            if (res != 0) {
                return res;
            }
        }

        idx += edgeLength(n);

        if (n.children[str.charAt(idx)] != null) {
            return doTraversal(n.children[str.charAt(idx)],
                    str, idx);
        } else {
            return -1;
        }
    }

    public static void checkForSubstring(String str) {
        int res = doTraversal(root, str, 0);
        if (res == 1) {
            System.out.println("Pattern <" + str
                    + "> is a Substring");
        } else {
            System.out.println("Pattern <" + str
                    + "> is NOT a Substring");
        }
    }

    public static void printTree(SuffixTreeNode node, String indent) {
        if (node == null) {
            return;
        }
        if (node.start != -1) {
            String edgeString = text.substring(node.start, node.end[0] + 1);
            System.out.println(indent + "Edge: \"" + edgeString + "\", Start: " + node.start + ", End: " + node.end[0] + ", SuffixIndex: " + node.suffixIndex);
        } else {
            System.out.println(indent + "Root Node");
        }
        for (SuffixTreeNode child : node.children) {
            if (child != null) {
                printTree(child, indent + "    ");
            }
        }
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
//        text = "THIS IS A TEST TEXT$";
//        buildSuffixTree();
//
//        checkForSubstring("TEST");
//        checkForSubstring("A");
//        checkForSubstring(" ");
//        checkForSubstring("IS A");
//        checkForSubstring(" IS A ");
//        checkForSubstring("TEST1");
//        checkForSubstring("THIS IS GOOD");
//        checkForSubstring("TES");
//        checkForSubstring("TESA");
//        checkForSubstring("ISB");
//
//        // Free the dynamically allocated memory
//        freeSuffixTreeByPostOrder(root);

        text = "banana$";
        buildSuffixTree();

        System.out.println("Suffix Tree for: " + text);
        printTree(root, "");



    }


}
