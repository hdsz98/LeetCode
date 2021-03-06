package com.tree;
/*
    Easy
        给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。

        高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 */
public class LeetCode0108 {

    public TreeNode build(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, left, mid - 1);
        node.right = build(nums, mid + 1, right);
        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return null;
        int mid = n / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, 0, mid - 1);
        node.right = build(nums, mid + 1, n - 1);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode res = new LeetCode0108().sortedArrayToBST(nums);
    }
}
