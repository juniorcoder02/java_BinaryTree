import java.util.*;

public class TopViewOfTree {
    // Node definition for the binary tree
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Helper class to store node and its horizontal distance (HD)
    static class Info {
        Node node;
        int horDis;

        public Info(Node node, int horDis) {
            this.node = node;
            this.horDis = horDis;
        }
    }

    /**
     * Prints the top view of a binary tree.
     * Approach:
     * 1. Use BFS (level order traversal) with a queue.
     * 2. Maintain a HashMap to store the first node at each horizontal distance.
     * 3. Track the min and max horizontal distances for correct ordering.
     * 
     * Time Complexity: O(N) (since each node is visited once)
     * Space Complexity: O(N) (queue and hashmap storage)
     */
    public static void topView(Node root) {
        if (root == null) return;

        // Queue for level-order traversal (BFS)
        Queue<Info> q = new LinkedList<>();
        // HashMap to store first encountered node at each horizontal distance
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;

        // Start with root at horizontal distance 0
        q.add(new Info(root, 0));

        while (!q.isEmpty()) {
            Info curr = q.poll();
            int hd = curr.horDis;
            Node node = curr.node;

            // Store node if this horizontal distance is encountered for the first time
            if (!map.containsKey(hd)) {
                map.put(hd, node);
            }

            // Add left child with HD - 1
            if (node.left != null) {
                q.add(new Info(node.left, hd - 1));
                min = Math.min(min, hd - 1);
            }

            // Add right child with HD + 1
            if (node.right != null) {
                q.add(new Info(node.right, hd + 1));
                max = Math.max(max, hd + 1);
            }
        }

        // Print the top view nodes in order from min to max horizontal distance
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Constructing the binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);

        // Print the top view
        topView(root);
    }
}
