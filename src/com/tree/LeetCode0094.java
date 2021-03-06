package com.tree;
/*
    Medium
        给定一个二叉树的根节点 root ，返回它的 中序 遍历
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode0094 {
    List<Integer> res = new ArrayList<>();
    // 递归方法
    public void inOrderRecursion(TreeNode node) {
        if (node == null)
            return;
        inOrderRecursion(node.left);
        res.add(node.val);
        inOrderRecursion(node.right);
    }
    // 基于栈
    public void inOrderStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        inOrderStack(root);
        return res;
    }
}
