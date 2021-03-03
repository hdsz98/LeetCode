package com.dfs;
/*
    Easy
        给定一个二叉树，判断它是否是高度平衡的二叉树。

        本题中，一棵高度平衡二叉树定义为：

        一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
 */

class TreeNode {
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
public class LeetCode0010 {
    public int judge(TreeNode node, int depth) {
        if (node == null)
            return depth;
        int left = judge(node.left, depth + 1);
        int right = judge(node.right, depth + 1);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;
        return Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return judge(root, 0) >= 0 ? true : false;
    }
}
