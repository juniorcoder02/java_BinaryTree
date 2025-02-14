public class UnivaluedBinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    /**
     * Helper function to check if the tree is univalued.
     * @param root Root node of the tree
     * @param value The value to compare against
     * @return true if all nodes have the same value, otherwise false
     */
    public static boolean isUnivalued(Node root, int value) {
        if (root == null) return true; // Base case
        if (root.data != value) return false; // If any node differs, return false
        return isUnivalued(root.left, value) && isUnivalued(root.right, value);
    }

    /**
     * Wrapper function to initiate the check.
     * @param root Root node of the tree
     * @return true if the tree is univalued, otherwise false
     */
    public static boolean isUnivaluedTree(Node root) {
        if (root == null) return true; // Empty tree is univalued
        return isUnivalued(root, root.data);
    }

    public static void main(String[] args) {
        // Sample Tree 1: Univalued
        Node root1 = new Node(1);
        root1.left = new Node(1);
        root1.right = new Node(1);
        root1.left.left = new Node(1);
        root1.left.right = new Node(1);
        
        System.out.println("Sample Output 1: " + isUnivaluedTree(root1)); // Expected Output: true

        // Sample Tree 2: Not Univalued
        Node root2 = new Node(1);
        root2.left = new Node(1);
        root2.right = new Node(2); // Different value
        root2.left.left = new Node(1);
        root2.left.right = new Node(1);
        
        System.out.println("Sample Output 2: " + isUnivaluedTree(root2)); // Expected Output: false
    }
}
