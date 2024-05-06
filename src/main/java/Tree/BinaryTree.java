package Tree;

public class BinaryTree {
    Node root;

    public void preOrderTraversal() {
        preOrderTraversal(this.root);
    }

    // Helper function with core implementation
    private void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            //recursively traverse the left and right trees
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
        // we visit the root, then recursively visit all nodes in the left subtree and right subtree.
    }


    public void inOrderTraversal() {
        inOrderTraversal(this.root);
    }

    private void inOrderTraversal(Node root) {
        if (root != null) {
            // we visit the left, the root, and then the right
            inOrderTraversal(root.left); // recurse to the left, print the root, then recurse to the right
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }



    public void postOrderTraversal() {
        postOrderTraversal(this.root);
    }

    private void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " "); // print the root last
        }
    }





}
