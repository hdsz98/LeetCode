package com.tree;

import java.util.ArrayList;
import java.util.List;

/*
    Medium
        给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 */
public class LeetCode0095 {
    public List<TreeNode> generate (int low, int high) {
        List<TreeNode> res = new ArrayList<>();
        if (low > high) {
           res.add(null);
           return res;
        }
        for (int i = low; i <= high; i++) {
            List<TreeNode> left_nodes = generate(low, i - 1);
            List<TreeNode> right_nodes = generate(i + 1, high);
            for (TreeNode left_node : left_nodes) {
                for (TreeNode right_node : right_nodes) {
                    TreeNode node = new TreeNode(i);
                    node.left = left_node;
                    node.right = right_node;
                    res.add(node);
                }
            }
        }
        return res;
    }
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return generate(1, n);
    }
}
