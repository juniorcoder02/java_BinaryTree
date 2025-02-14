public class MinDistanceBetween2Nodes {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    /**
     * Finds the Lowest Common Ancestor (LCA) of two nodes in a Binary Tree.
     * @param root Root of the binary tree
     * @param n1 First node
     * @param n2 Second node
     * @return The LCA node
     */
    public static Node lca2(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root; // If root is one of the nodes, return it
        }

        // Recursively find LCA in left and right subtrees
        Node leftLCA = lca2(root.left, n1, n2);
        Node rightLCA = lca2(root.right, n1, n2);

        if (leftLCA == null) return rightLCA; // If left is null, LCA is in right subtree
        if (rightLCA == null) return leftLCA; // If right is null, LCA is in left subtree

        return root; // If both are non-null, root is the LCA
    }

    /**
     * Finds the distance from the given root to the target node.
     * @param root Root node of the tree or subtree
     * @param n Target node
     * @return Distance from root to the node, or -1 if not found
     */
    public static int lcaDist(Node root, int n) {
        if (root == null) return -1; // Node not found
        if (root.data == n) return 0; // If root is the node, distance is 0

        // Check left and right subtree distances
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) return -1; // If not found in either subtree
        return (leftDist != -1) ? leftDist + 1 : rightDist + 1;
    }

    /**
     * Computes the minimum distance between two nodes in a Binary Tree.
     * @param root Root of the tree
     * @param n1 First node
     * @param n2 Second node
     * @return Minimum distance between n1 and n2
     */
    public static int minDistance(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2); // Step 1: Find LCA
        int dist1 = lcaDist(lca, n1); // Step 2: Distance from LCA to n1
        int dist2 = lcaDist(lca, n2); // Step 3: Distance from LCA to n2
        return dist1 + dist2; // Step 4: Sum distances
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

        int n1 = 4, n2 = 5;
        System.out.println("Minimum distance between " + n1 + " and " + n2 + " is " + minDistance(root, n1, n2));
    }
}
