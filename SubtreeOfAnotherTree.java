public class SubtreeOfAnotherTree {
    // Node definition for the binary tree
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    /**
     * Function to check if subRoot is a subtree of root.
     * Approach:
     * 1. Traverse the root tree.
     * 2. If a node matches subRoot's root, check if they are identical.
     * 3. If not identical, check in left and right subtrees recursively.
     *
     * Time Complexity: O(N*M) (Worst case, comparing each node with subRoot)
     * Space Complexity: O(H) (Recursive stack, where H is the height of root tree)
     */
    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false; // Base case: reached end of tree
        }

        // If current node matches subRoot's root, check if they are identical
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        // Recursively check in left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    /**
     * Function to check if two trees are identical.
     * Approach:
     * 1. If both trees are null, return true.
     * 2. If only one tree is null or values are different, return false.
     * 3. Recursively check left and right subtrees.
     *
     * Time Complexity: O(M) (M is the number of nodes in subRoot)
     * Space Complexity: O(H) (Recursive stack, where H is the height of subRoot)
     */
    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true; // Both trees are empty, so they are identical
        } 
        if (node == null || subRoot == null || node.data != subRoot.data) {
            return false; // One tree is empty, or values do not match
        }

        // Recursively check left and right subtrees
        return isIdentical(node.left, subRoot.left) && isIdentical(node.right, subRoot.right);
    }

    public static void main(String[] args) {
        // Constructing the main tree (root)
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Constructing the subtree (subRoot)
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        // Check if subRoot is a subtree of root
        System.out.println(isSubtree(root, subRoot)); // Output: true
    }
}
