package com.linkedlist;

import java.util.List;
/*
    Medium
        给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 */
public class LeetCode0061 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null)
            return head;
        int n = 0;
        ListNode pre = head, after = head;
        while (pre != null) {
            pre = pre.next;
            n++;
        }
        k = (n - k % n) % n;
        if (k == 0)
            return head;
        pre = head;
        for (int i = 0; i < k; i++) {
            pre = after;
            after = after.next;
        }
        ListNode temp = head;
        head = after;
        pre.next = null;
        while (after.next != null)
            after = after.next;
        after.next = temp;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);
        ListNode res = new LeetCode0061().rotateRight(head, 3);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
