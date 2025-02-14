import java.util.ArrayList;

public class LowestCommonAncestor {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    /**
     * Method 1: Find LCA using paths stored in lists.
     */
    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        // Get paths from root to n1 and n2
        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // Find the last common node in the paths
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        return path1.get(i - 1);
    }

    /**
     * Helper function to find path from root to a given node.
     */
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) return false;

        path.add(root);

        if (root.data == n) return true;

        if (getPath(root.left, n, path) || getPath(root.right, n, path)) return true;

        path.remove(path.size() - 1);
        return false;
    }

    /**
     * Method 2: Optimized recursive approach.
     */
    public static Node lca2(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLCA = lca2(root.left, n1, n2);
        Node rightLCA = lca2(root.right, n1, n2);

        if (rightLCA == null) return leftLCA;
        if (leftLCA == null) return rightLCA;

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 5;
        System.out.println(lca(root, n1, n2).data);
        System.out.println(lca2(root, n1, n2).data);
    }
}
