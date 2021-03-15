package com.tree;

import java.util.ArrayList;
import java.util.List;

/*
    Medium
        给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

        叶子节点 是指没有子节点的节点。
        示例 1：
        输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
        输出：[[5,4,11,2],[5,8,4,5]]

 */
public class LeetCode0113 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> path = new ArrayList<>();
    public void dfs(TreeNode node, int target) {
        path.add(node.val);
        if (node.left == null && node.right == null) {
            if (target - node.val == 0)
                res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        if (node.left != null)
            dfs(node.left, target - node.val);
        if (node.right != null)
            dfs(node.right, target - node.val);
        path.remove(path.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return res;
        dfs(root, targetSum);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4); root.right = new TreeNode(8);
        root.left.left = new TreeNode(11); root.right.left = new TreeNode(13);  root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7); root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        List<List<Integer>> res = new LeetCode0113().pathSum(root, 22);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++)
                System.out.print(res.get(i).get(j) + " ");
            System.out.println(" ");
        }
    }
}
