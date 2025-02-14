public class KthLevelOfTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Function to print nodes at the kth level of a binary tree
    public static void kthLevel(Node root, int currentLevel, int k) {
        if (root == null) {
            return;
        }
        if (currentLevel == k) {
            System.out.print(root.data + " ");
            return;
        }
        kthLevel(root.left, currentLevel + 1, k);
        kthLevel(root.right, currentLevel + 1, k);
    }

    public static void main(String[] args) {
        // Constructing the tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int k = 2;
        kthLevel(root, 0, k); // Start from level 0
    }
}
