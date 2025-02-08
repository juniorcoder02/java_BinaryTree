// Class representing the Preorder traversal implementation
public class PreorderTraversal {
    
    // Node class to define structure of a binary tree node
    static class Node {
        int data; // Data stored in the node
        Node left, right; // Left and right child references

        // Constructor to initialize a node
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // BinaryTree class to handle tree creation and traversal
    static class BinaryTree {
        static int idx = -1; // Index to keep track of array position during tree construction

        /**
         * Method to build a binary tree from an array representation.
         * Uses Preorder construction: Root → Left → Right.
         * - If the value is -1, return null (indicating no node at that position).
         * - Otherwise, create a new node and recursively build left and right subtrees.
         */
        public static Node buildTree(int[] nodes) {
            idx++; // Move to the next index
            if (idx >= nodes.length || nodes[idx] == -1) // Base case: null node
                return null;

            // Create a new node with the current value
            Node newNode = new Node(nodes[idx]);

            // Recursively construct the left and right subtrees
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode; // Return the constructed node
        }

        /**
         * Preorder Traversal: Root → Left → Right
         * - Print the root node first
         * - Recursively traverse the left subtree
         * - Recursively traverse the right subtree
         */
        public static void preorderTraversal(Node root) {
            if (root == null) {
                System.out.print("null "); // Print -1 for null nodes (for clarity)
                return;
            }

            System.out.print(root.data + " "); // Print current node's data
            preorderTraversal(root.left); // Recursively visit left subtree
            preorderTraversal(root.right); // Recursively visit right subtree
        }
    }

    // Main method to test the tree construction and traversal
    public static void main(String[] args) {
        // Array representation of a binary tree (Preorder format with -1 as null)
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        // Create a BinaryTree instance and build the tree
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        // Print the root node's data
        System.out.println("Root Node: " + root.data);

        // Perform Preorder Traversal
        System.out.print("Preorder Traversal: ");
        tree.preorderTraversal(root);
    }
}
