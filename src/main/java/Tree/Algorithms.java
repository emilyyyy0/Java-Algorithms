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

        // FIND HEIGHT FUNCTION
        System.out.println("FINDING THE HEIGHT OF THE BINARY TREE");
        Node rootNode3 = new Node();
        rootNode3.data = 10;

        Node nodeTwo3 = new Node();
        nodeTwo3.data = 5;
        rootNode3.left = nodeTwo3;

        Node nodeThree3 = new Node();
        nodeThree3.data = 15;
        rootNode3.right = nodeThree3;

        Node nodeFour3 = new Node();
        nodeFour3.data = 3;
        rootNode3.left.left = nodeFour3;

        Node nodeFive3 = new Node();
        nodeFive3.data = 7;
        rootNode3.right.right = nodeFive3;

        BinaryTree binaryTree3 = new BinaryTree();

        System.out.println(binaryTree3.findHeight(rootNode3));

    }
}
