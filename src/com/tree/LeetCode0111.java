package com.tree;
/*
    Easy
        给定一个二叉树，找出其最小深度。

        最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class LeetCode0111 {
    public int min = Integer.MAX_VALUE;
    public void depth(TreeNode node, int depth) {
        if (node == null)
            return;
        if (node.left == null && node.right == null)
            min = min > depth ? depth : min;
        depth(node.left, depth + 1);
        depth(node.right, depth + 1);
    }
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        depth(root, 1);
        return min;
    }
}
