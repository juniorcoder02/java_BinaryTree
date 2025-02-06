// Java program to demonstrate Inorder Traversal of a Binary Tree
public class InorderTraversal {

    // Node class representing a single node in a binary tree
    static class Node {
        int data; // Stores the node's value
        Node left, right; // Pointers to left and right child nodes

        // Constructor to initialize a node
        Node(int data) {
            this.data = data;
            this.left = null;  // Initially, left child is null
            this.right = null; // Initially, right child is null
        }
    }

    // BinaryTree class to construct the tree and perform inorder traversal
    static class BinaryTree {
        static int idx = -1; // Index to traverse the input array

        /**
         * Function to build a binary tree using an array.
         * The array follows Preorder traversal format.
         * - If value is `-1`, it represents a null node.
         * - Otherwise, create a new node and build its left and right subtrees recursively.
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
         * Inorder Traversal: Left → Root → Right
         * 1. Recursively visit the left subtree
         * 2. Print the current node's value
         * 3. Recursively visit the right subtree
         */
        public static void inorderTraversal(Node root) {
            if (root == null) {
                return; // Base case: If node is null, stop
            }

            inorderTraversal(root.left); // Visit left subtree
            System.out.print(root.data + " "); // Print the current node
            inorderTraversal(root.right); // Visit right subtree
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

        // Perform Inorder Traversal
        System.out.print("Inorder Traversal: ");
        tree.inorderTraversal(root);
    }
}
