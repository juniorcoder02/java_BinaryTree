// Java program to perform Postorder Traversal of a Binary Tree
public class PostorderTraversal {

    // Node class representing a single node in a binary tree
    static class Node {
        int data; // Stores the node's value
        Node left, right; // Left and Right child references

        // Constructor to initialize a node
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // BinaryTree class to construct the tree and perform postorder traversal
    static class BinaryTree {
        static int idx = -1; // Index to track position in the input array

        /**
         * Builds a binary tree using an array representation.
         * - If value is `-1`, return null (indicating no node).
         * - Otherwise, create a new node and recursively build left and right subtrees.
         */
        public static Node buildTree(int[] nodes) {
            idx++; // Move to the next index in the array

            // Base Case: If `-1`, return null (leaf node reached)
            if (idx >= nodes.length || nodes[idx] == -1) {
                return null;
            }

            // Create a new node with the current value
            Node newNode = new Node(nodes[idx]);

            // Recursively build the left and right subtrees
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode; // Return the constructed node
        }

        /**
         * Postorder Traversal: Left → Right → Root
         * 1. Recursively visit the left subtree
         * 2. Recursively visit the right subtree
         * 3. Print the current node's value
         */
        public static void postorderTraversal(Node root) {
            if (root == null) {
                return; // Base case: If node is null, stop
            }

            postorderTraversal(root.left); // Visit left subtree
            postorderTraversal(root.right); // Visit right subtree
            System.out.print(root.data + " "); // Print the current node
        }
    }

    // Main function to execute the program
    public static void main(String[] args) {
        // Array representing a binary tree in Preorder format (-1 means null)
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        // Creating a BinaryTree instance and building the tree
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        // Print the root node's data
        System.out.println("Root Node: " + root.data);

        // Perform Postorder Traversal
        System.out.print("Postorder Traversal: ");
        tree.postorderTraversal(root);
    }
}
