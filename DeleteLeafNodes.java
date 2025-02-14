public class DeleteLeafNodes {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    /**
     * Function to delete leaf nodes with the given value x.
     */
    public static Node deleteLeafNodes(Node root, int x) {
        if (root == null) return null;

        // Recursively process left and right subtrees
        root.left = deleteLeafNodes(root.left, x);
        root.right = deleteLeafNodes(root.right, x);

        // If the current node becomes a leaf and has value x, delete it
        if (root.left == null && root.right == null && root.data == x) {
            return null;
        }

        return root;
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
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(2);
        root.right.right = new Node(5);

        int x = 2; // Target value to delete

        System.out.println("Original Tree (Inorder): ");
        inOrderTraversal(root);

        root = deleteLeafNodes(root, x);

        System.out.println("\nTree after deleting leaf nodes with value " + x + ": ");
        inOrderTraversal(root);
    }
}
