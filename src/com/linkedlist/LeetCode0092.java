package com.linkedlist;

import java.util.List;

/*
    Medium
        反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
        说明:
        1 ≤ m ≤ n ≤ 链表长度。
 */
public class LeetCode0092 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = new ListNode(0, head), after = pre.next, res = pre;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
            after = after.next;
        }
        pre.next = null;
        ListNode temp = new ListNode();
        for (int i = 0; i <= right - left; i++) {
            temp = after;
            after = after.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        while (pre.next != null)
            pre = pre.next;
        pre.next = after;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = new LeetCode0092().reverseBetween(head, 2, 4);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
