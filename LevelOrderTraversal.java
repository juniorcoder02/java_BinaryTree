import java.util.*;

public class LevelOrderTraversal {

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

    // BinaryTree class to construct the tree and perform level-order traversal
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
         * Level Order Traversal (BFS)
         * 1. Use a queue to process nodes level by level.
         * 2. Use `null` as a separator to indicate level breaks.
         * 3. Print nodes in a structured manner.
         */
        public static void levelOrder(Node root) {
            if (root == null) {
                return; // If tree is empty, return
            }

            Queue<Node> q = new LinkedList<>(); // Queue for BFS traversal
            q.add(root); // Start with the root node
            q.add(null); // Level separator

            while (!q.isEmpty()) {
                Node curr = q.poll(); // Remove the front node

                if (curr == null) {
                    System.out.println(); // Print a new line for the next level

                    // If queue is empty, all levels are processed
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null); // Add a new level separator
                    }
                } else {
                    System.out.print(curr.data + " "); // Print the current node

                    // Enqueue left and right children if they exist
                    if (curr.left != null) {
                        q.add(curr.left);
                    }
                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                }
            }
        }
    }

    // Main function to execute the program
    public static void main(String[] args) {
        // Array representing a binary tree in Preorder format (-1 means null)
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        // Creating a BinaryTree instance and building the tree
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        // Perform Level Order Traversal
        System.out.println("Level Order Traversal:");
        tree.levelOrder(root);
    }
}
