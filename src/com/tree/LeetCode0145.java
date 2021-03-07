package com.tree;

import java.util.List;

public class LeetCode0145 {
    public List<Integer> res;
    public void recursion (TreeNode node) {
        if (node == null)
            return;
        recursion(node.left);
        recursion(node.right);
        res.add(node.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        recursion(root);
        return res;
    }
}
