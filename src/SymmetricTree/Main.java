package SymmetricTree;

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
        TreeNode p = new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        TreeNode q = new TreeNode(1,new TreeNode(2,new TreeNode(5),new TreeNode(4)),new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println(isSymmetric(p));
    }
    public static boolean isSymmetric(TreeNode root) {
        if (root != null){
            return isMirror(root.left, root.right);
        }
        return false;
    }

    public static boolean isMirror(TreeNode left, TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
