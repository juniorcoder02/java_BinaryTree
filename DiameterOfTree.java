public class DiameterOfTree {
    
    // Node structure for the Binary Tree
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Approach 1: Naïve Recursive Solution (O(N²))
    public static int height(Node root) {
        if (root == null)
            return 0;
        int lh = height(root.left);  // Height of left subtree
        int rh = height(root.right); // Height of right subtree
        return Math.max(lh, rh) + 1; // Max height + 1 (for root node)
    }

    public static int diameter(Node root) {
        if (root == null)
            return 0;

        // Recursively find diameters of left and right subtrees
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        // Find height of left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Self-diameter (Path passing through root)
        int selfDiameter = leftHeight + rightHeight + 1;

        // Maximum of leftDiameter, rightDiameter, and selfDiameter
        return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
    }

    // Optimized Approach: Using a helper class to return both diameter and height (O(N))
    static class Info {
        int diameter;
        int height;

        public Info(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public static Info diameterOptimized(Node root) {
        if (root == null) {
            return new Info(0, 0); // Base case: Diameter and height of null node is 0
        }

        // Get left and right subtree information
        Info leftInfo = diameterOptimized(root.left);
        Info rightInfo = diameterOptimized(root.right);

        // Compute current node's diameter (path passing through root)
        int selfDiameter = leftInfo.height + rightInfo.height + 1;

        // Compute current node's height
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        // Compute overall diameter
        int diameter = Math.max(selfDiameter, Math.max(leftInfo.diameter, rightInfo.diameter));

        return new Info(diameter, height); // Return updated Info object
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

        // Naïve approach result
        System.out.println("Diameter (Naïve O(N²)): " + diameter(root));

        // Optimized approach result
        System.out.println("Diameter (Optimized O(N)): " + diameterOptimized(root).diameter);
    }
}
