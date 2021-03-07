package com.tree;


import java.util.*;

/*
    给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class LeetCode0144 {
    List<Integer> res = new ArrayList<>();
    public void recursion (TreeNode node) {
        if (node == null)
            return;
        res.add(node.val);
        recursion(node.left);
        recursion(node.right);
    }
    public void iteration(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (node == null)
                continue;
            res.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        iteration(root);
        return res;
    }
}
