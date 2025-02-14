public class TransformToSumTree {
    // Node structure
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Function to transform the tree into a Sum Tree
    public static int transForm(Node root) {
        if (root == null) {
            return 0;
        }

        // Recursively transform left and right subtree
        int leftChild = transForm(root.left);
        int rightChild = transForm(root.right);

        // Store current node's data before updating
        int data = root.data;

        // Compute new value for the current node
        int newLeft = (root.left == null) ? 0 : root.left.data;
        int newRight = (root.right == null) ? 0 : root.right.data;
        root.data = newLeft + leftChild + newRight + rightChild;

        // Return original node's data for parent's calculation
        return data;
    }

    // Function to print Preorder traversal of the tree
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
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

        // Transform into Sum Tree
        transForm(root);

        // Print Preorder traversal
        preOrder(root);
    }
}
