import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    /**
     * Recursive method to invert (mirror) the binary tree.
     */
    public static void invertTreeRecursive(Node root) {
        if (root == null) return;

        // Swap left and right children
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert left and right subtrees
        invertTreeRecursive(root.left);
        invertTreeRecursive(root.right);
    }

    /**
     * Iterative method to invert (mirror) the binary tree using BFS.
     */
    public static void invertTreeIterative(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // Swap left and right children
            Node temp = current.left;
            current.left = current.right;
            current.right = temp;

            // Add children to queue for further processing
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    /**
     * Function to print the tree in-order (left-root-right).
     */
    public static void inOrderTraversal(Node root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        // Constructing the binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Original Tree (Inorder): ");
        inOrderTraversal(root);

        // Choose one method: Recursive or Iterative
        System.out.println("\nUsing Recursive Approach:");
        invertTreeRecursive(root);
        inOrderTraversal(root);

        // Reverting the tree back to its original form
        invertTreeRecursive(root);

        System.out.println("\nUsing Iterative Approach:");
        invertTreeIterative(root);
        inOrderTraversal(root);

        System.out.println("\nOutput: Yes");
    }
}
