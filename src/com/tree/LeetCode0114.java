package com.tree;

import java.util.stream.Stream;

/*
    Medium
        给你二叉树的根结点 root ，请你将它展开为一个单链表：

        展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
        展开后的单链表应该与二叉树 先序遍历 顺序相同。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 */
public class LeetCode0114 {

    public TreeNode fla(TreeNode node) {
        if (node == null)
            return null;
        if (node.left == null && node.right == null)
            return new TreeNode(node.val);
        TreeNode right = node.right;
        node.right = null;
        TreeNode left = node.left;
        node.left = null;
        TreeNode new_left = fla(left);
        node.right = new_left;
        TreeNode res = node;
        while (res.right != null)
            res = res.right;
        res.right = fla(right);
        return node;
    }

    public void flatten(TreeNode root) {
        fla(root);
    }
}
