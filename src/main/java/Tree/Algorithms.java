package Tree;


public class Algorithms {

    public static void main(String[] args) {
        Node rootNode1 = new Node();
        rootNode1.data = 2;

        BinarySearchTree tree1 = new BinarySearchTree();
        tree1.root = rootNode1;

        tree1.insert(1);
        tree1.insert(3);
        tree1.insert(4);

        //////// TRAVERSAL
        // not a binary search tree


        //          5
        //       2        4
        //    9    10  7

        Node rootNode = new Node();
        rootNode.data = 5;
        Node nodeTwo = new Node();
        nodeTwo.data = 2;
        Node nodeFour = new Node();
        nodeFour.data = 4;
        Node nodeNine = new Node();
        nodeNine.data = 9;
        Node nodeTen = new Node();
        nodeTen.data = 10;
        Node nodeSeven = new Node();
        nodeSeven.data = 7;

        rootNode.left = nodeTwo;
        rootNode.right = nodeFour;
        nodeTwo.left = nodeNine;
        nodeTwo.right = nodeTen;
        nodeFour.left = nodeSeven;

        BinaryTree tree = new BinaryTree();
        tree.root = rootNode;

        tree.preOrderTraversal(); // 5 2 9 10 4 7
        System.out.println();

        tree.inOrderTraversal(); // 9 2 10 5 7 4
        System.out.println();

        tree.postOrderTraversal(); // 9 10 2 7 4 5
        System.out.println();


    }
}
