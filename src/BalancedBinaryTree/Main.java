package BalancedBinaryTree;

public class Main {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        System.out.println(isBalanced(root)); // should print false
    }
    public static boolean isBalanced(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        int leftHeight = iterateTree(root.left);
        int rightHeight = iterateTree(root.right);
        int difference = Math.abs(leftHeight - rightHeight);
        return difference <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int iterateTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int heightRight = iterateTree(root.right);
        int heightLeft = iterateTree(root.left);
        return Math.max(heightLeft, heightRight) + 1;
    }
}
