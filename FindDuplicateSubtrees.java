import java.util.*;

public class FindDuplicateSubtrees {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Map to store serialized subtree and their frequency
    static Map<String, Integer> subtreeMap;
    static List<Node> duplicateSubtrees;

    /**
     * Function to serialize the tree and find duplicate subtrees
     */
    public static String serializeTree(Node root) {
        if (root == null) return "#"; // Use '#' to represent null nodes
        
        // Serialize the subtree
        String serial = root.data + "," + serializeTree(root.left) + "," + serializeTree(root.right);

        // Store frequency of serialized subtree
        subtreeMap.put(serial, subtreeMap.getOrDefault(serial, 0) + 1);

        // If the subtree appears exactly twice, add to the result list
        if (subtreeMap.get(serial) == 2) {
            duplicateSubtrees.add(root);
        }

        return serial;
    }

    /**
     * Function to find all duplicate subtrees
     */
    public static List<Node> findDuplicateSubtrees(Node root) {
        subtreeMap = new HashMap<>();
        duplicateSubtrees = new ArrayList<>();
        serializeTree(root);
        return duplicateSubtrees;
    }

    /**
     * Function to print a subtree in pre-order format
     */
    public static void printPreOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void main(String[] args) {
        // Constructing the binary tree
        Node root = new Node(1);
        root.left = new Node(4);
        root.right = new Node(3);
        root.left.left = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        root.right.left.left = new Node(3);

        List<Node> duplicates = findDuplicateSubtrees(root);

        System.out.println("Duplicate Subtrees:");
        for (Node node : duplicates) {
            printPreOrder(node);
            System.out.println();
        }
    }
}
