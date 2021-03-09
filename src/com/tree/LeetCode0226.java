package com.tree;
/*
    Easy
        翻转一棵二叉树。
                 4
               /   \
              2     7
             / \   / \
            1   3 6   9

                 4
               /   \
              7     2
             / \   / \
            9   6 3   1
 */
public class LeetCode0226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp_left= root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp_left);
        return root;
    }
}
