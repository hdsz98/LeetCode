package com.tree;
/*
    给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

    例如，从根到叶子节点路径 1->2->3 代表数字 123。

    计算从根到叶子节点生成的所有数字之和。

    说明: 叶子节点是指没有子节点的节点。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 */
public class LeetCode0129 {
    public int res = 0;

    public void dfs(TreeNode node, int sum) {
        if (node.left == null && node.right == null)
            res += sum + node.val;
        if (node.left != null)
            dfs(node.left, (sum + node.val) * 10);
        if (node.right != null)
            dfs(node.right, (sum + node.val) * 10);
    }

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return res;
        if (root.left != null)
            dfs(root.left, root.val * 10);
        if (root.right != null)
            dfs(root.right, root.val * 10);
        return res;
    }
}
