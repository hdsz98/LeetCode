package com.tree;
/*
    Easy
        给定一个二叉树，检查它是否是镜像对称的。
 */
public class LeetCode0101 {
    public boolean validate(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (!(left != null && right != null))
            return false;
        if (left.val != right.val)
            return false;
        return validate(left.left, right.right) && validate(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return validate(root.left, root.right);
    }
}
