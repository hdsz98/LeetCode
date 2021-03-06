package com.tree;
/*
    Medium
        根据一棵树的前序遍历与中序遍历构造二叉树。
 */
public class LeetCode0105 {
    public TreeNode build (int[] preorder, int[] inorder, int left_pre, int right_pre, int left_in, int right_in) {
        if (left_in > right_in || left_pre > right_pre)
            return null;
        if (left_pre - right_pre == 0)
            return new TreeNode(preorder[left_pre]);
        int index = left_in;
        while (index <= right_in && inorder[index] != preorder[left_pre])
            index++;
        TreeNode node = new TreeNode(preorder[left_pre]);
        node.left = build(preorder, inorder, left_pre + 1, left_pre + index - left_in, left_in, index - 1);
        node.right = build(preorder, inorder, left_pre + index - left_in + 1, right_pre, index + 1, right_in);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0)
            return new TreeNode();
        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public static void main(String[] args) {
        // int[] pre = {3, 9, 20, 15, 7};
        int[] pre = {1, 2};
        // int[] in = {9, 3, 15, 20, 7};
        int[] in = {2, 1};
        TreeNode res = new LeetCode0105().buildTree(pre, in);
    }
}
