// 📌 Program to Count the Number of Nodes in a Binary Tree
// The count is the total number of nodes present in the tree.

public class CountOfNodes {
    
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

    // ✅ Step 2: Recursive function to count the number of nodes in the tree
    public static int countNodes(Node root) {
        // Base case: If tree is empty, return 0
        if (root == null) return 0;

        // Recursively count the nodes in the left and right subtrees
        int leftCount = countNodes(root.left);  
        int rightCount = countNodes(root.right); 

        // Total nodes in the current tree = left subtree nodes + right subtree nodes + 1 (current node)
        return leftCount + rightCount + 1;
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

        // ✅ Step 4: Count the total number of nodes and print the result
        System.out.println("Total number of nodes in the tree: " + countNodes(root));
    }
}
