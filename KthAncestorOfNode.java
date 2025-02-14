public class KthAncestorOfNode {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    /**
     * Finds the kth ancestor of the given node in the binary tree.
     * @param root  The root of the tree
     * @param n     The target node whose ancestor is to be found
     * @param k     The kth ancestor level
     * @return      The distance from the target node (or -1 if not found)
     */
    public static int kthAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;  // Base case: if node not found
        }

        if (root.data == n) {
            return 0;  // Target node found, return 0 distance
        }

        // Recursively find the target node in left and right subtrees
        int leftDist = kthAncestor(root.left, n, k);
        int rightDist = kthAncestor(root.right, n, k);

        // If the node is not found in either subtree, return -1
        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        // Find the max distance from either left or right subtree
        int max = Math.max(leftDist, rightDist);

        // If we have reached the kth ancestor, print it
        if (max + 1 == k) {
            System.out.println(root.data);
        }

        // Return the updated distance
        return max + 1;
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

        int n = 5, k = 1;
        kthAncestor(root, n, k);
    }
}
