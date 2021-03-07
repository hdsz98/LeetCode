package com.linkedlist;
/*
    Easy
        反转一个单链表。
 */
public class LeetCode0206 {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode pre = new ListNode();
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return pre.next;
    }
}
