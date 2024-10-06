// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class Solution { // Renamed to Solution
    // Helper method to check if a tree is height-balanced
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // Method to check the height of the tree and determine if it's balanced
    private int checkHeight(TreeNode node) {
        // Base case: if the node is null, the height is 0
        if (node == null) {
            return 0;
        }

        // Recursively check the height of the left subtree
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1; // Left subtree is not balanced
        }

        // Recursively check the height of the right subtree
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1; // Right subtree is not balanced
        }

        // If the difference in height between the left and right subtree is greater than 1, return -1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current node's subtrees are not balanced
        }

        // Return the height of the tree rooted at the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Optional: you can keep this if you want to run local tests
    public static void main(String[] args) {
        Solution tree = new Solution();

        // Example: Creating a balanced binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // Check if the tree is balanced
        boolean result = tree.isBalanced(root);
        System.out.println("Is the binary tree balanced? " + result);
    }
}

