package com.linkedlist;
/*
    Medium
        给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class LeetCode0019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0, head);
        ListNode temp = head, res = pre;
        for (int i = 0; i < n; i++)
            temp = temp.next;
        while (temp != null) {
            temp = temp.next;
            head = head.next;
            pre = pre.next;
        }
        pre.next = head.next;
        return res.next;
    }
}
