package com.tree;
/*
    Easy
        给定一个二叉树，判断它是否是高度平衡的二叉树。
 */
public class LeetCode0110 {
    public int depth (TreeNode node) {
        if (node == null)
            return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;
        return Math.max(left, right) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        return depth(root) == -1 ? false : true;
    }
}
