package com.tree;
/*
    Easy
        给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

        百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree

    利用二叉搜索树的特性：
        如果p和q的值都小于跟节点  则祖先在左子树
        如果p和q的值都大于跟节点  则祖先在又子树
        不然根节点就是最近的祖先
 */
public class LeetCode0235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else if (p.val < root.val && q.val < root.val)
            return  lowestCommonAncestor(root.left, p, q);
        return root;
    }
}
