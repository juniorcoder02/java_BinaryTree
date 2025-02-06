// 📌 Program to Calculate the Sum of All Nodes in a Binary Tree
// The sum includes the values of all nodes present in the tree.

public class SumOfNodes {

    // ✅ Step 1: Define the Node structure for Binary Tree
    static class Node {
        int data;   // Stores the value of the node
        Node left;  // Reference to the left child
        Node right; // Reference to the right child

        // Constructor to initialize a node
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // ✅ Step 2: Recursive function to calculate the sum of all nodes
    public static int sumOfNodes(Node root) {
        // Base case: If tree is empty, return 0
        if (root == null) {
            return 0;
        }

        // Recursively find the sum of the left and right subtrees
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        // Total sum of the tree = left subtree sum + right subtree sum + current node value
        return leftSum + rightSum + root.data;
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

        // ✅ Step 4: Compute and print the sum of all nodes
        System.out.println("Sum of all nodes in the tree: " + sumOfNodes(root));
    }
}
