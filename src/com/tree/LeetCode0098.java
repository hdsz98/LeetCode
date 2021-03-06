package com.tree;
/*
    Medium
        给定一个二叉树，判断其是否是一个有效的二叉搜索树。

        假设一个二叉搜索树具有如下特征：
            节点的左子树只包含小于当前节点的数。
            节点的右子树只包含大于当前节点的数。
            所有左子树和右子树自身必须也是二叉搜索树。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 */
public class LeetCode0098 {
    public boolean validate(TreeNode node, long min, long max) {
        if (node == null)
            return true;
        if (node.val <= min || node.val >= max)
            return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
