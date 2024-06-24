package BinaryTreeInOrderTraversal;

import java.util.ArrayList;
import java.util.List;

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
        TreeNode root = new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null));
        System.out.println(inorderTraversal(root).get(0));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrderRec(root, result);
        return result;
    }

    public static void inOrderRec(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderRec(root.left, list);
        list.add(root.val);
        inOrderRec(root.right, list);
    }
}
