package MaximumDepthOfBinarySearchTree;


public class Main {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int depthL = maxDepth(root.left);
        int depthR = maxDepth(root.right);
        return Math.max(depthR,depthL) + 1;
    }


}
