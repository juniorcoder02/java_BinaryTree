public class MaxPathSumBinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static int maxSum; // Stores the maximum path sum

    /**
     * Helper function to calculate the max path sum
     */
    public static int findMaxPathSum(Node root) {
        if (root == null) return 0;

        // Recursively calculate the max sum for left and right subtrees
        int leftSum = Math.max(0, findMaxPathSum(root.left));  // Ignore negative values
        int rightSum = Math.max(0, findMaxPathSum(root.right)); // Ignore negative values

        // Calculate max path sum passing through the current node
        int localMax = leftSum + rightSum + root.data;

        // Update global max sum
        maxSum = Math.max(maxSum, localMax);

        // Return max sum for one path (either left or right)
        return Math.max(leftSum, rightSum) + root.data;
    }

    /**
     * Function to get the maximum path sum
     */
    public static int getMaxPathSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        findMaxPathSum(root);
        return maxSum;
    }

    public static void main(String[] args) {
        // Constructing the binary tree
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);

        System.out.println("Maximum Path Sum: " + getMaxPathSum(root));
    }
}
