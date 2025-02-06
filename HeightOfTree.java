// 📌 Program to find the Height of a Binary Tree
// Height is the number of edges in the longest path from root to a leaf node.

public class HeightOfTree {
    
    // ✅ Step 1: Define the Node structure for Binary Tree
    static class Node {
        int data;  // Stores the value of the node
        Node left; // Reference to left child
        Node right; // Reference to right child

        // Constructor to initialize a node
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // ✅ Step 2: Recursive function to compute the height of the tree
    public static int height(Node root) {
        // Base case: If tree is empty, height is 0
        if (root == null) {
            return 0;
        }

        // Recursively calculate height of left and right subtrees
        int leftHeight = height(root.left);  // Get height of left subtree
        int rightHeight = height(root.right); // Get height of right subtree

        // Height of current node = 1 + max(left height, right height)
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        // ✅ Step 3: Manually build the Binary Tree
        /*
                1
               / \
              2   3
             / \  / \
            4   5 6  7
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // ✅ Step 4: Calculate and print the height of the tree
        System.out.println("Height of the tree: " + height(root));
    }
}
