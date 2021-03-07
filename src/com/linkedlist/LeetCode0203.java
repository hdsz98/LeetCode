package com.linkedlist;
/*
    Easy
        删除链表中等于给定值 val 的所有节点。
 */
public class LeetCode0203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode(0, head), pre = res;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                head = head.next;
            }
            else {
                head = head.next;
                pre = pre.next;
            }
        }
        return res.next;
    }
}
