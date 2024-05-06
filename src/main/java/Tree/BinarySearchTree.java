package Tree;

public class BinarySearchTree {
    Node root;

    // Create an algorithm to add data to a tree in a binary search tree manner
    public void insert(int value) {
        insert(this.root, value);
    }

    // Helper function
    private Node insert(Node root, int value) {
        // root is null
        if (root == null) {
            root = new Node();
            root.data = value;
        } else if (value < root.data) {
            // insert on left
            root.left = insert(root.left, value);

        } else if (value > root.data) {
            // insert on right
            root.right = insert(root.right, value);
        }
        // if value is equal to the root, we don't insert anything, just return the root.
        return root; // if its the root, since its the only element in the tree, no left or right reference changes are needed
    }
}
