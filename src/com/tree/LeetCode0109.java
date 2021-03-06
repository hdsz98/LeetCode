package com.tree;
/*
    Medium
           给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

            本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree

    用两个指针，一块一慢，快的每次走两步，慢的每次走一步，这样当快指针遍历结束时，慢指针指向的也就是链表的中间位置。这时候把中间位置的结点的值作为二叉搜索树当前结点的值
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class LeetCode0109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);
        ListNode pre = head, fast = head, slow = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
            else
                break;
        }
        pre.next = null;
        TreeNode node = new TreeNode(slow.val);
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(slow.next);
        return node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        System.out.println(new LeetCode0109().sortedListToBST(head));
    }
}
